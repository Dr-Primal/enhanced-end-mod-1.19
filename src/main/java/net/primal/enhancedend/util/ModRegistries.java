package net.primal.enhancedend.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.primal.enhancedend.block.ModBlocks;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.MIDNIGHT_STEM, ModBlocks.STRIPPED_MIDNIGHT_STEM);
        StrippableBlockRegistry.register(ModBlocks.MIDNIGHT_STEM, ModBlocks.STRIPPED_MIDNIGHT_STEM);
        StrippableBlockRegistry.register(ModBlocks.CORLITE_STEM, ModBlocks.STRIPPED_CORLITE_STEM);
        StrippableBlockRegistry.register(ModBlocks.CORLITE_HYPHAE, ModBlocks.STRIPPED_CORLITE_HYPHAE);
    }
}
