package com.astralmetals.registry;

import com.astralmetals.AstralMetalsMain;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class AstralMetalsContent {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AstralMetalsMain.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AstralMetalsMain.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstralMetalsMain.MOD_ID);
    public static final String[] METALS = {"copper", "tin", "zinc", "lead", "nickel", "aluminum", "silver", "gold", "platinum", "steel", "bronze", "brass", "tungsten", "titanium", "osmium", "uranium", "ardanium", "orithichalite", "arthilite", "adamantite", "vibranite", "aetherite", "cobaltite", "iridite", "chromite", "celestrium", "luminite", "necronium", "solarium", "ecliptite", "neutronium", "gravitite", "chronotite", "aetherium", "voidsteel"};
    private static final Map<String, DeferredItem<Item>> INGOTS = new LinkedHashMap<>();
    private static final Map<String, DeferredItem<Item>> RAW = new LinkedHashMap<>();
    private static final Map<String, DeferredBlock<Block>> ORES = new LinkedHashMap<>();
    private static final Map<String, DeferredBlock<Block>> STORAGE = new LinkedHashMap<>();
    public static final DeferredItem<Item> TUNGSTEN_STEEL_INGOT;
    public static final DeferredItem<Item> ORITHICHALITE_SCRAP;
    public static final DeferredItem<Item> OVERWORLD_UPGRADE_TEMPLATE;

    static {
        for (String metal : METALS) {
            // Keep IDs stable even with Create installed. Shared tags enable recipe interoperability.
            INGOTS.put(metal, ITEMS.registerSimpleItem(metal + "_ingot"));
            RAW.put(metal, ITEMS.registerSimpleItem("raw_" + metal));
            DeferredBlock<Block> ore = BLOCKS.registerSimpleBlock(metal + "_ore",
                BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops().lightLevel(state -> metal.equals("ardanium") ? 6 : 0));
            ORES.put(metal, ore);
            ITEMS.registerSimpleBlockItem(metal + "_ore", ore);
            DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(metal + "_block",
                BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL)
                    .strength(5.0F, 6.0F).requiresCorrectToolForDrops());
            STORAGE.put(metal, block);
            ITEMS.registerSimpleBlockItem(metal + "_block", block);
        }
        TUNGSTEN_STEEL_INGOT = ITEMS.registerSimpleItem("tungsten_steel_ingot");
        ORITHICHALITE_SCRAP = ITEMS.registerSimpleItem("orithichalite_scrap");
        OVERWORLD_UPGRADE_TEMPLATE = ITEMS.registerSimpleItem("overworld_upgrade_smithing_template");
        TABS.register("astralmetals", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.astralmetals"))
            .icon(() -> TUNGSTEN_STEEL_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> ITEMS.getEntries().forEach(entry -> output.accept(entry.get())))
            .build());
    }
    public static DeferredItem<Item> getIngot(String metal) { return INGOTS.get(metal); }
    private AstralMetalsContent() {}
}
