package net.primal.enhancedend.world.feature.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.primal.enhancedend.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class EndiumMushroomGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.ENDIUM_MUSHROOM;
    }
}
