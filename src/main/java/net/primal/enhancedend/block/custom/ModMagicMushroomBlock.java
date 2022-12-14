package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.primal.enhancedend.block.ModBlocks;

public class ModMagicMushroomBlock
        extends SaplingBlock {

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param generator
     * @param settings
     */
    public ModMagicMushroomBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.MIDNIGHT_END_STONE) ||
                floor.isOf(ModBlocks.ENDIUM_SOIL) ||
                floor.isOf(ModBlocks.CORLITE_END_STONE) ||
                floor.isOf(Blocks.END_STONE) ||
                super.canPlantOnTop(floor, world, pos);
    }

}