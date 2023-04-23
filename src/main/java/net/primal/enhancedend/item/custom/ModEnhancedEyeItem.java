package net.primal.enhancedend.item.custom;

import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ModEnhancedEyeItem extends Item {
    public ModEnhancedEyeItem(Settings settings) {
        super(settings);
    }
    private static final Text CONTAINER_NAME = Text.translatable("container.enderchest");

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EnderChestInventory enderChestInventory = user.getEnderChestInventory();
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ENDER_CHEST_OPEN, SoundCategory.NEUTRAL, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ENDER_CHEST_CLOSE, SoundCategory.NEUTRAL, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        if (!world.isClient) {
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> GenericContainerScreenHandler.createGeneric9x3(syncId, inventory, enderChestInventory), CONTAINER_NAME));
            user.incrementStat(Stats.OPEN_ENDERCHEST);
            PiglinBrain.onGuardedBlockInteracted(user, true);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
