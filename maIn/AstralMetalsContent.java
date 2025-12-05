package com.astralmetals.registry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

/**
 * Astral Metals - Core Content Registry
 * Handles registration of all metals, ores, raw forms, and storage blocks.
 */
public class AstralMetalsContent {

    public static final String MOD_ID = "astralmetals";

    private static final Map<String, Item> INGOTS = new HashMap<>();
    private static final Map<String, Item> RAW_MATERIALS = new HashMap<>();
    private static final Map<String, Block> ORES = new HashMap<>();
    private static final Map<String, Block> STORAGE_BLOCKS = new HashMap<>();

    // === MASTER METAL LIST ===
 // === MASTER METAL LIST ===
    private static final String[] KNOWN_METALS = {
        // Base
        "copper", "tin", "zinc", "lead", "nickel", "aluminum", "silver", "gold", "platinum",
        // Industrial
        "steel", "bronze", "brass", "tungsten", "titanium", "osmium", "uranium",
        // Nether / Infernal
        "ardanium",
        // Overworld / High-Tier
        "orithichalite", "arthilite", "adamantite",
        // Advanced
        "vibranite", "aetherite", "cobaltite", "iridite", "chromite",
        // Astral
        "celestrium", "luminite", "necronium", "solarium", "ecliptite",
        // Mythic / Quantum
        "neutronium", "gravitite", "chronotite", "aetherium", "voidsteel"
    };


    public static void registerAllContent() {
        boolean createLoaded = FabricLoader.getInstance().isModLoaded("create");

        System.out.println("[Astral Metals] Registering all metals...");

        for (String metal : KNOWN_METALS) {
            // Skip Create's own metals if mod is present
            if (createLoaded && (metal.equals("zinc") || metal.equals("brass"))) {
                System.out.println("[Astral Metals] Skipping " + metal + " (Create handles it)");
                continue;
            }

            // === INGOT ===
            String ingotId = metal + "_ingot";
            Item ingot = registerItem(ingotId, new Item(new Item.Settings()));
            INGOTS.put(metal, ingot);

            // === RAW FORM ===
            String rawId = "raw_" + metal;
            Item raw = registerItem(rawId, new Item(new Item.Settings()));
            RAW_MATERIALS.put(metal, raw);

            // === ORE BLOCKS ===
            Block ore;
            if (metal.equals("ardanium")) {
                // Nether ore variant: faint glow, higher blast resistance
                ore = registerBlock(metal + "_ore",
                        new Block(AbstractBlock.Settings.of(Material.STONE)
                                .strength(5.0F, 8.0F)
                                .requiresTool()
                                .luminance(state -> 6)));
            } else {
                ore = registerBlock(metal + "_ore",
                        new Block(AbstractBlock.Settings.of(Material.STONE)
                                .strength(3.0F, 3.0F)
                                .requiresTool()));
            }
            ORES.put(metal, ore);

            // === STORAGE BLOCKS ===
            Block storage = registerBlock(metal + "_block",
                    new Block(AbstractBlock.Settings.of(Material.METAL)
                            .strength(5.0F, 6.0F)
                            .requiresTool()));
            STORAGE_BLOCKS.put(metal, storage);
        }

        System.out.println("[Astral Metals] All content registered.");
    }

    // === HELPERS ===
    private static Item registerItem(String name, Item item) {
        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registries.ITEM, id, item);
        return item;
    }

    private static Block registerBlock(String name, Block block) {
        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    // === ACCESSORS ===
    public static Item getIngot(String metal) { return INGOTS.get(metal); }
    public static Item getRaw(String metal) { return RAW_MATERIALS.get(metal); }
    public static Block getOre(String metal) { return ORES.get(metal); }
    public static Block getBlock(String metal) { return STORAGE_BLOCKS.get(metal); }
}
