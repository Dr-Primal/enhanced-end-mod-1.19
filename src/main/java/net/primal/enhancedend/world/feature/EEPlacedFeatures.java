package net.primal.enhancedend.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class EEPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ENDIUM_PLACED = PlacedFeatures.register("endium_placed",
            EEConfiguredFeatures.ENDIUM_SPAWN, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
//Basic Trees
public static final RegistryEntry<PlacedFeature> MIDNIGHT_PLACED = PlacedFeatures.register("midnight_placed",
        EEConfiguredFeatures.MIDNIGHT_SPAWN, RarityFilterPlacementModifier.of(7), SquarePlacementModifier.of(),
        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CORLITE_PLACED = PlacedFeatures.register("corlite_placed",
            EEConfiguredFeatures.CORLITE_SPAWN, RarityFilterPlacementModifier.of(7), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
//Tall Trees
    public static final RegistryEntry<PlacedFeature> TALL_MIDNIGHT_PLACED = PlacedFeatures.register("tall_midnight_placed",
            EEConfiguredFeatures.TALL_MIDNIGHT_SPAWN, RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(),
        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> TALL_CORLITE_PLACED = PlacedFeatures.register("tall_corlite_placed",
            EEConfiguredFeatures.TALL_CORLITE_SPAWN, RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());




    public static final RegistryEntry<PlacedFeature> KIMBERLITE_ORE_PLACED = PlacedFeatures.register("kimberlite_ore_placed",
            EEConfiguredFeatures.KIMBERLITE_ORE, modifiersWithCount(64,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(100))));

    public static final RegistryEntry<PlacedFeature> SILSTONE_ORE_PLACED = PlacedFeatures.register("silstone_ore_placed",
            EEConfiguredFeatures.SILSTONE_ORE, modifiersWithCount(64,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(100))));

    public static final RegistryEntry<PlacedFeature> INFUSED_KIMBERLITE_ORE_PLACED = PlacedFeatures.register("infused_kimberlite_ore_placed",
            EEConfiguredFeatures.INFUSED_KIMBERLITE_ORE, modifiersWithCount(8,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> TANZANITE_ORE_PLACED = PlacedFeatures.register("tanzanite_ore_placed",
            EEConfiguredFeatures.TANZANITE_ORE, modifiersWithCount(8,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> CLITANIUM_ORE_PLACED = PlacedFeatures.register("clitanium_ore_placed",
            EEConfiguredFeatures.CLITANIUM_ORE, modifiersWithCount(8,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));

    public static final RegistryEntry<PlacedFeature> MIDNIGHT_FESCUS = PlacedFeatures.register("midnight_fescus_placed",
            EEConfiguredFeatures.MIDNIGHT_FESCUS, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CORLITE_FESCUS = PlacedFeatures.register("corlite_fescus_placed",
            EEConfiguredFeatures.CORLITE_FESCUS, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> MIDNIGHT_MUSHROOM = PlacedFeatures.register("midnight_mushroom_placed",
            EEConfiguredFeatures.MIDNIGHT_MUSHROOM, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CORLITE_MUSHROOM = PlacedFeatures.register("corlite_mushroom_placed",
            EEConfiguredFeatures.CORLITE_MUSHROOM, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> SHADED_OCULIT = PlacedFeatures.register("shaded_oculit_placed",
            EEConfiguredFeatures.SHADED_OCULIT, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> TINTED_OCULIT = PlacedFeatures.register("tinted_oculit_placed",
            EEConfiguredFeatures.TINTED_OCULIT, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> ENDIUM_RHIZOME = PlacedFeatures.register("endium_rhizome_placed",
            EEConfiguredFeatures.ENDIUM_RHIZOME, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> ENDIUM_MUSHROOM_SAPLING = PlacedFeatures.register("endium_mushroom_sapling",
            EEConfiguredFeatures.ENDIUM_MUSHROOM_SAPLING, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> END_FLORIA = PlacedFeatures.register("end_floria",
            EEConfiguredFeatures.END_FLORIA, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> ENDIUM_ISLAND_PLACED = PlacedFeatures.register("endium_island_placed",
            EEConfiguredFeatures.ENDIUM_ISLAND,
            RarityFilterPlacementModifier.of(20),
            PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(75), YOffset.fixed(90)),
            BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> KIMBERLITE_SPIKE_PLACED = PlacedFeatures.register("kimberlite_spike_placed",
            EEConfiguredFeatures.KIMBERLITE_SPIKE, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, HeightRangePlacementModifier.uniform(YOffset.fixed(65), YOffset.fixed(70)));

    public static final RegistryEntry<PlacedFeature> PATCH_ENERIA_CANE_PLACED = PlacedFeatures.register("patch_eneria_cane_placed",
            EEConfiguredFeatures.PATCH_ENERIA_CANE, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());




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