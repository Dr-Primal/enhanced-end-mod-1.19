package net.primal.enhancedend.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.primal.enhancedend.entity.ModEntities;
import net.primal.enhancedend.entity.custom.AllamiteEntity;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.SMALL_END_ISLANDS), SpawnGroup.AMBIENT,
                        ModEntities.SEASPRAY, 5000, 4, 8);

        SpawnRestriction.register(ModEntities.SEASPRAY, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.END_BARRENS), SpawnGroup.MONSTER,
                        EntityType.PHANTOM, 5000, 3, 6);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                        BiomeKeys.END_HIGHLANDS), SpawnGroup.CREATURE,
                        ModEntities.ALLAMITE, 5000, 3, 6);

        SpawnRestriction.register(ModEntities.ALLAMITE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AllamiteEntity::canMobSpawn);
        }
    }
