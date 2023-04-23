package net.primal.enhancedend.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.item.ModItems;
import net.primal.enhancedend.item.custom.ModCrossbowItem;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        registerBow();
    }

    private static void registerBow() {
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_BOW, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_BOW, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (ModCrossbowItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)ModCrossbowItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !ModCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> entity != null && ModCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> entity != null && ModCrossbowItem.isCharged(stack) && ModCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);



        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_BOW, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_BOW, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (ModCrossbowItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)ModCrossbowItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !ModCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> entity != null && ModCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ModelPredicateProviderRegistry.register(ModItems.CLITANIUM_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> entity != null && ModCrossbowItem.isCharged(stack) && ModCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
    }

}
