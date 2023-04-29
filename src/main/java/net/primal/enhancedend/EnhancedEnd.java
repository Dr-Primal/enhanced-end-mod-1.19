package net.primal.enhancedend;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.primal.enhancedend.entity.EEEntities;
import net.primal.enhancedend.item.EEItems;
import net.primal.enhancedend.block.EEBlocks;
import net.primal.enhancedend.enchantment.EEEnchantments;
import net.primal.enhancedend.entity.client.*;
import net.primal.enhancedend.entity.custom.*;
import net.primal.enhancedend.fluid.EEFluids;
import net.primal.enhancedend.util.EERegistries;
import net.primal.enhancedend.world.feature.EEConfiguredFeatures;
import net.primal.enhancedend.world.gen.EEWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class EnhancedEnd implements ModInitializer {

	public static final String MOD_ID = "enhancedend";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		EEItems.registerEEItems();
		EEBlocks.registerEEBlocks();
		EERegistries.eeRegistry();
		EEFluids.register();
		EEWorldGen.generateWorldGen();
		EEConfiguredFeatures.registerConfiguredFeatures();
		EEEnchantments.registerEEEnchantments();

		GeckoLib.initialize();
//registering entities:
		FabricDefaultAttributeRegistry.register(EEEntities.ENHANCED_ENDERMAN, EnhancedEndermanEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.ENHANCED_ENDERMAN, EnhancedEndermanRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.ALLAMITE, AllamiteEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.ALLAMITE, AllamiteRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.SEASPRAY, SeasprayEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.SEASPRAY, SeasprayRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.ENFORCED_OBSIDIAN_GOLEM, EnforcedObsidianGolemEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.ENFORCED_OBSIDIAN_GOLEM, EnforcedObsidianGolemRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.BULWARK_SENTRY, BulwarkSentryEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.BULWARK_SENTRY, BulwarkSentryRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.BULWARK_SHADOW, BulwarkShadowEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.BULWARK_SHADOW, BulwarkShadowRenderer::new);

		FabricDefaultAttributeRegistry.register(EEEntities.BULWARK_SENTINEL, BulwarkSentinelEntity.setAttributes());
		EntityRendererRegistry.register(EEEntities.BULWARK_SENTINEL, BulwarkSentinelRenderer::new);
	}
}
