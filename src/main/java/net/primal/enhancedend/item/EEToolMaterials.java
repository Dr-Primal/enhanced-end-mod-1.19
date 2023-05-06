package net.primal.enhancedend.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum EEToolMaterials implements ToolMaterial {
    ENDIMINTIUM(107, 10000, 225.0f, 8.0f, 100,
            () -> Ingredient.ofItems(EEItems.ENDIMINTIUM_SCRAP)),
    CLITANIUM(3, 500, 12.0f, 3.0f, 10,
            () -> Ingredient.ofItems(EEItems.CLITANIUM));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    EEToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                    int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}