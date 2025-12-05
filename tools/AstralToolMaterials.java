package com.astralmetals.material;

import com.astralmetals.registry.AstralMetalsContent;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum AstralToolMaterials implements ToolMaterial {
    TUNGSTEN_STEEL(5, 2700, 7.0F, 5.5F, 12,
            () -> Ingredient.ofItems(AstralMetalsContent.getIngot("tungsten_steel")));

    private final int miningLevel;
    private final int durability;
    private final float speed;
    private final float damage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    AstralToolMaterials(int miningLevel, int durability, float speed, float damage,
                        int enchantability, java.util.function.Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.speed = speed;
        this.damage = damage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override public int getDurability() { return durability; }
    @Override public float getMiningSpeedMultiplier() { return speed; }
    @Override public float getAttackDamage() { return damage; }
    @Override public int getMiningLevel() { return miningLevel; }
    @Override public int getEnchantability() { return enchantability; }
    @Override public Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
