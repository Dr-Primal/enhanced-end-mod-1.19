package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.primal.enhancedend.block.EEBlocks;
import net.primal.enhancedend.fluid.EEFluids;

public class EneriaCaneBlock extends SugarCaneBlock {
    public EneriaCaneBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
    }
    public static final IntProperty AGE = Properties.AGE_15;
    protected static final float field_31258 = 6.0f;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isAir(pos.up())) {
            int i = 1;
            while (world.getBlockState(pos.down(i)).isOf(this)) {
                ++i;
            }
            if (i < 5) {
                int j = state.get(AGE);
                if (j == 15) {
                    world.setBlockState(pos.up(), this.getDefaultState());
                    world.setBlockState(pos, (BlockState)state.with(AGE, 0), Block.NO_REDRAW);
                } else {
                    world.setBlockState(pos, (BlockState)state.with(AGE, j + 1), Block.NO_REDRAW);
                }
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 1);
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.isOf(this)) {
            return true;
        }
        if (blockState.isOf(EEBlocks.ENDIUM_SOIL) || blockState.isOf(EEBlocks.HARDENED_ENDER_MATTER)) {
            BlockPos blockPos = pos.down();
            for (Direction direction : Direction.Type.HORIZONTAL) {
                FluidState fluidState = world.getFluidState(blockPos.offset(direction));
                if (!fluidState.isOf(EEFluids.STILL_ENDER_MATTER)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
