package net.primal.enhancedend.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;

public class ModEntities {
    public static final EntityType<EnhancedEndermanEntity> ENHANCED_ENDERMAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EnhancedEnd.MOD_ID, "enhanced_enderman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EnhancedEndermanEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 3f)).build());

}
