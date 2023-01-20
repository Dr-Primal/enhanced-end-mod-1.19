package net.primal.enhancedend.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.*;

public class ModEntities {
    public static final EntityType<EnhancedEndermanEntity> ENHANCED_ENDERMAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "enhanced_enderman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnhancedEndermanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build());

    public static final EntityType<AllamiteEntity> ALLAMITE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "allamite"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AllamiteEntity::new)
                    .dimensions(EntityDimensions.changing(1.2f, 1.5f)).build());

    public static final EntityType<SeasprayEntity> SEASPRAY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "seaspray"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SeasprayEntity::new)
                    .dimensions(EntityDimensions.changing(1f, 0.6f)).build());

    public static final EntityType<EnforcedObsidianGolemEntity> ENFORCED_OBSIDIAN_GOLEM = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "enforced_obsidian_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnforcedObsidianGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(0.95f, 3.1f)).build());

    public static final EntityType<BulwarkSentryEntity> BULWARK_SENTRY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "bulwark_sentry"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BulwarkSentryEntity::new)
                    .dimensions(EntityDimensions.fixed(0.95f, 1.3f)).build());

    public static final EntityType<BulwarkShadowEntity> BULWARK_SHADOW = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "bulwark_shadow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BulwarkShadowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.95f, 1.75f)).build());
}
