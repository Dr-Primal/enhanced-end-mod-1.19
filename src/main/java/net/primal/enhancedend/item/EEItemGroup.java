package net.primal.enhancedend.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.block.EEBlocks;

public class EEItemGroup {
    public static final ItemGroup ENHANCED_END_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(EnhancedEnd.MOD_ID, "end_tanzanite_ore"), () -> new ItemStack(EEBlocks.END_TANZANITE_ORE));

    public static final ItemGroup ENHANCED_END_ITEMS = FabricItemGroupBuilder.build(
            new Identifier(EnhancedEnd.MOD_ID, "tanzanite"), () -> new ItemStack(EEItems.TANZANITE));

    public static final ItemGroup ENHANCED_END_DECORATIONS = FabricItemGroupBuilder.build(
            new Identifier(EnhancedEnd.MOD_ID, "endium_mushroom"), () -> new ItemStack(EEBlocks.ENDIUM_MUSHROOM));
}
