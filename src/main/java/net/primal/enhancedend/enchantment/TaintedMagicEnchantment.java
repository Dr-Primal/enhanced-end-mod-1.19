package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class TaintedMagicEnchantment extends Enchantment {
    public TaintedMagicEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
    }
    public boolean isCursed() {
        return true;
    }

    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    public boolean isAvailableForRandomSelection() {
        return false;
    }


    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 4));
        }
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 80, 1));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 50, 0));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 0));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 50, 0));
        }
        super.onUserDamaged(user, target, level);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.THORNS && other !=ModEnchantments.ENHANCED_MAGIC;
    }
}
