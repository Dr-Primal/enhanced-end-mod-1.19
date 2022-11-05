package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EnhancedEndermanRenderer extends GeoEntityRenderer<EnhancedEndermanEntity> {

    public EnhancedEndermanRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new EnhancedEndermanModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(EnhancedEndermanEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/enhanced_enderman_texture.png");
    }

    @Override
    public RenderLayer getRenderType(EnhancedEndermanEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1f, 1.2f, 1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
