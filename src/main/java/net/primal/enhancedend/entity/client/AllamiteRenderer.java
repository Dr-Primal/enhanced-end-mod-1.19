package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.AllamiteEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AllamiteRenderer extends GeoEntityRenderer<AllamiteEntity> {

    public AllamiteRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AllamiteModel());
        this.shadowRadius = 1.2f;
    }

    @Override
    public Identifier getTextureResource(AllamiteEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/allamite_texture.png");
    }

    @Override
    public RenderLayer getRenderType(AllamiteEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.8f, 0.8f, 0.8f);

        } else {
            stack.scale(1.5f, 1.5f, 1.5f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
