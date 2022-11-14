package net.primal.enhancedend.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.AllamiteEntity;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import net.primal.enhancedend.entity.custom.SeasprayEntity;

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
}
