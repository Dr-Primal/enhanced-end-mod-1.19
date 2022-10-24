package net.primal.enhancedend.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.primal.enhancedend.Item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CrossbowItem.class)
public class ModCrossbowItemMixin {

    @Inject(method = "createArrow", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private static void createArrowMixin(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow, CallbackInfoReturnable<PersistentProjectileEntity> info, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity) {
        if (crossbow.getItem() == ModItems.ENDIMINTIUM_CROSSBOW) {
            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() * 1.25f + 1f);
            info.setReturnValue(persistentProjectileEntity);
        }
    }

    @Inject(method = "getSpeed", at = @At("HEAD"), cancellable = true)
    private static void getSpeedMixin(ItemStack stack, CallbackInfoReturnable<Float> info) {
        if (stack.getItem() == ModItems.ENDIMINTIUM_CROSSBOW) {
            if (hasProjectile(stack, Items.FIREWORK_ROCKET)) {
                info.setReturnValue(2.0F);
            } else {
                info.setReturnValue(4.0F);
            }
        }
    }

    @Shadow
    public static boolean hasProjectile(ItemStack crossbow, Item projectile) {
        return false;
    }
}
