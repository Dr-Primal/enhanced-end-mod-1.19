package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class FrostShotEnchantment extends Enchantment {
    protected FrostShotEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
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
                    if (target.getFrozenTicks() < 1000) {
                        target.setFrozenTicks(250);
                    }
                }
            }
            if(level == 2) {
                if (target instanceof LivingEntity) {
                    if (target.getFrozenTicks() < 1000) {
                        target.setFrozenTicks(350);
                    }
                }
            }
        }
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
}
