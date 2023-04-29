package net.primal.enhancedend.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.primal.enhancedend.block.EEBlocks;

public class EndiumMushroomBlock
        extends SaplingBlock {
    public EndiumMushroomBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(EEBlocks.ENDIUM_SOIL);
    }

}