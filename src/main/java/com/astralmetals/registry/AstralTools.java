package com.astralmetals.registry;

import com.astralmetals.material.AstralToolMaterials;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;

public final class AstralTools {
    private static final AstralToolMaterials TIER = AstralToolMaterials.TUNGSTEN_STEEL;
    public static final DeferredItem<SwordItem> TUNGSTEN_STEEL_SWORD = AstralMetalsContent.ITEMS.register("tungsten_steel_sword",
        () -> new SwordItem(TIER, new Item.Properties().attributes(SwordItem.createAttributes(TIER, 4, -2.4F))));
    public static final DeferredItem<PickaxeItem> TUNGSTEN_STEEL_PICKAXE = AstralMetalsContent.ITEMS.register("tungsten_steel_pickaxe",
        () -> new PickaxeItem(TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(TIER, 2, -2.8F))));
    public static final DeferredItem<AxeItem> TUNGSTEN_STEEL_AXE = AstralMetalsContent.ITEMS.register("tungsten_steel_axe",
        () -> new AxeItem(TIER, new Item.Properties().attributes(AxeItem.createAttributes(TIER, 6.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> TUNGSTEN_STEEL_SHOVEL = AstralMetalsContent.ITEMS.register("tungsten_steel_shovel",
        () -> new ShovelItem(TIER, new Item.Properties().attributes(ShovelItem.createAttributes(TIER, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> TUNGSTEN_STEEL_HOE = AstralMetalsContent.ITEMS.register("tungsten_steel_hoe",
        () -> new HoeItem(TIER, new Item.Properties().attributes(HoeItem.createAttributes(TIER, -3, 0.0F))));
    public static final DeferredItem<SwordItem> ORITHICHALITE_SWORD = AstralMetalsContent.ITEMS.register("orithichalite_sword",
        () -> new SwordItem(AstralToolMaterials.ORITHICHALITE, new Item.Properties().attributes(
            SwordItem.createAttributes(AstralToolMaterials.ORITHICHALITE, 3, -2.4F))));
    public static void initialize() {} // Triggers deferred declarations, never resolves registry values here.
    private AstralTools() {}
}
