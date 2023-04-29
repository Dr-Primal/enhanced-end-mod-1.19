package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.primal.enhancedend.block.EEBlocks;
import net.primal.enhancedend.world.feature.EEConfiguredFeatures;

public class EENyliumBlock extends Block implements Fertilizable {
    public EENyliumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        if
        (blockState.isOf(EEBlocks.CORLITE_END_STONE) || blockState.isOf(Blocks.END_STONE)) {
            EEConfiguredFeatures.CORLITE_MUSHROOM.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.CORLITE_FESCUS.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.TINTED_OCULIT.value().generate(world, chunkGenerator, random, blockPos);
        }
        else if
        (blockState.isOf(EEBlocks.MIDNIGHT_END_STONE) || blockState.isOf(Blocks.END_STONE)) {
            EEConfiguredFeatures.MIDNIGHT_MUSHROOM.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.MIDNIGHT_FESCUS.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.SHADED_OCULIT.value().generate(world, chunkGenerator, random, blockPos);
        }
        else if
        (blockState.isOf(EEBlocks.ENDIUM_SOIL)) {
            EEConfiguredFeatures.ENDIUM_RHIZOME.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.ENDIUM_MUSHROOM_SAPLING.value().generate(world, chunkGenerator, random, blockPos);
            EEConfiguredFeatures.END_FLORIA.value().generate(world, chunkGenerator, random, blockPos);
        }
    }
}
