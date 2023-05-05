package net.primal.enhancedend.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.item.EEItems;

public class EELootTableModifier {
    //Nether Fortress
    private static final Identifier FORTRESS_CHEST_ID
            = new Identifier("minecraft", "chests/nether_bridge");
    //Treasure Bastion
    private static final Identifier BASTION_TREASURE_CHEST_ID
            = new Identifier("minecraft", "chests/bastion_treasure");
    //Evoker
    private static final Identifier EVOKER_ID
            = new Identifier("minecraft", "entities/evoker");
    //Shipwreck Treasure
    private static final Identifier SHIPWRECK_TREASURE_ID
            = new Identifier("minecraft", "chests/shipwreck_treasure");
    //Buried Treasure
    private static final Identifier TREASURE_ID
            = new Identifier("minecraft", "chests/buried_treasure");
    //End City
    private static final Identifier END_CITY_ID
            = new Identifier("minecraft", "chests/end_city_treasure");
    //Ancient City
    private static final Identifier ANCIENT_CITY_ID
            = new Identifier("minecraft", "chests/ancient_city");
    //Mineshaft
    private static final Identifier MINESHAFT_ID
            = new Identifier("minecraft", "chests/abandoned_mineshaft");
    //Dungeon
    private static final Identifier DUNGEON_ID
            = new Identifier("minecraft", "chests/simple_dungeon");
    //Igloo
    private static final Identifier IGLOO_ID
            = new Identifier("minecraft", "chests/igloo_chest");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            //Fortress containing Blazing Orbs
            if(FORTRESS_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(EEItems.BLAZING_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Treasure Bastions containing Hellfire Orbs
            if(BASTION_TREASURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(EEItems.HELLFIRE_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Evokers dropping Evoker Orbs
            if(EVOKER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(EEItems.EVOKER_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Shipwrecks containing Immersed Orbs
            if(SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(EEItems.IMMERSED_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Buried Treasure containing Immersed Orbs
            if(TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(EEItems.IMMERSED_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //End Cities containing Enderfied Orbs
            if(END_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(EEItems.ENDERFIED_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Ancient Cities containing Corrupted Orbs
            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(EEItems.CORRUPTED_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Mineshaft containing Spirit Orb
            if(MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(EEItems.SPIRIT_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Dungeons containing Spirit Orb
            if(DUNGEON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(EEItems.SPIRIT_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            //Igloos containing Celerity Orb
            if(IGLOO_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(EEItems.CELERITY_ORB))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
