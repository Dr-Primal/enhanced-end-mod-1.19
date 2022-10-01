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
import net.primal.enhancedend.block.custom.*;
import net.primal.enhancedend.block.entity.ModSignTypes;
import net.primal.enhancedend.world.feature.tree.CorliteSaplingGenerator;
import net.primal.enhancedend.world.feature.tree.MidnightSaplingGenerator;

public class ModBlocks {
    //Ores
    public static final Block END_TANZANITE_ORE = registerBlock("end_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(0, 0)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block END_CLITANIUM_ORE = registerBlock("end_clitanium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block ENDIMINTIUM_BLOCK = registerBlock("endimintium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(80f, 1700f).requiresTool().sounds(BlockSoundGroup.NETHERITE)),
            ModItemGroup.ENHANCED_END_BLOCKS);

//Tanzanite Variants
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block RAW_TANZANITE_BLOCK = registerBlock("raw_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);

//Clitanium Variants
    public static final Block CLITANIUM_BLOCK = registerBlock("clitanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().sounds(BlockSoundGroup.COPPER)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_DOOR = registerBlock("clitanium_door",
            new DoorBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_TRAPDOOR = registerBlock("clitanium_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_BARS = registerBlock("clitanium_bars",
            new PaneBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)), ModItemGroup.ENHANCED_END_BLOCKS);

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
            new NyliumBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_END_STONE = registerBlock("corlite_end_stone",
            new NyliumBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    //Midnight Wood Variants
    public static final Block MIDNIGHT_STEM = registerBlock("midnight_stem",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_STEM = registerBlock("stripped_midnight_stem",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_HYPHAE = registerBlock("midnight_hyphae",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_HYPHAE = registerBlock("stripped_midnight_hyphae",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
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
    public static final Block MIDNIGHT_DOOR = registerBlock("midnight_door",
            new DoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_TRAPDOOR = registerBlock("midnight_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("midnight_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.MIDNIGHT), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block MIDNIGHT_SIGN_BLOCK = registerBlockWithoutBlockItem("midnight_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.MIDNIGHT), ModItemGroup.ENHANCED_END_BLOCKS);

//Corlite Wood Variants
    public static final Block CORLITE_STEM = registerBlock("corlite_stem",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_CORLITE_STEM = registerBlock("stripped_corlite_stem",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_HYPHAE = registerBlock("corlite_hyphae",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_CORLITE_HYPHAE = registerBlock("stripped_corlite_hyphae",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.NETHER_STEM)),
            ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_PLANKS = registerBlock("corlite_planks",
            new Block(FabricBlockSettings.copy(Blocks.CRIMSON_PLANKS).strength(2F, 3F).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_FENCE = registerBlock("corlite_fence",
            new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_FENCE_GATE = registerBlock("corlite_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f,3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_STAIRS = registerBlock("corlite_stairs",
            new ModStairsBlock(ModBlocks.MIDNIGHT_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_SLAB = registerBlock("corlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_BUTTON = registerBlock("corlite_button",
            new ModWoodenButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD).strength(0.5f, 1f).noCollision().sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_PRESSURE_PLATE = registerBlock("corlite_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD).strength(0.5f, 1f).sounds(BlockSoundGroup.WOOD)),
            ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_DOOR = registerBlock("corlite_door",
            new DoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_TRAPDOOR = registerBlock("corlite_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("corlite_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.CORLITE), ModItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_SIGN_BLOCK = registerBlockWithoutBlockItem("corlite_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.CORLITE), ModItemGroup.ENHANCED_END_BLOCKS);
    //Blots and Mushrooms
    public static final Block MIDNIGHT_MUSHROOM = registerBlock("midnight_mushroom",
            new ModMagicMushroomBlock(new MidnightSaplingGenerator(),
                    FabricBlockSettings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS)), ModItemGroup.ENHANCED_END_ITEMS);
    public static final Block CORLITE_MUSHROOM = registerBlock("corlite_mushroom",
            new ModMagicMushroomBlock(new CorliteSaplingGenerator(),
                    FabricBlockSettings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS)), ModItemGroup.ENHANCED_END_ITEMS);
    public static final Block MIDNIGHT_BLOTS = registerBlock("midnight_blots",
            new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0f).sounds(BlockSoundGroup.WART_BLOCK)), ModItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_BLOTS = registerBlock("corlite_blots",
            new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0f).sounds(BlockSoundGroup.WART_BLOCK)), ModItemGroup.ENHANCED_END_BLOCKS);
    //Endium and End Matter
    public static final Block ENDIUM_SOIL = registerBlock("endium_soil",
            new Block(FabricBlockSettings.of(Material.SOIL).strength(1f).requiresTool().sounds(BlockSoundGroup.SOUL_SOIL)),
            ModItemGroup.ENHANCED_END_BLOCKS);





    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(EnhancedEnd.MOD_ID, name), block);
    }
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
