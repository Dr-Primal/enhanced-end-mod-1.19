package net.primal.enhancedend.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.primal.enhancedend.item.EEItems;

public class NegationRuneItem extends Item {
    public NegationRuneItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.NEUTRAL, 1.0f, world.random.nextFloat() * 0.1f + 0.9f);
        user.getItemCooldownManager().set(this, 4800);
        if (!world.isClient) {
            (user).removeStatusEffect(StatusEffects.MINING_FATIGUE);
            (user).removeStatusEffect(StatusEffects.GLOWING);
            (user).removeStatusEffect(StatusEffects.LEVITATION);
            (user).removeStatusEffect(StatusEffects.POISON);
            (user).removeStatusEffect(StatusEffects.WITHER);
            (user).removeStatusEffect(StatusEffects.HUNGER);
            (user).removeStatusEffect(StatusEffects.BLINDNESS);
            (user).removeStatusEffect(StatusEffects.DARKNESS);
            (user).removeStatusEffect(StatusEffects.WEAKNESS);
            (user).setFireTicks(0);
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
        return ingredient.isOf(EEItems.SHADOW_SHARD) || super.canRepair(stack, ingredient);
    }
}
