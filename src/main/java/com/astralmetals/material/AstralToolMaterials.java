package com.astralmetals.material;

import com.astralmetals.registry.AstralMetalsContent;
import java.util.function.Supplier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum AstralToolMaterials implements Tier {
    TUNGSTEN_STEEL(2700, 7.0F, 5.5F, 12,
        () -> Ingredient.of(AstralMetalsContent.TUNGSTEN_STEEL_INGOT.get())),
    // Provisional diamond-like stats for the existing smithing recipe.
    ORITHICHALITE(1561, 8.0F, 3.0F, 10,
        () -> Ingredient.of(AstralMetalsContent.getIngot("orithichalite").get()));

    private final int uses;
    private final float speed, damage;
    private final int enchantability;
    private final Supplier<Ingredient> repair;
    AstralToolMaterials(int uses, float speed, float damage, int enchantability, Supplier<Ingredient> repair) {
        this.uses = uses; this.speed = speed; this.damage = damage;
        this.enchantability = enchantability; this.repair = repair;
    }
    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return damage; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
    @Override public TagKey<Block> getIncorrectBlocksForDrops() { return BlockTags.INCORRECT_FOR_NETHERITE_TOOL; }
}
