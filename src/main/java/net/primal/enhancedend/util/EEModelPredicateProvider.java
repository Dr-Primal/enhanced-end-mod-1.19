package net.primal.enhancedend.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.primal.enhancedend.item.EEItems;
import net.primal.enhancedend.item.custom.EndimintiumCrossbowItem;

public class EEModelPredicateProvider {
    public static void registerEEModels() {
        registerBow();
    }

    private static void registerBow() {
        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_BOW, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_BOW, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (EndimintiumCrossbowItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float) EndimintiumCrossbowItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !EndimintiumCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> entity != null && EndimintiumCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ModelPredicateProviderRegistry.register(EEItems.ENDIMINTIUM_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> entity != null && EndimintiumCrossbowItem.isCharged(stack) && EndimintiumCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);



        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_BOW, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_BOW, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);

        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (EndimintiumCrossbowItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float) EndimintiumCrossbowItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !EndimintiumCrossbowItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> entity != null && EndimintiumCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ModelPredicateProviderRegistry.register(EEItems.CLITANIUM_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> entity != null && EndimintiumCrossbowItem.isCharged(stack) && EndimintiumCrossbowItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
    }

}
