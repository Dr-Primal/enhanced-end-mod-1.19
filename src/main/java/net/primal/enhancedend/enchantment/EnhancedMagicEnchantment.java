package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class EnhancedMagicEnchantment extends Enchantment {
    public EnhancedMagicEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
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
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 50, 0));
        }
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 2));
        }
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 0));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 60, 0));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 2));
        }
        super.onUserDamaged(user, target, level);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
