package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.primal.enhancedend.world.feature.EEPlacedFeatures;

public class EEEndPlantGeneration {
    public static void generateEndPlants() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.ENDIUM_RHIZOME.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.ENDIUM_MUSHROOM_SAPLING.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.END_FLORIA.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.MIDNIGHT_FESCUS.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.CORLITE_FESCUS.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.MIDNIGHT_MUSHROOM.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.CORLITE_MUSHROOM.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.SHADED_OCULIT.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, EEPlacedFeatures.TINTED_OCULIT.getKey().get());
    }
}