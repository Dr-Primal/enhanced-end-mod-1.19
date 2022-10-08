package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class BlindingAspectEnchantment extends Enchantment {
    public BlindingAspectEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {

            if(level == 1) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 0));
                }
            }

            if(level == 2) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 75, 0));
                }
            }
            if(level == 3) {
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0));
                }
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
    }
}
