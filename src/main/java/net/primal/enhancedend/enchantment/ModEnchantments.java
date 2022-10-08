package net.primal.enhancedend.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;

public class ModEnchantments {
    public static final Enchantment MAGIC_INFUSED = register("magic_infused",
            new MagicDefenseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.CHEST));
    public static Enchantment BLINDING_ASPECT = register("blinding_aspect",
            new BlindingAspectEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EnhancedEnd.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + EnhancedEnd.MOD_ID);
    }
}
