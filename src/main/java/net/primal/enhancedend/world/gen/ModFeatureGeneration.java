package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.primal.enhancedend.world.feature.ModPlacedFeatures;

public class ModFeatureGeneration {

    public static void registerFeatures() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.RAW_GENERATION, ModPlacedFeatures.ENDIUM_ISLAND_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_BARRENS,
                         BiomeKeys.END_MIDLANDS),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.KIMBERLITE_SPIKE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_ENERIA_CANE_PLACED.getKey().get());
    }
}
