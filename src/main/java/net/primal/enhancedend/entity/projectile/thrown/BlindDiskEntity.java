package net.primal.enhancedend.entity.projectile.thrown;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.primal.enhancedend.Item.ModItems;
import net.primal.enhancedend.entity.ModEntities;

public class BlindDiskEntity extends ThrownItemEntity {
    public BlindDiskEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BlindDiskEntity(World world, LivingEntity owner) {
        super(ModEntities.BlindDiskEntityEntityType, owner, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        boolean bl;
        super.onEntityHit(entityHitResult);
        if (this.world.isClient) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();
        if (entity2 instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity2;
            bl = entity.damage(DamageSource.magic(this, livingEntity), 10.0f);
            if (bl) {
                if (entity.isAlive()) {
                    this.applyDamageEffects(livingEntity, entity);
                } else {
                    livingEntity.heal(5.0f);
                }
            }
        } else {
            bl = entity.damage(DamageSource.MAGIC, 10.0f);
        }
        if (bl && entity instanceof LivingEntity) {
            int i = 0;
            if (this.world.getDifficulty() == Difficulty.NORMAL) {
                i = 60;
            } else if (this.world.getDifficulty() == Difficulty.HARD) {
                i = 80;
            }
            if (i > 0) {
                entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float) i / 16);
                ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, i * 2), this.getEffectCause());
            }
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)3);
            this.kill();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SENTRY_DISK;
    }
}
