package com.astralmetals;

import com.astralmetals.registry.AstralMetalsContent;
import com.astralmetals.material.AstralToolMaterials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.server.MinecraftServer;
import net.neoforged.testframework.junit.EphemeralTestServerProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EphemeralTestServerProvider.class)
class AstralMetalsSmokeTest {
    private static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath("astralmetals", name);
    }
    @Test void registersAllContent(MinecraftServer server) {
        for (String metal : AstralMetalsContent.METALS) {
            assertTrue(BuiltInRegistries.ITEM.containsKey(id(metal + "_ingot")), metal);
            assertTrue(BuiltInRegistries.ITEM.containsKey(id("raw_" + metal)), metal);
            assertTrue(BuiltInRegistries.BLOCK.containsKey(id(metal + "_ore")), metal);
            assertTrue(BuiltInRegistries.BLOCK.containsKey(id(metal + "_block")), metal);
        }
        for (String name : new String[]{"tungsten_steel_ingot", "tungsten_steel_sword", "tungsten_steel_pickaxe",
                "tungsten_steel_axe", "tungsten_steel_shovel", "tungsten_steel_hoe", "orithichalite_sword",
                "orithichalite_scrap", "overworld_upgrade_smithing_template", "music_disc_x3n0_my_world"}) {
            assertTrue(BuiltInRegistries.ITEM.containsKey(id(name)), name);
        }
        assertFalse(AstralToolMaterials.TUNGSTEN_STEEL.getRepairIngredient().isEmpty());
    }
    @Test void loadsEveryRecipe(MinecraftServer server) {
        long loaded = server.getRecipeManager().getRecipes().stream()
            .filter(recipe -> recipe.id().getNamespace().equals("astralmetals")).count();
        assertEquals(184L, loaded, "Every recipe must decode successfully");
        assertTrue(server.getRecipeManager().byKey(id("smithing/diamond_to_orithichalite")).isPresent());
    }
    @Test void loadsWorldgenAndMusic(MinecraftServer server) {
        var features = server.registryAccess().registryOrThrow(Registries.PLACED_FEATURE);
        for (String name : new String[]{"adamantite_ore_placed", "ardanium_ore", "arthilite_ore_placed", "orithichalite_ore_placed"}) {
            assertNotNull(features.get(id(name)), name);
        }
        assertNotNull(server.registryAccess().registryOrThrow(Registries.JUKEBOX_SONG).get(id("x3n0_my_world")));
        for (String metal : AstralMetalsContent.METALS) {
            for (String suffix : new String[]{"_ore", "_block"}) {
                var key = ResourceKey.create(Registries.LOOT_TABLE, id("blocks/" + metal + suffix));
                assertNotSame(LootTable.EMPTY, server.reloadableRegistries().getLootTable(key), key.toString());
            }
        }
    }
    @Test void hasModelsAndNames(MinecraftServer server) {
        var language = com.google.gson.JsonParser.parseReader(new java.io.InputStreamReader(
            getClass().getResourceAsStream("/assets/astralmetals/lang/en_us.json"), java.nio.charset.StandardCharsets.UTF_8)).getAsJsonObject();
        BuiltInRegistries.ITEM.entrySet().stream()
            .filter(entry -> entry.getKey().location().getNamespace().equals("astralmetals"))
            .forEach(entry -> {
                String name = entry.getKey().location().getPath();
                assertNotNull(getClass().getResource("/assets/astralmetals/models/item/" + name + ".json"), name);
                assertTrue(language.has(entry.getValue().getDescriptionId()), name);
            });
    }
    @Test void injectsOreFeaturesIntoBiomes(MinecraftServer server) {
        var biomes = server.registryAccess().registryOrThrow(Registries.BIOME);
        var features = server.registryAccess().registryOrThrow(Registries.PLACED_FEATURE);
        var adamantite = features.get(id("adamantite_ore_placed"));
        var ardanium = features.get(id("ardanium_ore"));
        assertTrue(biomes.get(Biomes.PLAINS).getGenerationSettings().features().stream()
            .flatMap(set -> set.stream()).anyMatch(holder -> holder.value() == adamantite));
        assertTrue(biomes.get(Biomes.NETHER_WASTES).getGenerationSettings().features().stream()
            .flatMap(set -> set.stream()).anyMatch(holder -> holder.value() == ardanium));
    }
}
