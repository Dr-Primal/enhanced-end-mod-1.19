package net.primal.enhancedend.world.feature.tree;

import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.primal.enhancedend.world.feature.EEConfiguredFeatures;

public class CorliteSaplingGenerator extends LargeTreeSaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return EEConfiguredFeatures.CORLITE_TREE;
    }

    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return EEConfiguredFeatures.TALL_CORLITE_TREE;
    }
}
