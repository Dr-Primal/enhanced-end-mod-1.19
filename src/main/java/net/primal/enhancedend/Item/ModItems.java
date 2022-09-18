package net.primal.enhancedend.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;

public class ModItems {
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    public static final Item CLITANIUM = registerItem("clitanium",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancedEnd.MOD_ID, name), item);
    }
    public static void registerModItems() {
        EnhancedEnd.LOGGER.debug("Registering Mod Items For " + EnhancedEnd.MOD_ID);
    }
}
