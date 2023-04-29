package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.primal.enhancedend.block.EEBlocks;

public class EEFlowerBlock extends FlowerBlock {
    public EEFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 12.0, 14.0, 12.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(EEBlocks.MIDNIGHT_END_STONE) ||
                floor.isOf(EEBlocks.ENDIUM_SOIL) ||
                floor.isOf(EEBlocks.CORLITE_END_STONE) ||
                floor.isOf(Blocks.END_STONE) ||
                super.canPlantOnTop(floor, world, pos);
    }
}
