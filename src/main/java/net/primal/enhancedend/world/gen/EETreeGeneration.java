package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.primal.enhancedend.world.feature.EEPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class EETreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.ENDIUM_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.MIDNIGHT_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.TALL_MIDNIGHT_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.CORLITE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.TALL_CORLITE_PLACED.getKey().get());
    }
}