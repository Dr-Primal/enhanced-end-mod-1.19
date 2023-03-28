package net.primal.enhancedend.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;
import net.primal.enhancedend.Item.custom.*;
import net.primal.enhancedend.block.ModBlocks;
import net.primal.enhancedend.block.custom.ModHoeItem;
import net.primal.enhancedend.entity.ModEntities;
import net.primal.enhancedend.sound.ModSounds;

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

    //Bow
    public static final Item ENDIMINTIUM_BOW = registerItem("endimintium_bow",
            new ModBowItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).maxDamage(1000).fireproof()));
    public static final Item ENDIMINTIUM_CROSSBOW = registerItem("endimintium_crossbow",
            new ModCrossbowItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).maxDamage(1500).fireproof()));

    public static final Item CLITANIUM_BOW = registerItem("clitanium_bow",
            new ModClitaniumBowItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).maxDamage(500)));
    public static final Item CLITANIUM_CROSSBOW = registerItem("clitanium_crossbow",
            new ModClitaniumCrossbowItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).maxDamage(750)));
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

    public static final Item CLITANIUM_HELMET = registerItem("clitanium_helmet",
            new ArmorItem(ModArmorMaterials.CLITANIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_CHESTPLATE = registerItem("clitanium_chestplate",
            new ArmorItem(ModArmorMaterials.CLITANIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_LEGGINGS = registerItem("clitanium_leggings",
            new ArmorItem(ModArmorMaterials.CLITANIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_BOOTS = registerItem("clitanium_boots",
            new ArmorItem(ModArmorMaterials.CLITANIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

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

    public static final Item CLITANIUM_SWORD = registerItem("clitanium_sword",
            new SwordItem(ModToolMaterial.CLITANIUM, 3, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_AXE = registerItem("clitanium_axe",
            new AxeItem(ModToolMaterial.CLITANIUM, 6.0f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_HOE = registerItem("clitanium_hoe",
            new ModHoeItem(ModToolMaterial.CLITANIUM, -2, 0f,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_SHOVEL = registerItem("clitanium_shovel",
            new ShovelItem(ModToolMaterial.CLITANIUM, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    public static final Item CLITANIUM_PICKAXE = registerItem("clitanium_pickaxe",
            new PickaxeItem(ModToolMaterial.CLITANIUM, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    //Food Items
    public static final Item ENERIA_SPECK = registerItem("eneria_speck",
            new ModEnchantedFoodItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item TANZANITE_BEETROOT = registerItem("tanzanite_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6000, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 6000, 0), 0.5f)
                            .alwaysEdible().build())));
    public static final Item DIAMOND_BEETROOT = registerItem("diamond_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000, 0), 1f)
                            .alwaysEdible().build())));
    public static final Item GOLDEN_BEETROOT = registerItem("golden_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400, 0), 1f)
                            .alwaysEdible().build())));
    public static final Item ENHANCED_BEETROOT = registerItem("enhanced_beetroot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 500, 2), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 1), 0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 500, 1), 0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 500, 0), 0.6f)
                            .alwaysEdible().build())));
    public static final Item ENCHANTED_ENHANCED_BEETROOT = registerItem("enchanted_enhanced_beetroot",
            new ModEnchantedFoodItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 2), 1f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000, 2), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 1), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1000, 0), 0.8f)
                            .alwaysEdible().build())));
    public static final Item CORRUPTED_BEETROOT = registerItem("corrupted_beetroot",
            new ModEnchantedFoodItem(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .maxCount(16)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(1.5f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 50, 5), 0.4f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 500, 0), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 50, 3), 0.4f)
                            .alwaysEdible().build())));

    public static final Item RAW_ALLAM = registerItem("raw_allam",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 50, 0), 0.6f)
                            .build())));
    public static final Item COOKED_ALLAM = registerItem("cooked_allam",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)
                    .food(new FoodComponent.Builder().hunger(9).saturationModifier(0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 50, 0), 0.2f)
                            .build())));

    //Main Loot Drops
    public static final Item REINFORCED_SHARD = registerItem("reinforced_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    //Drops from Reinforced Obsidian Golems^

    public static final Item ENHANCED_PEARL = registerItem("enhanced_pearl",
            new ModEnderPearlItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.ENHANCED_END_ITEMS)));
    //Drops from Enhanced Enderman^

    //Crafted from Enhanced Pearl, Phantom Membranes, Eneria Speck
    public static final Item PHANTOM_PEARL = registerItem("phantom_pearl",
            new ModPhantomPearlItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.ENHANCED_END_ITEMS)));
    //Loot drop from Bulwark Sentry
    public static final Item SENTRY_DISK = registerItem("sentry_disk",
            new ModDiskItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.ENHANCED_END_ITEMS)));

    public static final Item CARNACUS_LEG = registerItem("carnacus_leg",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));
    //Drops from Carnacuses^
    public static final Item ALLAMITE_HIDE = registerItem("allamite_hide",
            new Item(new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS)));

    //Music Discs
    public static final Item MYSTERIOUS_LIGHTS_MUSIC_DISC = registerItem("mysterious_lights_music_disc",
            new MusicDiscItem(16, ModSounds.MYSTERIOUS_LIGHTS,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).rarity(Rarity.RARE).maxCount(1), 178));
    public static final Item SANCTITY_MUSIC_DISC = registerItem("sanctity_music_disc",
            new MusicDiscItem(17, ModSounds.SANCTITY,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_ITEMS).rarity(Rarity.RARE).maxCount(1), 245));
    //Spawn Eggs
    public static final Item ENHANCED_ENDERMAN_SPAWN_EGG = registerItem("enhanced_enderman_spawn_egg",
            new SpawnEggItem(ModEntities.ENHANCED_ENDERMAN,0xd4d6d6, 0x8bfdff,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item ALLAMITE_SPAWN_EGG = registerItem("allamite_spawn_egg",
            new SpawnEggItem(ModEntities.ALLAMITE,0x322353, 0xffebf5,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item SEASPRAY_SPAWN_EGG = registerItem("seaspray_spawn_egg",
            new SpawnEggItem(ModEntities.SEASPRAY,0x364032, 0xd1dacf,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item ENFORCED_OBSIDIAN_GOLEM_SPAWN_EGG = registerItem("enforced_obsidian_golem_spawn_egg",
            new SpawnEggItem(ModEntities.ENFORCED_OBSIDIAN_GOLEM,0x2a0b34, 0x18061e,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item BULWARK_SENTRY_SPAWN_EGG = registerItem("bulwark_sentry_spawn_egg",
            new SpawnEggItem(ModEntities.BULWARK_SENTRY,0x3e412d, 0x899798,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item BULWARK_SHADOW_SPAWN_EGG = registerItem("bulwark_shadow_spawn_egg",
            new SpawnEggItem(ModEntities.BULWARK_SHADOW,0x000000, 0x939573,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    public static final Item BULWARK_SENTINEL_SPAWN_EGG = registerItem("bulwark_sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.BULWARK_SENTINEL,0x474944, 0xf0f7ed,
                    new FabricItemSettings().group(ModItemGroup.ENHANCED_END_DECORATIONS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnhancedEnd.MOD_ID, name), item);
    }
    public static void registerModItems() {
        EnhancedEnd.LOGGER.debug("Registering Mod Items For " + EnhancedEnd.MOD_ID);
    }
}
