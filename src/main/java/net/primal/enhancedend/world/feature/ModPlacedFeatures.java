package net.primal.enhancedend.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ENDIUM_PLACED = PlacedFeatures.register("endium_placed",
            ModConfiguredFeatures.ENDIUM_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1)));


    public static final RegistryEntry<PlacedFeature> TANZANITE_ORE_PLACED = PlacedFeatures.register("tanzanite_ore_placed",
            ModConfiguredFeatures.TANZANITE_ORE, modifiersWithCount(8,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> CLITANIUM_ORE_PLACED = PlacedFeatures.register("clitanium_ore_placed",
            ModConfiguredFeatures.CLITANIUM_ORE, modifiersWithCount(8,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));



    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}