package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;

public class EEEnchantments {

    public static final Enchantment ENHANCED_MAGIC = register("enhanced_magic",
            new EnhancedMagicEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.CHEST));
    public static Enchantment BLINDSIGHTING = register("blindsighting",
            new BlindsightingEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EnhancedEnd.MOD_ID, name), enchantment);
    }

    public static void registerEEEnchantments() {
        System.out.println("Registering Enchantments for " + EnhancedEnd.MOD_ID);
    }
}
