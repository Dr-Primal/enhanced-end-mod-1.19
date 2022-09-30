package net.primal.enhancedend.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EndimintiumItem extends Item {
    public EndimintiumItem(Item.Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
