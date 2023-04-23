package net.primal.enhancedend.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.primal.enhancedend.entity.projectile.thrown.ModEnderPearlEntity;

public class ModPhantomPearlItem extends Item {
    public ModPhantomPearlItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 3f, 4f / (world.getRandom().nextFloat() * 1f + 1f));
        user.getItemCooldownManager().set(this, 5);
        if (!world.isClient) {
            ModEnderPearlEntity modEnderPearlEntity = new ModEnderPearlEntity(world, user);
            modEnderPearlEntity.setItem(itemStack);
            modEnderPearlEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 4f, 0.0f);
            world.spawnEntity(modEnderPearlEntity);
            itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(itemStack, world.isClient());
    }
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.ENDER_PEARL) || super.canRepair(stack, ingredient);
    }
}

