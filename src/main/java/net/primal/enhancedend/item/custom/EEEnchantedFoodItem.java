package net.primal.enhancedend.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EEEnchantedFoodItem extends Item {
    public EEEnchantedFoodItem(Item.Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
