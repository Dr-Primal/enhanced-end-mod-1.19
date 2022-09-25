package net.primal.enhancedend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.Item.ModItemGroup;
import net.primal.enhancedend.block.custom.ModPressurePlateBlock;
import net.primal.enhancedend.block.custom.ModStairsBlock;
import net.primal.enhancedend.block.custom.ModStoneButtonBlock;
import net.primal.enhancedend.block.custom.ModWoodenButtonBlock;

public class ModBlocks {
    //Ores
    public static final Block END_TANZANITE_ORE = registerBlock("end_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(0, 0)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block END_CLITANIUM_ORE = registerBlock("end_clitanium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.ENHANCED_END_BLOCKS);
//Ore Blocks
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_BLOCK = registerBlock("clitanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.COPPER)),
            ModItemGroup.ENHANCED_END_BLOCKS);
//Raw Blocks
    public static final Block RAW_TANZANITE_BLOCK = registerBlock("raw_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
//Silstone Blocks
    public static final Block SILSTONE = registerBlock("silstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE = registerBlock("cobbled_silstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICKS = registerBlock("silstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CHISELED_SILSTONE = registerBlock("chiseled_silstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            ModItemGroup.ENHANCED_END_BLOCKS);
//Silstone Redstone Variants
    public static final Block SILSTONE_BUTTON = registerBlock("silstone_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(0.5f).requiresTool().noCollision().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_PRESSURE_PLATE = registerBlock("silstone_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.STONE).strength(0.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Silstone Variants
    public static final Block SILSTONE_STAIRS = registerBlock("silstone_stairs",
            new ModStairsBlock(ModBlocks.SILSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_SLAB = registerBlock("silstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Cobbled Silstone
    public static final Block COBBLED_SILSTONE_STAIRS = registerBlock("cobbled_silstone_stairs",
            new ModStairsBlock(ModBlocks.COBBLED_SILSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE_SLAB = registerBlock("cobbled_silstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE_WALL = registerBlock("cobbled_silstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Silstone Bricks
    public static final Block SILSTONE_BRICK_STAIRS = registerBlock("silstone_brick_stairs",
            new ModStairsBlock(ModBlocks.SILSTONE_BRICKS.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICK_SLAB = registerBlock("silstone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICK_WALL = registerBlock("silstone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Kimberlite
    public static final Block KIMBERLITE = registerBlock("kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE = registerBlock("polished_kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block KIMBERLITE_PILLAR = registerBlock("kimberlite_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Kimberlite Variants
    public static final Block KIMBERLITE_STAIRS = registerBlock("kimberlite_stairs",
            new ModStairsBlock(ModBlocks.KIMBERLITE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block KIMBERLITE_SLAB = registerBlock("kimberlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block INFUSED_KIMBERLITE = registerBlock("infused_kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Polished Kimberlite Variants
    public static final Block POLISHED_KIMBERLITE_STAIRS = registerBlock("polished_kimberlite_stairs",
            new ModStairsBlock(ModBlocks.KIMBERLITE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE_SLAB = registerBlock("polished_kimberlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE_WALL = registerBlock("polished_kimberlite_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //End stone Blocks
    public static final Block MIDNIGHT_END_STONE = registerBlock("midnight_end_stone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_END_STONE = registerBlock("corlite_end_stone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Midnight Wood Variants
    public static final Block MIDNIGHT_LOG = registerBlock("midnight_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_STEM).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_LOG = registerBlock("stripped_midnight_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_STEM).strength(2.0F, 3.0F).breakInstantly().sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_WOOD = registerBlock("midnight_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.CRIMSON_HYPHAE).strength(2F, 3F).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_WOOD = registerBlock("stripped_midnight_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_CRIMSON_HYPHAE).strength(2F, 3F).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_PLANKS = registerBlock("midnight_planks",
            new Block(FabricBlockSettings.copy(Blocks.CRIMSON_PLANKS).strength(2F, 3F).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_FENCE = registerBlock("midnight_fence",
            new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block MIDNIGHT_FENCE_GATE = registerBlock("midnight_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f,3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_STAIRS = registerBlock("midnight_stairs",
            new ModStairsBlock(ModBlocks.MIDNIGHT_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_SLAB = registerBlock("midnight_slab",
            new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_BUTTON = registerBlock("midnight_button",
            new ModWoodenButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(0.5f, 1f).noCollision().sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_PRESSURE_PLATE = registerBlock("midnight_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD).strength(0.5f, 1f).sounds(BlockSoundGroup.WOOD)),
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
