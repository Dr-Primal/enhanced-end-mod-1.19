package net.primal.enhancedend;

import net.fabricmc.api.ModInitializer;
import net.primal.enhancedend.Item.ModItems;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.enchantment.ModEnchantments;
import net.primal.enhancedend.fluid.ModFluids;
import net.primal.enhancedend.util.ModRegistries;
import net.primal.enhancedend.world.feature.ModConfiguredFeatures;
import net.primal.enhancedend.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	}
}
