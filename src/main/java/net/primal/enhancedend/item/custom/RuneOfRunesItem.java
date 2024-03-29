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
import net.primal.enhancedend.item.EEItems;

public class RuneOfRunesItem extends Item {
    public RuneOfRunesItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.NEUTRAL, 1.0f, world.random.nextFloat() * 0.1f + 0.9f);
        user.getItemCooldownManager().set(this, 1200);
        if (!world.isClient) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 1));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 15, 49));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 45, 2));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 9));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1600, 4));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 45, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0));
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1200, 0));
            (user).removeStatusEffect(StatusEffects.MINING_FATIGUE);
            (user).removeStatusEffect(StatusEffects.GLOWING);
            (user).removeStatusEffect(StatusEffects.LEVITATION);
            (user).removeStatusEffect(StatusEffects.POISON);
            (user).removeStatusEffect(StatusEffects.WITHER);
            (user).removeStatusEffect(StatusEffects.HUNGER);
            (user).removeStatusEffect(StatusEffects.BLINDNESS);
            (user).removeStatusEffect(StatusEffects.DARKNESS);
            (user).removeStatusEffect(StatusEffects.WEAKNESS);
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
