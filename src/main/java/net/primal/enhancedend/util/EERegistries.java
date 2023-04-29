package net.primal.enhancedend.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.primal.enhancedend.block.EEBlocks;

public class EERegistries {
    public static void eeRegistry() {registerStrippables();}

    private static void registerStrippables() {
        StrippableBlockRegistry.register(EEBlocks.MIDNIGHT_STEM, EEBlocks.STRIPPED_MIDNIGHT_STEM);
        StrippableBlockRegistry.register(EEBlocks.MIDNIGHT_STEM, EEBlocks.STRIPPED_MIDNIGHT_STEM);
        StrippableBlockRegistry.register(EEBlocks.CORLITE_STEM, EEBlocks.STRIPPED_CORLITE_STEM);
        StrippableBlockRegistry.register(EEBlocks.CORLITE_HYPHAE, EEBlocks.STRIPPED_CORLITE_HYPHAE);
    }
}
