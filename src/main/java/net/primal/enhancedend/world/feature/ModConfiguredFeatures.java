package net.primal.enhancedend.world.feature;

import net.minecraft.block.Blocks;
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

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ENDIUM_MUSHROOM =
            ConfiguredFeatures.register("endium_mushroom", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(Blocks.MUSHROOM_STEM),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.ENDIUM_MUSHROOM_BLOCK),
                    new JungleFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)).dirtProvider(BlockStateProvider.of(ModBlocks.ENDIUM_SOIL)).forceDirt().build());
//Template for Endium Mushrooms/\

//Template for Corlite and Midnighht Trees\/
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

    public static final RegistryEntry<PlacedFeature> MIDNIGHT_CHECKED = PlacedFeatures.register("midnight_checked",
            ModConfiguredFeatures.MIDNIGHT_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.MIDNIGHT_MUSHROOM)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MIDNIGHT_SPAWN =
            ConfiguredFeatures.register("midnight_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MIDNIGHT_CHECKED, 0.5f)),
                            MIDNIGHT_CHECKED));

    public static final RegistryEntry<PlacedFeature> CORLITE_CHECKED = PlacedFeatures.register("corlite_checked",
            ModConfiguredFeatures.CORLITE_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.CORLITE_MUSHROOM)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CORLITE_SPAWN =
            ConfiguredFeatures.register("corlite_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CORLITE_CHECKED, 0.5f)),
                            CORLITE_CHECKED));

    public static final RegistryEntry<PlacedFeature> ENDIUM_CHECKED = PlacedFeatures.register("endium_checked",
            ModConfiguredFeatures.ENDIUM_MUSHROOM, List.of(PlacedFeatures.wouldSurvive(ModBlocks.ENDIUM_MUSHROOM)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ENDIUM_SPAWN =
            ConfiguredFeatures.register("endium_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(ENDIUM_CHECKED, 0.5f)),
                            ENDIUM_CHECKED));



    public static void registerConfiguredFeatures() {
        EnhancedEnd.LOGGER.debug("Registering the ModConfiguredFeatures for " + EnhancedEnd.MOD_ID);
    }
}
