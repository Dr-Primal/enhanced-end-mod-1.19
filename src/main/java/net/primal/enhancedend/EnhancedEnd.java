package net.primal.enhancedend;

import net.fabricmc.api.ModInitializer;
import net.primal.enhancedend.Item.ModItems;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnhancedEnd implements ModInitializer {

	public static final String MOD_ID = "enhancedend";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
