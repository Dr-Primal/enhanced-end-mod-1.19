package net.primal.enhancedend.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModEnchantedFoodItem extends Item {
    public ModEnchantedFoodItem(Item.Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
