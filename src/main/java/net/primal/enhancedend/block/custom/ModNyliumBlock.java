package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.world.feature.ModConfiguredFeatures;

public class ModNyliumBlock extends Block implements Fertilizable {
    public ModNyliumBlock(Settings settings) {
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
        (blockState.isOf(ModBlocks.CORLITE_END_STONE)) {
            ModConfiguredFeatures.CORLITE_MUSHROOM.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.CORLITE_FESCUS.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.TINTED_OCULIT.value().generate(world, chunkGenerator, random, blockPos);
        }
        else if
        (blockState.isOf(ModBlocks.MIDNIGHT_END_STONE)) {
            ModConfiguredFeatures.MIDNIGHT_MUSHROOM.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.MIDNIGHT_FESCUS.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.SHADED_OCULIT.value().generate(world, chunkGenerator, random, blockPos);
        }
        else if
        (blockState.isOf(ModBlocks.ENDIUM_SOIL)) {
            ModConfiguredFeatures.ENDIUM_RHIZOME.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.ENDIUM_MUSHROOM_SAPLING.value().generate(world, chunkGenerator, random, blockPos);
            ModConfiguredFeatures.END_FLORIA.value().generate(world, chunkGenerator, random, blockPos);
        }
    }
}
