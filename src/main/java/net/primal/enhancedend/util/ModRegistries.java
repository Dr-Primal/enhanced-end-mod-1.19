package net.primal.enhancedend.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.primal.enhancedend.block.ModBlocks;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.MIDNIGHT_LOG, ModBlocks.STRIPPED_MIDNIGHT_LOG);
        StrippableBlockRegistry.register(ModBlocks.MIDNIGHT_WOOD, ModBlocks.STRIPPED_MIDNIGHT_WOOD);
    }
}
