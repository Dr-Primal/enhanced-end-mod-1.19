package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkSentryEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BulwarkSentryModel extends AnimatedGeoModel<BulwarkSentryEntity> {
    @Override
    public Identifier getModelResource(BulwarkSentryEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/bulwark_sentry.geo.json");
    }

    @Override
    public Identifier getTextureResource(BulwarkSentryEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_sentry_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BulwarkSentryEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/bulwark_sentry.animation.json");
    }
}
