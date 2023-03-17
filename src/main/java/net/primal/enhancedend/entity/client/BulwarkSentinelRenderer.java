package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkSentinelEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BulwarkSentinelRenderer extends GeoEntityRenderer<BulwarkSentinelEntity> {

    public BulwarkSentinelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BulwarkSentinelModel());
        this.shadowRadius = 1.0f;
    }

    @Override
    public Identifier getTextureResource(BulwarkSentinelEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_striker_texture.png");
    }

    @Override
    public RenderLayer getRenderType(BulwarkSentinelEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1.2f, 1.5f, 1.2f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
