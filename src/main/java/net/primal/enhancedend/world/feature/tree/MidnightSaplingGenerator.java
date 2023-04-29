package net.primal.enhancedend.world.feature.tree;

import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.primal.enhancedend.world.feature.EEConfiguredFeatures;

public class MidnightSaplingGenerator extends LargeTreeSaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return EEConfiguredFeatures.MIDNIGHT_TREE;
    }

    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return EEConfiguredFeatures.TALL_MIDNIGHT_TREE;
    }
}
