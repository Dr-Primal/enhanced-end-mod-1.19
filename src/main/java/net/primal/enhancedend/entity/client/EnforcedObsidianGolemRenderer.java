package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.EnforcedObsidianGolemEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EnforcedObsidianGolemRenderer extends GeoEntityRenderer<EnforcedObsidianGolemEntity> {
    public EnforcedObsidianGolemRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new EnforcedObsidianGolemModel());
        this.shadowRadius = 1.0f;
    }
    @Override
    public Identifier getTextureResource(EnforcedObsidianGolemEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/enforced_obsidian_golem_texture.png");
    }

    @Override
    public RenderLayer getRenderType(EnforcedObsidianGolemEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(1.7f, 1.7f, 1.7f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
