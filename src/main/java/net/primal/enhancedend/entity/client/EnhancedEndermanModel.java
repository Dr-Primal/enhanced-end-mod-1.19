package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnhancedEndermanModel extends AnimatedGeoModel<EnhancedEndermanEntity> {
    @Override
    public Identifier getModelResource(EnhancedEndermanEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/enhanced_enderman.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnhancedEndermanEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/enhanced_enderman_texture.png");
    }

    @Override
    public Identifier getAnimationResource(EnhancedEndermanEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/enhanced_enderman.animation.json");
    }
}
