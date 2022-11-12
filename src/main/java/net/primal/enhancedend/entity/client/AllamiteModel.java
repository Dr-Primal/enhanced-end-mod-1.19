package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.AllamiteEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class AllamiteModel extends AnimatedGeoModel<AllamiteEntity> {
    @Override
    public Identifier getModelResource(AllamiteEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/allamite.geo.json");
    }

    @Override
    public Identifier getTextureResource(AllamiteEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/allamite_texture.png");
    }

    @Override
    public Identifier getAnimationResource(AllamiteEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/allamite.animation.json");
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(AllamiteEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
