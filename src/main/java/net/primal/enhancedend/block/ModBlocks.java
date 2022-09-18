package net.primal.enhancedend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.Item.ModItemGroup;

public class ModBlocks {
    public static final Block END_TANZANITE_ORE = registerBlock("end_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block END_CLITANIUM_ORE = registerBlock("end_clitanium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_BLOCK = registerBlock("clitanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.COPPER)),
            ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block RAW_TANZANITE_BLOCK = registerBlock("raw_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(EnhancedEnd.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancedEnd.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }


    public static void registerModBlocks() {
        EnhancedEnd.LOGGER.debug("Registering ModBlocks for " + EnhancedEnd.MOD_ID);
    }
}
