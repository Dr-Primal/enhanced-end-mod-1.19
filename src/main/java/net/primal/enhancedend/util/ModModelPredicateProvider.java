package net.primal.enhancedend.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.Item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        registerBow();
        registerCrossbow();
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
    }
    private static void registerCrossbow() {
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (net.primal.enhancedend.Item.custom.ModCrossbowItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)net.primal.enhancedend.Item.custom.ModCrossbowItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null
                && entity.isUsingItem() && entity.getActiveItem() == stack && !net.primal.enhancedend.Item.custom.ModCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> entity != null
                && net.primal.enhancedend.Item.custom.ModCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.ENDIMINTIUM_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> entity != null
                && net.primal.enhancedend.Item.custom.ModCrossbowItem.isCharged(stack)
                && net.primal.enhancedend.Item.custom.ModCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0f : 0.0f);
    }
}
