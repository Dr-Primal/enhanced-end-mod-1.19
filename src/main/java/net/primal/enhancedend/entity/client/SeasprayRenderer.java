package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.SeasprayEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SeasprayRenderer extends GeoEntityRenderer<SeasprayEntity> {
    public SeasprayRenderer(EntityRendererFactory.Context ctx, AnimatedGeoModel<SeasprayEntity> modelProvider) {
        super(ctx, modelProvider);
    }

    public SeasprayRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SeasprayModel());
        this.shadowRadius = 1.4f;
    }

    @Override
    public Identifier getTextureResource(SeasprayEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/seaspray_texture.png");
    }

    @Override
    public RenderLayer getRenderType(SeasprayEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1.5f, 1f, 1.5f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
