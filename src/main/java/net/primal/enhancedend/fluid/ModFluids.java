package net.primal.enhancedend.fluid;

import net.minecraft.block.FluidBlock;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.block.custom.ModMaterial;

public class ModFluids {
    public static FlowableFluid STILL_ENDER_MATTER;
    public static FlowableFluid FLOWING_ENDER_MATTER;
    public static Block ENDER_MATTER_BLOCK;
    public static Item ENDER_MATTER_BUCKET;

    public static void register() {
        STILL_ENDER_MATTER = Registry.register(Registry.FLUID,
                new Identifier(EnhancedEnd.MOD_ID, "ender_matter"), new EnderMatterFluid.Still());
        FLOWING_ENDER_MATTER = Registry.register(Registry.FLUID,
                new Identifier(EnhancedEnd.MOD_ID, "flowing_ender_matter"), new EnderMatterFluid.Flowing());

        ENDER_MATTER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(EnhancedEnd.MOD_ID, "ender_matter_block"),
                new FluidBlock(ModFluids.STILL_ENDER_MATTER, FabricBlockSettings.of(ModMaterial.ENDER_MATTER)){ });
        ENDER_MATTER_BUCKET = Registry.register(Registry.ITEM, new Identifier(EnhancedEnd.MOD_ID, "ender_matter_bucket"),
                new BucketItem(ModFluids.STILL_ENDER_MATTER, new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
