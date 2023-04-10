package net.primal.enhancedend.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.primal.enhancedend.Item.ModItems;

public class ModRuneItem extends Item {
    public ModRuneItem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
