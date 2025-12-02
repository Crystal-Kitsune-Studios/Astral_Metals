package com.astralmetals;

import com.astralmetals.registry.AstralMetalsContent;
import com.astralmetals.registry.AstralTools;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;

public class AstralMetalsMain implements ModInitializer {

    public static final String MOD_ID = "astralmetals";

    @Override
    public void onInitialize() {
        System.out.println("[Astral Metals] Initializing Astral Metals...");

        // === Base Metals, Ores, and Blocks ===
        AstralMetalsContent.registerAllContent();

        // === Tool Sets ===
        AstralTools.registerTools();

        // === Alloy Forge / Recipes ===
        registerRecipes();

        System.out.println("[Astral Metals] Initialization complete!");
    }

    private void registerRecipes() {
        // Placeholder if you later add custom serializers for the Alloy Forge
        // Example:
        // Registry.register(Registries.RECIPE_SERIALIZER,
        //        new Identifier(MOD_ID, "alloy_forge"),
        //        AlloyForgeRecipeSerializer.INSTANCE);
    }
}
