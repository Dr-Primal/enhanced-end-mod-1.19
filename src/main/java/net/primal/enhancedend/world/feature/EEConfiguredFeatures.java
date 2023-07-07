package net.primal.enhancedend.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.block.EEBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.primal.enhancedend.fluid.EEFluids;
import net.primal.enhancedend.world.gen.feature.EEFeatures;

import java.util.List;
import java.util.OptionalInt;

public class EEConfiguredFeatures {

//Template for Endium Mushrooms
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ENDIUM_MUSHROOM =
            ConfiguredFeatures.register("endium_mushroom", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.MUSHROOM_STEM),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(EEBlocks.ENDIUM_MUSHROOM_BLOCK),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)).dirtProvider(BlockStateProvider.of(EEBlocks.ENDIUM_SOIL)).forceDirt().build());

//Basic Corlite and Midnight Trees
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CORLITE_TREE =
        ConfiguredFeatures.register("corlite_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(EEBlocks.CORLITE_STEM),
                new BendingTrunkPlacer(10, 4, 6, 8, UniformIntProvider.create(1, 2)),
                BlockStateProvider.of(EEBlocks.CORLITE_BLOTS),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(2), ConstantIntProvider.create(2), 50),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(EEBlocks.CORLITE_END_STONE)))).build());
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MIDNIGHT_TREE =
            ConfiguredFeatures.register("midnight_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(EEBlocks.MIDNIGHT_STEM),
                    new BendingTrunkPlacer(10, 4, 6, 8, UniformIntProvider.create(1, 2)),
                    BlockStateProvider.of(EEBlocks.MIDNIGHT_BLOTS),
                    new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(2), ConstantIntProvider.create(2), 50),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(EEBlocks.MIDNIGHT_END_STONE)))).build());
    //Tall Corlite and Midnight Trees
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TALL_MIDNIGHT_TREE =
            ConfiguredFeatures.register("tall_midnight_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(EEBlocks.MIDNIGHT_STEM),
                    new GiantTrunkPlacer(20, 5, 10),
                    BlockStateProvider.of(EEBlocks.MIDNIGHT_BLOTS),
                    new RandomSpreadFoliagePlacer(ConstantIntProvider.create(6), ConstantIntProvider.create(4), ConstantIntProvider.create(5), 50),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(EEBlocks.MIDNIGHT_END_STONE)))).build());

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TALL_CORLITE_TREE =
            ConfiguredFeatures.register("tall_corlite_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(EEBlocks.CORLITE_STEM),
                    new GiantTrunkPlacer(20, 5, 10),
                    BlockStateProvider.of(EEBlocks.CORLITE_BLOTS),
                    new RandomSpreadFoliagePlacer(ConstantIntProvider.create(6), ConstantIntProvider.create(4), ConstantIntProvider.create(5), 50),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(EEBlocks.CORLITE_END_STONE)))).build());

    public static final RegistryEntry<PlacedFeature> ENDIUM_CHECKED = PlacedFeatures.register("endium_checked",
            EEConfiguredFeatures.ENDIUM_MUSHROOM, List.of(PlacedFeatures.wouldSurvive(EEBlocks.ENDIUM_MUSHROOM)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ENDIUM_SPAWN =
            ConfiguredFeatures.register("endium_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ENDIUM_CHECKED, 0.8f)),
                            ENDIUM_CHECKED));
//Basic Trees
    public static final RegistryEntry<PlacedFeature> MIDNIGHT_CHECKED = PlacedFeatures.register("midnight_checked",
        EEConfiguredFeatures.MIDNIGHT_TREE, List.of(PlacedFeatures.wouldSurvive(EEBlocks.MIDNIGHT_MUSHROOM)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MIDNIGHT_SPAWN =
            ConfiguredFeatures.register("midnight_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MIDNIGHT_CHECKED, 0.6f)),
                            MIDNIGHT_CHECKED));

    public static final RegistryEntry<PlacedFeature> CORLITE_CHECKED = PlacedFeatures.register("corlite_checked",
            EEConfiguredFeatures.CORLITE_TREE, List.of(PlacedFeatures.wouldSurvive(EEBlocks.CORLITE_MUSHROOM)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CORLITE_SPAWN =
            ConfiguredFeatures.register("corlite_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CORLITE_CHECKED, 0.6f)),
                            CORLITE_CHECKED));

//Tall Trees
    public static final RegistryEntry<PlacedFeature> TALL_MIDNIGHT_CHECKED = PlacedFeatures.register("tall_midnight_checked",
            EEConfiguredFeatures.TALL_MIDNIGHT_TREE, List.of(PlacedFeatures.wouldSurvive(EEBlocks.MIDNIGHT_MUSHROOM)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> TALL_MIDNIGHT_SPAWN =
            ConfiguredFeatures.register("tall_midnight_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(TALL_MIDNIGHT_CHECKED, 0.2f)),
                            TALL_MIDNIGHT_CHECKED));

    public static final RegistryEntry<PlacedFeature> TALL_CORLITE_CHECKED = PlacedFeatures.register("tall_corlite_checked",
            EEConfiguredFeatures.TALL_CORLITE_TREE, List.of(PlacedFeatures.wouldSurvive(EEBlocks.CORLITE_MUSHROOM)));
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> TALL_CORLITE_SPAWN =
            ConfiguredFeatures.register("tall_corlite_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(TALL_CORLITE_CHECKED, 0.2f)),
                            TALL_CORLITE_CHECKED));


    public static final List<OreFeatureConfig.Target> KIMBERLITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), EEBlocks.KIMBERLITE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> KIMBERLITE_ORE =
            ConfiguredFeatures.register("kimberlite_ore", Feature.ORE, new OreFeatureConfig(KIMBERLITE_ORES, 64));

    public static final List<OreFeatureConfig.Target> SILSTONE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), EEBlocks.SILSTONE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> LARISTONE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), EEBlocks.LARISTONE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SILSTONE_ORE =
            ConfiguredFeatures.register("silstone_ore", Feature.ORE, new OreFeatureConfig(SILSTONE_ORES, 64));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LARISTONE_ORE =
            ConfiguredFeatures.register("laristone_ore", Feature.ORE, new OreFeatureConfig(LARISTONE_ORES, 32));

    public static final List<OreFeatureConfig.Target> INFUSED_KIMBERLITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(EEBlocks.KIMBERLITE), EEBlocks.INFUSED_KIMBERLITE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INFUSED_KIMBERLITE_ORE =
            ConfiguredFeatures.register("infused_kimberlite_ore", Feature.ORE, new OreFeatureConfig(INFUSED_KIMBERLITE_ORES, 6));

    public static final List<OreFeatureConfig.Target> END_TANZANITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), EEBlocks.END_TANZANITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TANZANITE_ORE =
            ConfiguredFeatures.register("tanzanite_ore", Feature.ORE, new OreFeatureConfig(END_TANZANITE_ORES, 6));


    public static final List<OreFeatureConfig.Target> END_CLITANIUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), EEBlocks.END_CLITANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CLITANIUM_ORE =
            ConfiguredFeatures.register("clitanium_ore", Feature.ORE, new OreFeatureConfig(END_CLITANIUM_ORES, 6));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ENDIUM_RHIZOME =
            ConfiguredFeatures.register("endium_rhizome", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.ENDIUM_RHIZOME)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ENDIUM_MUSHROOM_SAPLING =
            ConfiguredFeatures.register("endium_mushroom_sapling", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(16, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.ENDIUM_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> END_FLORIA =
            ConfiguredFeatures.register("end_floria", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.END_FLORIA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CORLITE_MUSHROOM =
            ConfiguredFeatures.register("corlite_mushroom", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.CORLITE_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MIDNIGHT_MUSHROOM =
            ConfiguredFeatures.register("midnight_mushroom", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.MIDNIGHT_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TINTED_OCULIT =
            ConfiguredFeatures.register("tinted_oculit", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.TINTED_OCULIT)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SHADED_OCULIT =
            ConfiguredFeatures.register("shaded_oculit", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.SHADED_OCULIT)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CORLITE_FESCUS =
            ConfiguredFeatures.register("corlite_fescus", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(128, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.CORLITE_FESCUS)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MIDNIGHT_FESCUS =
            ConfiguredFeatures.register("midnight_fescus", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(128, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(EEBlocks.MIDNIGHT_FESCUS)))));

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig,?>> ENDIUM_ISLAND =
            ConfiguredFeatures.register("endium_island", EEFeatures.ENDIUM_ISLAND);

    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig,?>> KIMBERLITE_SPIKE =
            ConfiguredFeatures.register("kimberlite_spike", EEFeatures.KIMBERLITE_SPIKE);

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PATCH_ENERIA_CANE =
            ConfiguredFeatures.register("patch_eneria_cane", Feature.RANDOM_PATCH,
                    new RandomPatchFeatureConfig(20, 4, 0,
                            PlacedFeatures.createEntry(Feature.BLOCK_COLUMN,
                                    BlockColumnFeatureConfig.create(BiasedToBottomIntProvider.create(2, 4),
                                    BlockStateProvider.of(EEBlocks.ENERIA_CANE)),
                                    BlockFilterPlacementModifier.of(BlockPredicate.allOf(BlockPredicate.IS_AIR,
                                    BlockPredicate.wouldSurvive(EEBlocks.ENERIA_CANE.getDefaultState(), BlockPos.ORIGIN),
                                    BlockPredicate.anyOf(BlockPredicate.matchingFluids(new BlockPos(1, -1, 0), EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER),
                                    BlockPredicate.matchingFluids(new BlockPos(-1, -1, 0), EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER),
                                    BlockPredicate.matchingFluids(new BlockPos(0, -1, 1), EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER),
                                    BlockPredicate.matchingFluids(new BlockPos(0, -1, -1), EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER)))))));



    public static void registerConfiguredFeatures() {
        EnhancedEnd.LOGGER.debug("Registering the EEConfiguredFeatures for " + EnhancedEnd.MOD_ID);
    }
}
