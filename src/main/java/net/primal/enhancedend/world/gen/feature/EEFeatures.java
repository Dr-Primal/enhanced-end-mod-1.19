package net.primal.enhancedend.world.gen.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class EEFeatures {
    public static final Feature<DefaultFeatureConfig> ENDIUM_ISLAND = EEFeatures.register("endium_island", new EndiumIslandFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> KIMBERLITE_SPIKE = EEFeatures.register("kimberlite_spike", new KimberliteSpikeFeature(DefaultFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, name, feature);
    }
}
