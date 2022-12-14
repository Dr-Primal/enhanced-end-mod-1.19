package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.primal.enhancedend.world.feature.ModPlacedFeatures;

public class ModOreGeneration {

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_BARRENS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.TANZANITE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey
                        (BiomeKeys.END_BARRENS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.CLITANIUM_ORE_PLACED.getKey().get());
    }
}
