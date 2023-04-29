package net.primal.enhancedend.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.primal.enhancedend.block.EEBlocks;

public class CorliteMushroomBlock
        extends SaplingBlock {
    public CorliteMushroomBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(EEBlocks.CORLITE_END_STONE) || floor.isOf(Blocks.END_STONE);
    }

}