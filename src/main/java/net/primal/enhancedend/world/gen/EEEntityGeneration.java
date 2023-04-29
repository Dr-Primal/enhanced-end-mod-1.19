package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.primal.enhancedend.entity.EEEntities;
import net.primal.enhancedend.entity.custom.AllamiteEntity;

public class EEEntityGeneration {
    public static void addEntityGen() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.SMALL_END_ISLANDS), SpawnGroup.AMBIENT,
                        EEEntities.SEASPRAY, 5000, 2, 4);

        SpawnRestriction.register(EEEntities.SEASPRAY, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS), SpawnGroup.MONSTER,
                        EntityType.PHANTOM, 5000, 4, 8);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.END_HIGHLANDS), SpawnGroup.CREATURE,
                        EEEntities.ALLAMITE, 5000, 3, 6);

        SpawnRestriction.register(EEEntities.ALLAMITE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AllamiteEntity::canMobSpawn);
        }
    }
