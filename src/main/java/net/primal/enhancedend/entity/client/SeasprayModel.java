package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.SeasprayEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeasprayModel extends AnimatedGeoModel<SeasprayEntity> {

    @Override
    public Identifier getModelResource(SeasprayEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/seaspray.geo.json");
    }

    @Override
    public Identifier getTextureResource(SeasprayEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/seaspray_texture.png");
    }

    @Override
    public Identifier getAnimationResource(SeasprayEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/seaspray.animation.json");
    }
}
