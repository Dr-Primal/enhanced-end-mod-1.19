package net.primal.enhancedend.entity.client;

import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkShadowEntity;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BulwarkShadowModel extends AnimatedGeoModel<BulwarkShadowEntity> {
    @Override
    public Identifier getModelResource(BulwarkShadowEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "geo/bulwark_shadow.geo.json");
    }

    @Override
    public Identifier getTextureResource(BulwarkShadowEntity object) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_shadow_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BulwarkShadowEntity animatable) {
        return new Identifier(EnhancedEnd.MOD_ID, "animations/bulwark_shadow.animation.json");
    }

    @SuppressWarnings({ "unchecked"})
    @Override
    public void setLivingAnimations(BulwarkShadowEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone skull = this.getAnimationProcessor().getBone("skull");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (skull != null) {
            skull.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            skull.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
