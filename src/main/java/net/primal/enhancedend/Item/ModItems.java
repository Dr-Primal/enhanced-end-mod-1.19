package net.primal.enhancedend.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.Item.custom.ModBowItem;
import net.primal.enhancedend.Item.custom.ModEnchantedFoodItem;
import net.primal.enhancedend.Item.custom.ModEnderPearlItem;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.block.custom.ModHoeItem;

public class ModItems {
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    public static final Item CLITANIUM = registerItem("clitanium",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_INGOT = registerItem("endimintium_ingot",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_SCRAP = registerItem("endimintium_scrap",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item DIAMOND_FRAGMENT = registerItem("diamond_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    //Sign Variants
    public static final Item MIDNIGHT_SIGN = registerItem("midnight_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_BLOCKS).maxCount(16),
                    ModBlocks.MIDNIGHT_SIGN_BLOCK, ModBlocks.MIDNIGHT_WALL_SIGN_BLOCK));
    public static final Item CORLITE_SIGN = registerItem("corlite_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_BLOCKS).maxCount(16),
                    ModBlocks.CORLITE_SIGN_BLOCK, ModBlocks.CORLITE_WALL_SIGN_BLOCK));
    //Bow(*Change name and texture of Bow*)
    public static final Item ENDIMINTIUM_BOW = registerItem("endimintium_bow",
            new ModBowItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).maxDamage(500).fireproof()));
    /*
    Add Staffs that Shoot Magic Projectiles that give effects on hit; they act as a bow item, however do NOT get the same enchantments as the bow item.
    Either A: Books can be found that can be added onto a staff of some sort like an enchantment
    OR B: Individual Staffs can be found/created throughout the world that give different effects on use
    */
    //Armor
    public static final Item ENDIMINTIUM_HELMET = registerItem("endimintium_helmet",
            new ArmorItem(ModArmorMaterials.ENDIMINTIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_CHESTPLATE = registerItem("endimintium_chestplate",
            new ArmorItem(ModArmorMaterials.ENDIMINTIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_LEGGINGS = registerItem("endimintium_leggings",
            new ArmorItem(ModArmorMaterials.ENDIMINTIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_BOOTS = registerItem("endimintium_boots",
            new ArmorItem(ModArmorMaterials.ENDIMINTIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));

    //Tools
    public static final Item ENDIMINTIUM_SWORD = registerItem("endimintium_sword",
            new SwordItem(ModToolMaterial.ENDIMINTIUM, 4, -2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_AXE = registerItem("endimintium_axe",
            new AxeItem(ModToolMaterial.ENDIMINTIUM, 6f, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_HOE = registerItem("endimintium_hoe",
            new ModHoeItem(ModToolMaterial.ENDIMINTIUM, -5, 0f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_SHOVEL = registerItem("endimintium_shovel",
            new ShovelItem(ModToolMaterial.ENDIMINTIUM, 2.5f, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENDIMINTIUM_PICKAXE = registerItem("endimintium_pickaxe",
            new PickaxeItem(ModToolMaterial.ENDIMINTIUM, 2, -2.8f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ENHANCED_END_ITEMS)));

    //Food Items
    public static final Item ENDER_MATTER_SPECK = registerItem("ender_matter_speck",
            new ModEnchantedFoodItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item TANZANITE_BEETROOT = registerItem("tanzanite_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6000, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 6000, 0), 0.5f)
                            .alwaysEdible().build())));
    public static final Item DIAMOND_INFUSED_BEETROOT = registerItem("diamond_infused_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 0), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 0), 1f)
                            .alwaysEdible().build())));
    public static final Item ENHANCED_BEETROOT = registerItem("enhanced_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 4), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000, 1), 0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000, 1), 0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1000, 0), 0.6f)
                            .alwaysEdible().build())));
    public static final Item CORRUPTED_BEETROOT = registerItem("corrupted_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 50, 5), 0.4f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 50, 3), 0.4f)
                            .alwaysEdible().build())));

    //Main Loot Drops
    public static final Item REINFORCED_SHARD = registerItem("reinforced_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item ENHANCED_PEARL = registerItem("enhanced_pearl",
            new ModEnderPearlItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.ENHANCED_END_ITEMS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancedEnd.MOD_ID, name), item);
    }
    public static void registerModItems() {
        EnhancedEnd.LOGGER.debug("Registering Mod Items For " + EnhancedEnd.MOD_ID);
    }
}
