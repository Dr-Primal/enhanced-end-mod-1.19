package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class MagicDefenseEnchantment extends Enchantment {
    public MagicDefenseEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
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
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 50, 4));
        }
        if (user != null) {
            (user).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 50, 2));
        }
        super.onUserDamaged(user, target, level);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.THORNS;
    }
}
