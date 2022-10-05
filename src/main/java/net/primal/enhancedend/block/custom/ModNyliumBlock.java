package net.primal.enhancedend.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;
import net.primal.enhancedend.block.ModBlocks;

public class ModNyliumBlock extends NyliumBlock {
    public ModNyliumBlock(Settings settings) {
        super(settings);
    }
    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
        return i < world.getMaxLightLevel();
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        if (blockState.isOf(ModBlocks.CORLITE_END_STONE)) {
            NetherConfiguredFeatures.CRIMSON_FOREST_VEGETATION_BONEMEAL.value().generate(world, chunkGenerator, random, blockPos);
        } else if (blockState.isOf(ModBlocks.MIDNIGHT_END_STONE)) {
            NetherConfiguredFeatures.WARPED_FOREST_VEGETATION_BONEMEAL.value().generate(world, chunkGenerator, random, blockPos);
            NetherConfiguredFeatures.NETHER_SPROUTS_BONEMEAL.value().generate(world, chunkGenerator, random, blockPos);
            if (random.nextInt(8) == 0) {
                NetherConfiguredFeatures.TWISTING_VINES_BONEMEAL.value().generate(world, chunkGenerator, random, blockPos);
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!ModNyliumBlock.stayAlive(state, world, pos)) {
            world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
        }
    }
}
