package net.primal.enhancedend.Item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup ENHANCED_END_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(EnhancedEnd.MOD_ID, "end_tanzanite_ore"), () -> new ItemStack(ModBlocks.END_TANZANITE_ORE));

    public static final ItemGroup ENHANCED_END_ITEMS = FabricItemGroupBuilder.build(
            new Identifier(EnhancedEnd.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
