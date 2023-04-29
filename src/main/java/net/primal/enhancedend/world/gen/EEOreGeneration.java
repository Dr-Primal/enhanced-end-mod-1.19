package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.primal.enhancedend.world.feature.EEPlacedFeatures;

public class EEOreGeneration {

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_BARRENS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.THE_END),
                GenerationStep.Feature.UNDERGROUND_ORES, EEPlacedFeatures.TANZANITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_BARRENS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.THE_END),
                GenerationStep.Feature.UNDERGROUND_ORES, EEPlacedFeatures.CLITANIUM_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS),
                GenerationStep.Feature.UNDERGROUND_ORES, EEPlacedFeatures.INFUSED_KIMBERLITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS),
                GenerationStep.Feature.UNDERGROUND_ORES, EEPlacedFeatures.KIMBERLITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS),
                GenerationStep.Feature.UNDERGROUND_ORES, EEPlacedFeatures.SILSTONE_ORE_PLACED.getKey().get());
    }
}
