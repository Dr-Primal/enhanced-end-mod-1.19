package net.primal.enhancedend.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.primal.enhancedend.block.ModBlocks;

public class ModFlowerBlock extends FlowerBlock {
    public ModFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
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
