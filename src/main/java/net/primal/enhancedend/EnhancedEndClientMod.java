package net.primal.enhancedend;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;
import net.primal.enhancedend.fluid.ModFluids;
import net.primal.enhancedend.util.ModModelPredicateProvider;

public class EnhancedEndClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDNIGHT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORLITE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDNIGHT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLITANIUM_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDNIGHT_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORLITE_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDIUM_MUSHROOM, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ENDER_MATTER, ModFluids.FLOWING_ENDER_MATTER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"), //texture names go here
                        new Identifier("minecraft:block/water_flow"), //texture names go here
                        0xA1f0fbca
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ENDER_MATTER, ModFluids.FLOWING_ENDER_MATTER);

        ModModelPredicateProvider.registerModModels();
    }

}