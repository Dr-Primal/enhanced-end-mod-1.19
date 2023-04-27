package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.primal.enhancedend.block.ModBlocks;

public class RhizomeBlock extends FernBlock {
    public RhizomeBlock(Settings settings) {
        super(settings);
    }
    public static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 16.0, 9.0, 16.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.ENDIUM_SOIL) || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }
}
