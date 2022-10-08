package net.primal.enhancedend.block.custom;

import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModScoriaBlock extends Block {
    public ModScoriaBlock(Settings settings) {super(settings);}
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(DamageSource.MAGIC, 2.0f);
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
