package net.primal.enhancedend.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.primal.enhancedend.block.EEBlocks;

public class KimberliteSpikeFeature extends Feature<DefaultFeatureConfig> {
    public KimberliteSpikeFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public static boolean isSoil(BlockState state) {
        return state.isOf(EEBlocks.KIMBERLITE);
    }

        @Override
        public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        int l;
        int k;
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        while (structureWorldAccess.isAir(blockPos) && blockPos.getY() > structureWorldAccess.getBottomY() + 2) {
            blockPos = blockPos.down();
        }
        if (!structureWorldAccess.getBlockState(blockPos).isOf(EEBlocks.KIMBERLITE)) {
            return false;
        }
        blockPos = blockPos.up(random.nextInt(4));
        int i = random.nextInt(4) + 7;
        int j = i / 4 + random.nextInt(2);
        if (j > 1 && random.nextInt(60) == 0) {
            blockPos = blockPos.up(10 + random.nextInt(30));
        }
        for (k = 0; k < i; ++k) {
            float f = (1.0f - (float)k / (float)i) * (float)j;
            l = MathHelper.ceil(f);
            for (int m = -l; m <= l; ++m) {
                float g = (float)MathHelper.abs(m) - 0.25f;
                for (int n = -l; n <= l; ++n) {
                    float h = (float)MathHelper.abs(n) - 0.25f;
                    if ((m != 0 || n != 0) && g * g + h * h > f * f || (m == -l || m == l || n == -l || n == l) && random.nextFloat() > 0.75f) continue;
                    BlockState blockState = structureWorldAccess.getBlockState(blockPos.add(m, k, n));
                    if (blockState.isAir() || KimberliteSpikeFeature.isSoil(blockState) || blockState.isOf(Blocks.END_STONE) || blockState.isOf(EEBlocks.KIMBERLITE) || blockState.isOf(EEBlocks.SILSTONE)) {
                        this.setBlockState(structureWorldAccess, blockPos.add(m, k, n), EEBlocks.KIMBERLITE.getDefaultState());
                    }
                    if (k == 0 || l <= 1 || !(blockState = structureWorldAccess.getBlockState(blockPos.add(m, -k, n))).isAir() && KimberliteSpikeFeature.isSoil(blockState) && !blockState.isOf(Blocks.END_STONE) && !blockState.isOf(EEBlocks.KIMBERLITE) && !blockState.isOf(EEBlocks.SILSTONE)) continue;
                    this.setBlockState(structureWorldAccess, blockPos.add(m, -k, n), EEBlocks.KIMBERLITE.getDefaultState());
                }
            }
        }
        k = j - 1;
        if (k < 0) {
            k = 0;
        } else if (k > 1) {
            k = 1;
        }
        for (int o = -k; o <= k; ++o) {
            for (l = -k; l <= k; ++l) {
                BlockState blockState2;
                BlockPos blockPos2 = blockPos.add(o, -1, l);
                int p = 50;
                if (Math.abs(o) == 1 && Math.abs(l) == 1) {
                    p = random.nextInt(5);
                }
                while (blockPos2.getY() > 50 && ((blockState2 = structureWorldAccess.getBlockState(blockPos2)).isAir() || KimberliteSpikeFeature.isSoil(blockState2)|| blockState2.isOf(Blocks.END_STONE) || blockState2.isOf(EEBlocks.KIMBERLITE) ||  blockState2.isOf(EEBlocks.SILSTONE))) {
                    this.setBlockState(structureWorldAccess, blockPos2, EEBlocks.KIMBERLITE.getDefaultState());
                    blockPos2 = blockPos2.down();
                    if (--p > 0) continue;
                    blockPos2 = blockPos2.down(random.nextInt(5) + 1);
                    p = random.nextInt(5);
                }
            }
        }
        return true;
    }
    }
