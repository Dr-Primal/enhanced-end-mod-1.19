package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(EnhancedEndermanEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone skull = this.getAnimationProcessor().getBone("skull");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (skull != null) {
            skull.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            skull.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
