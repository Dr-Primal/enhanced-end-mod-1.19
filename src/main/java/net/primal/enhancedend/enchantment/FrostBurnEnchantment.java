package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class FrostBurnEnchantment extends Enchantment {
    protected FrostBurnEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {

            if(level == 1) {
                if (target instanceof LivingEntity) {
                    if (target.getFrozenTicks() < 1000) {
                        target.setFrozenTicks(250);
                    }
                }
                if (target instanceof LivingEntity) {
                        ((LivingEntity) target).setMovementSpeed(0);
                    }
            }
            if(level == 2) {
                if (target instanceof LivingEntity) {
                    if (target.getFrozenTicks() < 1000) {
                        target.setFrozenTicks(350);
                    }
                }
                if (target instanceof LivingEntity) {
                    ((LivingEntity) target).setMovementSpeed(0);
                }
            }
        }
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT && other !=ModEnchantments.BLINDING_ASPECT;
    }
}
