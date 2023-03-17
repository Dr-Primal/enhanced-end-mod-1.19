package net.primal.enhancedend.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.entity.custom.BulwarkSentryEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BulwarkSentryRenderer extends GeoEntityRenderer<BulwarkSentryEntity> {

    public BulwarkSentryRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BulwarkSentryModel());
        this.shadowRadius = 1.0f;
    }

    @Override
    public Identifier getTextureResource(BulwarkSentryEntity instance) {
        return new Identifier(EnhancedEnd.MOD_ID, "textures/entity/bulwark_sentry_texture.png");
    }

    @Override
    public RenderLayer getRenderType(BulwarkSentryEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {{
            stack.scale(1.4f, 1.4f, 1.4f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
