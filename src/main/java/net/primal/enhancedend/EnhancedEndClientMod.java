package net.primal.enhancedend;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.block.EEBlocks;
import net.minecraft.client.render.RenderLayer;
import net.primal.enhancedend.entity.EEEntities;
import net.primal.enhancedend.fluid.EEFluids;
import net.primal.enhancedend.util.EEModelPredicateProvider;

public class EnhancedEndClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.MIDNIGHT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.CORLITE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.MIDNIGHT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.CLITANIUM_BARS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.MIDNIGHT_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_MIDNIGHT_MUSHROOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.CORLITE_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_CORLITE_MUSHROOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.ENDIUM_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_ENDIUM_MUSHROOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.SHADED_OCULIT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_SHADED_OCULIT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.TINTED_OCULIT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_TINTED_OCULIT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.ENERIA_CANE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.END_FLORIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.POTTED_END_FLORIA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.MIDNIGHT_FESCUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.ENDIUM_RHIZOME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EEBlocks.CORLITE_FESCUS, RenderLayer.getCutout());



        FluidRenderHandlerRegistry.INSTANCE.register(EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"), //texture names go here
                        new Identifier("minecraft:block/water_flow"), //texture names go here
                        0xA1f0fbca
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                EEFluids.STILL_ENDER_MATTER, EEFluids.FLOWING_ENDER_MATTER);

        EEModelPredicateProvider.registerEEModels();


        EntityRendererRegistry.register(EEEntities.BlindDiskEntityEntityType, FlyingItemEntityRenderer::new);
    }

}