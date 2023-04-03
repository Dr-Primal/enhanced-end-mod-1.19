package net.primal.enhancedend.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.block.ModBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    //Template for Endium Mushrooms
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ENDIUM_MUSHROOM =
            ConfiguredFeatures.register("endium_mushroom", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.MUSHROOM_STEM),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.ENDIUM_MUSHROOM_BLOCK),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).forceDirt().build());

//Template for Corlite and Midnighht Trees
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CORLITE_TREE =
            ConfiguredFeatures.register("corlite_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.CORLITE_STEM),
                    new MegaJungleTrunkPlacer(12, 4, 2),
                    BlockStateProvider.of(ModBlocks.CORLITE_BLOTS),
                    new JungleFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 3),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).forceDirt().build());
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MIDNIGHT_TREE =
            ConfiguredFeatures.register("midnight_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.MIDNIGHT_STEM),
                    new MegaJungleTrunkPlacer(12, 4, 2),
                    BlockStateProvider.of(ModBlocks.MIDNIGHT_BLOTS),
                    new JungleFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 3),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                    .dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).forceDirt().build());

    public static final RegistryEntry<PlacedFeature> ENDIUM_CHECKED = PlacedFeatures.register("endium_checked",
            ModConfiguredFeatures.ENDIUM_MUSHROOM, List.of(PlacedFeatures.wouldSurvive(ModBlocks.ENDIUM_MUSHROOM)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ENDIUM_SPAWN =
            ConfiguredFeatures.register("endium_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ENDIUM_CHECKED, 0.8f)),
                            ENDIUM_CHECKED));


    public static final List<OreFeatureConfig.Target> KIMBERLITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.KIMBERLITE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> KIMBERLITE_ORE =
            ConfiguredFeatures.register("kimberlite_ore", Feature.ORE, new OreFeatureConfig(KIMBERLITE_ORES, 48));

    public static final List<OreFeatureConfig.Target> END_TANZANITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.END_TANZANITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TANZANITE_ORE =
            ConfiguredFeatures.register("tanzanite_ore", Feature.ORE, new OreFeatureConfig(END_TANZANITE_ORES, 6));


    public static final List<OreFeatureConfig.Target> END_CLITANIUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.END_CLITANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CLITANIUM_ORE =
            ConfiguredFeatures.register("clitanium_ore", Feature.ORE, new OreFeatureConfig(END_CLITANIUM_ORES, 6));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ENDIUM_RHIZOME =
            ConfiguredFeatures.register("endium_rhizome", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ENDIUM_RHIZOME)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ENDIUM_MUSHROOM_SAPLING =
            ConfiguredFeatures.register("endium_mushroom_sapling", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ENDIUM_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> END_FLORIA =
            ConfiguredFeatures.register("end_floria", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.END_FLORIA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CORLITE_MUSHROOM =
            ConfiguredFeatures.register("corlite_mushroom", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CORLITE_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MIDNIGHT_MUSHROOM =
            ConfiguredFeatures.register("midnight_mushroom", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MIDNIGHT_MUSHROOM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> TINTED_OCULIT =
            ConfiguredFeatures.register("tinted_oculit", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINTED_OCULIT)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SHADED_OCULIT =
            ConfiguredFeatures.register("shaded_oculit", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHADED_OCULIT)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CORLITE_FESCUS =
            ConfiguredFeatures.register("corlite_fescus", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CORLITE_FESCUS)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MIDNIGHT_FESCUS =
            ConfiguredFeatures.register("midnight_fescus", Feature.RANDOM_PATCH,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MIDNIGHT_FESCUS)))));



    public static void registerConfiguredFeatures() {
        EnhancedEnd.LOGGER.debug("Registering the ModConfiguredFeatures for " + EnhancedEnd.MOD_ID);
    }
}
