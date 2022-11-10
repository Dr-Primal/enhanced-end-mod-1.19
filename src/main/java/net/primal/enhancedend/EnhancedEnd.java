package net.primal.enhancedend;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.sound.SoundEvents;
import net.primal.enhancedend.Item.ModItems;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.enchantment.ModEnchantments;
import net.primal.enhancedend.entity.ModEntities;
import net.primal.enhancedend.entity.client.AllamiteRenderer;
import net.primal.enhancedend.entity.client.EnhancedEndermanRenderer;
import net.primal.enhancedend.entity.custom.AllamiteEntity;
import net.primal.enhancedend.entity.custom.EnhancedEndermanEntity;
import net.primal.enhancedend.fluid.ModFluids;
import net.primal.enhancedend.sound.ModSounds;
import net.primal.enhancedend.util.ModRegistries;
import net.primal.enhancedend.world.feature.ModConfiguredFeatures;
import net.primal.enhancedend.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class EnhancedEnd implements ModInitializer {

	public static final String MOD_ID = "enhancedend";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModFluids.register();
		ModWorldGen.generateWorldGen();
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModEnchantments.registerModEnchantments();

		GeckoLib.initialize();
//registering entities:
		FabricDefaultAttributeRegistry.register(ModEntities.ENHANCED_ENDERMAN, EnhancedEndermanEntity.setAttributes());
		EntityRendererRegistry.register(ModEntities.ENHANCED_ENDERMAN, EnhancedEndermanRenderer::new);

		FabricDefaultAttributeRegistry.register(ModEntities.ALLAMITE, AllamiteEntity.setAttributes());
		EntityRendererRegistry.register(ModEntities.ALLAMITE, AllamiteRenderer::new);
	}
}
