package net.primal.enhancedend.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.EndIslandFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.primal.enhancedend.block.EEBlocks;

public class EndiumIslandFeature extends EndIslandFeature {
    public EndiumIslandFeature(Codec < DefaultFeatureConfig > codec) {
        super(codec);
    }

        @Override
        public boolean generate (FeatureContext < DefaultFeatureConfig > context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        float f = (float) random.nextInt(3) + 4.0f;
        int i = 0;
        while (f > 0.5f) {
            for (int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
                for (int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
                    if (!((float) (j * j + k * k) <= (f + 1.0f) * (f + 1.0f))) continue;
                    this.setBlockState(structureWorldAccess, blockPos.add(j, i, k), EEBlocks.ENDIUM_SOIL.getDefaultState());
                }
            }
            f -= (float) random.nextInt(2) + 0.5f;
            --i;
        }
        return true;
    }
    }