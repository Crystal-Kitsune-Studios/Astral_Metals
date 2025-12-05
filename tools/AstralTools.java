package com.astralmetals.registry;

import com.astralmetals.material.AstralToolMaterials;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AstralTools {

    public static final Item TUNGSTEN_STEEL_SWORD = new SwordItem(AstralToolMaterials.TUNGSTEN_STEEL, 4, -2.4F, new Item.Settings());
    public static final Item TUNGSTEN_STEEL_PICKAXE = new PickaxeItem(AstralToolMaterials.TUNGSTEN_STEEL, 2, -2.8F, new Item.Settings());
    public static final Item TUNGSTEN_STEEL_AXE = new AxeItem(AstralToolMaterials.TUNGSTEN_STEEL, 6.0F, -3.2F, new Item.Settings());
    public static final Item TUNGSTEN_STEEL_SHOVEL = new ShovelItem(AstralToolMaterials.TUNGSTEN_STEEL, 1.5F, -3.0F, new Item.Settings());
    public static final Item TUNGSTEN_STEEL_HOE = new HoeItem(AstralToolMaterials.TUNGSTEN_STEEL, -3, 0.0F, new Item.Settings());

    public static void registerTools() {
        register("tungsten_steel_sword", TUNGSTEN_STEEL_SWORD);
        register("tungsten_steel_pickaxe", TUNGSTEN_STEEL_PICKAXE);
        register("tungsten_steel_axe", TUNGSTEN_STEEL_AXE);
        register("tungsten_steel_shovel", TUNGSTEN_STEEL_SHOVEL);
        register("tungsten_steel_hoe", TUNGSTEN_STEEL_HOE);
        System.out.println("[Astral Metals] Registered Tungsten-Steel tools.");
    }

    private static void register(String id, Item item) {
        Registry.register(Registries.ITEM, new Identifier("astralmetals", id), item);
    }
}
