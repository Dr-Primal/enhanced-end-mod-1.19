package net.primal.enhancedend.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.item.EEItemGroup;
import net.primal.enhancedend.block.custom.*;
import net.primal.enhancedend.block.entity.EESignTypes;
import net.primal.enhancedend.world.feature.tree.CorliteSaplingGenerator;
import net.primal.enhancedend.world.feature.tree.EndiumMushroomGenerator;
import net.primal.enhancedend.world.feature.tree.MidnightSaplingGenerator;

public class EEBlocks {
    //Ores
    public static final Block END_TANZANITE_ORE = registerBlock("end_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.PALE_YELLOW)
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block END_CLITANIUM_ORE = registerBlock("end_clitanium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE, MapColor.PALE_YELLOW)
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(0, 0)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block ENDIMINTIUM_BLOCK = registerBlock("endimintium_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.TERRACOTTA_WHITE)
                    .strength(100f, 2000f).requiresTool().sounds(BlockSoundGroup.NETHERITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

//Tanzanite Variants
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.MAGENTA)
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.METAL)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block RAW_TANZANITE_BLOCK = registerBlock("raw_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.TERRACOTTA_MAGENTA)
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block TANZANITE_LAMP = registerBlock("tanzanite_lamp",
            new RedstoneLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP, MapColor.DARK_DULL_PINK)
                    .strength(0.3f).sounds(BlockSoundGroup.GLASS)
                    .luminance(state -> state.get(RedstoneLampBlock.LIT) ? 15 : 0)),
            EEItemGroup.ENHANCED_END_BLOCKS);

//Clitanium Variants
    public static final Block CLITANIUM_BLOCK = registerBlock("clitanium_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.GRAY)
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.COPPER)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SMOOTH_CLITANIUM_BLOCK = registerBlock("smooth_clitanium_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.GRAY)
                    .strength(3f).requiresTool().sounds(BlockSoundGroup.COPPER)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_DOOR = registerBlock("clitanium_door",
            new EEDoorBlock(FabricBlockSettings.of(Material.METAL, MapColor.GRAY)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_TRAPDOOR = registerBlock("clitanium_trapdoor",
            new EETrapdoorBlock(FabricBlockSettings.of(Material.METAL, MapColor.GRAY)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CLITANIUM_BARS = registerBlock("clitanium_bars",
            new EEPaneBlock(FabricBlockSettings.of(Material.METAL, MapColor.GRAY)
                    .strength(3.5f).requiresTool().nonOpaque().sounds(BlockSoundGroup.COPPER)),
            EEItemGroup.ENHANCED_END_BLOCKS);

//Silstone Blocks
    public static final Block SILSTONE = registerBlock("silstone",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW).
                    strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE = registerBlock("cobbled_silstone",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICKS = registerBlock("silstone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CHISELED_SILSTONE = registerBlock("chiseled_silstone",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            EEItemGroup.ENHANCED_END_BLOCKS);
//Silstone Redstone Variants
    public static final Block SILSTONE_BUTTON = registerBlock("silstone_button",
            new EEStoneButtonBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().noCollision().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_PRESSURE_PLATE = registerBlock("silstone_pressure_plate",
            new EEPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Silstone Variants
    public static final Block SILSTONE_STAIRS = registerBlock("silstone_stairs",
            new EEStairsBlock(EEBlocks.SILSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_SLAB = registerBlock("silstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Cobbled Silstone
    public static final Block COBBLED_SILSTONE_STAIRS = registerBlock("cobbled_silstone_stairs",
            new EEStairsBlock(EEBlocks.COBBLED_SILSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE_SLAB = registerBlock("cobbled_silstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block COBBLED_SILSTONE_WALL = registerBlock("cobbled_silstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.CALCITE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Silstone Bricks
    public static final Block SILSTONE_BRICK_STAIRS = registerBlock("silstone_brick_stairs",
            new EEStairsBlock(EEBlocks.SILSTONE_BRICKS.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICK_SLAB = registerBlock("silstone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block SILSTONE_BRICK_WALL = registerBlock("silstone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.DRIPSTONE_BLOCK)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Kimberlite
    public static final Block KIMBERLITE = registerBlock("kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE = registerBlock("polished_kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block KIMBERLITE_PILLAR = registerBlock("kimberlite_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Kimberlite Variants
    public static final Block KIMBERLITE_STAIRS = registerBlock("kimberlite_stairs",
            new EEStairsBlock(EEBlocks.KIMBERLITE.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block KIMBERLITE_SLAB = registerBlock("kimberlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block INFUSED_KIMBERLITE = registerBlock("infused_kimberlite",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Polished Kimberlite Variants
    public static final Block POLISHED_KIMBERLITE_STAIRS = registerBlock("polished_kimberlite_stairs",
            new EEStairsBlock(EEBlocks.KIMBERLITE.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(58f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE_SLAB = registerBlock("polished_kimberlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block POLISHED_KIMBERLITE_WALL = registerBlock("polished_kimberlite_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY)
                    .strength(8f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //End stone Blocks
    public static final Block MIDNIGHT_END_STONE = registerBlock("midnight_end_stone",
            new EENyliumBlock(FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY)
                    .strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.MUDDY_MANGROVE_ROOTS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block CORLITE_END_STONE = registerBlock("corlite_end_stone",
            new EENyliumBlock(FabricBlockSettings.of(Material.STONE, MapColor.PURPLE)
                    .strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.MUDDY_MANGROVE_ROOTS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    //Midnight Wood Variants
    public static final Block MIDNIGHT_STEM = registerBlock("midnight_stem",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PURPLE)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_STEM = registerBlock("stripped_midnight_stem",
        new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_HYPHAE = registerBlock("midnight_hyphae",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PURPLE)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_MIDNIGHT_HYPHAE = registerBlock("stripped_midnight_hyphae",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_PLANKS = registerBlock("midnight_planks",
            new Block(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_FENCE = registerBlock("midnight_fence",
            new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block MIDNIGHT_FENCE_GATE = registerBlock("midnight_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f,3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_STAIRS = registerBlock("midnight_stairs",
            new EEStairsBlock(EEBlocks.MIDNIGHT_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_SLAB = registerBlock("midnight_slab",
            new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_BUTTON = registerBlock("midnight_button",
            new EEWoodenButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(0.5f, 1f).noCollision().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_PRESSURE_PLATE = registerBlock("midnight_pressure_plate",
            new EEPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(0.5f, 1f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_DOOR = registerBlock("midnight_door",
            new EEDoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_TRAPDOOR = registerBlock("midnight_trapdoor",
            new EETrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block MIDNIGHT_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("midnight_wall_sign",
            new WallSignBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .noCollision().strength(1.0f).sounds(BlockSoundGroup.WOOD), EESignTypes.MIDNIGHT),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block MIDNIGHT_SIGN_BLOCK = registerBlockWithoutBlockItem("midnight_sign",
            new SignBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.PALE_PURPLE)
                    .noCollision().strength(1.0f).sounds(BlockSoundGroup.WOOD), EESignTypes.MIDNIGHT),
            EEItemGroup.ENHANCED_END_BLOCKS);

//Corlite Wood Variants
    public static final Block CORLITE_STEM = registerBlock("corlite_stem",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.WHITE_GRAY)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_CORLITE_STEM = registerBlock("stripped_corlite_stem",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_HYPHAE = registerBlock("corlite_hyphae",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.WHITE_GRAY)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block STRIPPED_CORLITE_HYPHAE = registerBlock("stripped_corlite_hyphae",
            new PillarBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2.0f).sounds(BlockSoundGroup.NETHER_STEM)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_PLANKS = registerBlock("corlite_planks",
            new Block(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_FENCE = registerBlock("corlite_fence",
            new FenceBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_FENCE_GATE = registerBlock("corlite_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f,3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_STAIRS = registerBlock("corlite_stairs",
            new EEStairsBlock(EEBlocks.MIDNIGHT_PLANKS.getDefaultState(), FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_SLAB = registerBlock("corlite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f, 3f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_BUTTON = registerBlock("corlite_button",
            new EEWoodenButtonBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(0.5f, 1f).noCollision().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_PRESSURE_PLATE = registerBlock("corlite_pressure_plate",
            new EEPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(0.5f, 1f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_DOOR = registerBlock("corlite_door",
            new EEDoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_TRAPDOOR = registerBlock("corlite_trapdoor",
            new EETrapdoorBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .strength(2f,3f).nonOpaque().sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    public static final Block CORLITE_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("corlite_wall_sign",
            new WallSignBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .noCollision().strength(1.0f).sounds(BlockSoundGroup.WOOD), EESignTypes.CORLITE),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block CORLITE_SIGN_BLOCK = registerBlockWithoutBlockItem("corlite_sign",
            new SignBlock(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.OFF_WHITE)
                    .noCollision().strength(1.0f).sounds(BlockSoundGroup.WOOD), EESignTypes.CORLITE),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Blots and Mushrooms
    public static final Block MIDNIGHT_MUSHROOM = registerBlock("midnight_mushroom",
            new MidnightMushroomBlock(new MidnightSaplingGenerator(),
                    FabricBlockSettings.of(Material.PLANT)
                            .breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block CORLITE_MUSHROOM = registerBlock("corlite_mushroom",
            new CorliteMushroomBlock(new CorliteSaplingGenerator(),
                    FabricBlockSettings.of(Material.PLANT, MapColor.OFF_WHITE)
                            .breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block MIDNIGHT_BLOTS = registerBlock("midnight_blots",
            new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.PALE_PURPLE)
                    .strength(1.0f).sounds(BlockSoundGroup.WART_BLOCK)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block CORLITE_BLOTS = registerBlock("corlite_blots",
            new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_GRAY)
                    .strength(1.0f).sounds(BlockSoundGroup.WART_BLOCK)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    //Fescus and Rhizome
    public static final Block MIDNIGHT_FESCUS = registerBlock("midnight_fescus",
            new FescusBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT, MapColor.PALE_PURPLE)
                    .breakInstantly().noCollision()
                    .sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block ENDIUM_RHIZOME = registerBlock("endium_rhizome",
            new RhizomeBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT, MapColor.LIME)
                    .breakInstantly().noCollision()
                    .sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block CORLITE_FESCUS = registerBlock("corlite_fescus",
            new FescusBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT, MapColor.LIGHT_GRAY)
                    .breakInstantly().noCollision()
                    .sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    //Endium and End Matter
    public static final Block ENDIUM_MUSHROOM = registerBlock("endium_mushroom",
            new EndiumMushroomBlock(new EndiumMushroomGenerator(),
                    FabricBlockSettings.of(Material.PLANT, MapColor.LIME)
                            .breakInstantly().noCollision().sounds(BlockSoundGroup.GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block ENDIUM_MUSHROOM_BLOCK = registerBlock("endium_mushroom_block",
            new Block(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.LIME).strength(0.2f).sounds(BlockSoundGroup.WOOD)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block ENDIUM_SOIL = registerBlock("endium_soil",
            new EENyliumBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DARK_GREEN)
                    .strength(0.7f).sounds(BlockSoundGroup.WET_GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block HARDENED_ENDER_MATTER = registerBlock("hardened_ender_matter",
            new PillarBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_YELLOW)
                    .strength(8f).requiresTool()),
            EEItemGroup.ENHANCED_END_BLOCKS);

    //Laristone and Laristone Variants
    public static final Block LARISTONE = registerBlock("laristone",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block LARISTONE_STAIRS = registerBlock("laristone_stairs",
            new EEStairsBlock(EEBlocks.LARISTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block LARISTONE_SLAB = registerBlock("laristone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);



    public static final Block LARISTONE_BRICKS = registerBlock("laristone_bricks",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block LARISTONE_BRICK_STAIRS = registerBlock("laristone_brick_stairs",
            new EEStairsBlock(EEBlocks.LARISTONE_BRICKS.getDefaultState(), FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block LARISTONE_BRICK_SLAB = registerBlock("laristone_brick_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);

    public static final Block LARISTONE_BRICK_WALL = registerBlock("laristone_brick_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE)
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.STONE)),
            EEItemGroup.ENHANCED_END_BLOCKS);
    //Plants
    public static final Block SHADED_OCULIT = registerBlock("shaded_oculit",
            new EEFlowerBlock(StatusEffects.SLOW_FALLING, 8,
                    FabricBlockSettings.of(Material.NETHER_SHOOTS, MapColor.TERRACOTTA_BLACK)
                            .noCollision().breakInstantly()
                            .offsetType(AbstractBlock.OffsetType.XZ)
                            .sounds(BlockSoundGroup.GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);
    public static final Block TINTED_OCULIT = registerBlock("tinted_oculit",
            new EEFlowerBlock(StatusEffects.LEVITATION, 8,
                    FabricBlockSettings.of(Material.NETHER_SHOOTS, MapColor.WHITE_GRAY)
                            .noCollision().breakInstantly()
                            .offsetType(AbstractBlock.OffsetType.XZ)
                            .sounds(BlockSoundGroup.GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);

    public static final Block END_FLORIA = registerBlock("end_floria",
            new EndFloriaFlowerBlock(StatusEffects.HASTE, 0,
                    FabricBlockSettings.of(Material.PLANT, MapColor.LIME)
                            .noCollision().breakInstantly()
                            .offsetType(AbstractBlock.OffsetType.XZ)
                            .sounds(BlockSoundGroup.GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);

    public static final Block ENERIA_CANE = registerBlock("eneria_cane",
            new EneriaCaneBlock(FabricBlockSettings.of(Material.PLANT, MapColor.LICHEN_GREEN)
                    .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.WET_GRASS)),
            EEItemGroup.ENHANCED_END_DECORATIONS);

    //Potted Plants
    public static final Block POTTED_SHADED_OCULIT = registerBlockWithoutItem("potted_shaded_oculit",
            new FlowerPotBlock(SHADED_OCULIT, FabricBlockSettings.of(Material.DECORATION, MapColor.TERRACOTTA_BLACK)
                    .breakInstantly().nonOpaque()));
    public static final Block POTTED_TINTED_OCULIT = registerBlockWithoutItem("potted_tinted_oculit",
            new FlowerPotBlock(TINTED_OCULIT, FabricBlockSettings.of(Material.DECORATION, MapColor.OFF_WHITE)
                    .breakInstantly().nonOpaque()));

    public static final Block POTTED_MIDNIGHT_MUSHROOM = registerBlockWithoutItem("potted_midnight_mushroom",
            new FlowerPotBlock(MIDNIGHT_MUSHROOM, FabricBlockSettings.of(Material.DECORATION, MapColor.PURPLE)
                    .breakInstantly().nonOpaque()));
    public static final Block POTTED_CORLITE_MUSHROOM = registerBlockWithoutItem("potted_corlite_mushroom",
            new FlowerPotBlock(CORLITE_MUSHROOM, FabricBlockSettings.of(Material.DECORATION, MapColor.WHITE_GRAY)
                    .breakInstantly().nonOpaque()));
    public static final Block POTTED_ENDIUM_MUSHROOM = registerBlockWithoutItem("potted_endium_mushroom",
            new FlowerPotBlock(ENDIUM_MUSHROOM, FabricBlockSettings.of(Material.DECORATION, MapColor.LIME)
                    .breakInstantly().nonOpaque()));

    public static final Block POTTED_END_FLORIA = registerBlockWithoutItem("potted_end_floria",
            new FlowerPotBlock(END_FLORIA, FabricBlockSettings.of(Material.DECORATION, MapColor.LIME)
                    .breakInstantly().nonOpaque()));





    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(EnhancedEnd.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutItem(String name, Block block) {
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





    public static void registerEEBlocks() {
        EnhancedEnd.LOGGER.debug("Registering EEBlocks for " + EnhancedEnd.MOD_ID);
    }
}
