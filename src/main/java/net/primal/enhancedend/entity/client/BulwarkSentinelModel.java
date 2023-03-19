package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkSentinelEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BulwarkSentinelModel extends AnimatedGeoModel<BulwarkSentinelEntity> {
    @Override
    public Identifier getModelResource(BulwarkSentinelEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/bulwark_striker.geo.json");
    }

    @Override
    public Identifier getTextureResource(BulwarkSentinelEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_striker_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BulwarkSentinelEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/bulwark_sentinel.animation.json");
    }
}
