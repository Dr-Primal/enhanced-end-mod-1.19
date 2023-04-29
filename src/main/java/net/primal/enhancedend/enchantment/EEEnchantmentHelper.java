package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

public class EEEnchantmentHelper extends EnchantmentHelper {

    public static boolean hasEnhancedMagic(LivingEntity entity) {
        return EnchantmentHelper.getEquipmentLevel(EEEnchantments.ENHANCED_MAGIC, entity) > 0;
    }
}
