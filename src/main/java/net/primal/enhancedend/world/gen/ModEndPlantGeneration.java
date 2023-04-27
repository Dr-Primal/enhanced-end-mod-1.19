package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.primal.enhancedend.world.feature.ModPlacedFeatures;

public class ModEndPlantGeneration {
    public static void generateEndPlants() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ENDIUM_RHIZOME.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ENDIUM_MUSHROOM_SAPLING.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.END_FLORIA.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MIDNIGHT_FESCUS.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CORLITE_FESCUS.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MIDNIGHT_MUSHROOM.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CORLITE_MUSHROOM.getKey().get());



        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SHADED_OCULIT.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TINTED_OCULIT.getKey().get());
    }
}