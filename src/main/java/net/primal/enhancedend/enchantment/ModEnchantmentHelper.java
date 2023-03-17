package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;

public class ModEnchantmentHelper extends EnchantmentHelper {

    public static boolean hasEnhancedMagic(LivingEntity entity) {
        return EnchantmentHelper.getEquipmentLevel(ModEnchantments.ENHANCED_MAGIC, entity) > 0;
    }
}
