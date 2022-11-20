package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnforcedObsidianGolemEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnforcedObsidianGolemModel extends AnimatedGeoModel<EnforcedObsidianGolemEntity> {
    @Override
    public Identifier getModelResource(EnforcedObsidianGolemEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/enforced_obsidian_golem.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnforcedObsidianGolemEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/enforced_obsidian_golem_texture.png");
    }

    @Override
    public Identifier getAnimationResource(EnforcedObsidianGolemEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/enforced_obsidian_golem.animation.json");
    }
}
