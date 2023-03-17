package net.primal.enhancedend.Item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.primal.enhancedend.entity.projectile.thrown.BlindDiskEntity;

public class ModDiskItem extends Item {
    public ModDiskItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.NEUTRAL, 0.5f, 5.0f);
		user.getItemCooldownManager().set(this, 7);

        if (!world.isClient) {
            BlindDiskEntity snowballEntity = new BlindDiskEntity(world, user);
            snowballEntity.setItem(itemStack);
            snowballEntity.setVelocity(user, user.prevPitch, user.prevYaw, 0.0f, 3.7f, 0f);
            world.spawnEntity(snowballEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
