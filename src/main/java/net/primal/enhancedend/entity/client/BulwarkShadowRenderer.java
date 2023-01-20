package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkShadowEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BulwarkShadowRenderer extends GeoEntityRenderer<BulwarkShadowEntity> {

    public BulwarkShadowRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BulwarkShadowModel());
        this.shadowRadius = 1f;
    }

    @Override
    public Identifier getTextureResource(BulwarkShadowEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_shadow_texture.png");
    }

    @Override
    public RenderLayer getRenderType(BulwarkShadowEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {{
            stack.scale(1.2f, 1.3f, 1.2f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
