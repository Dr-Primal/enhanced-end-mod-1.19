package net.primal.enhancedend.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.primal.enhancedend.entity.projectile.BlindballEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;

public class BulwarkSentryEntity extends HostileEntity implements IAnimatable {
    public BulwarkSentryEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private final AnimationFactory factory = new AnimationFactory(this);

    @Override
    protected void initGoals() {
        this.goalSelector.add(3, new BulwarkSentryEntity.ShootBlindballGoal(this));
        this.goalSelector.add(2, new GoToWalkTargetGoal(this, 1.4));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 64.0f));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 36.0);
    }

    @Override
    protected int getNextAirUnderwater(int air) {
        return air;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source == DamageSource.LAVA ||
                source == DamageSource.CACTUS ||
                source == DamageSource.MAGIC ||
                source == DamageSource.HOT_FLOOR ||
                source == DamageSource.FREEZE ||
                source == DamageSource.WITHER ||
                source == DamageSource.ON_FIRE ||
                source == DamageSource.SWEET_BERRY_BUSH ||
                source.isExplosive() ||
                source.isFire() ||
                source.isMagic()) {
            return true;
        }
        boolean bl = super.damage(source, amount);
        if (bl) {
            this.playSound(SoundEvents.ENTITY_GUARDIAN_HURT, 1.0f, 0.1f);
        }
        return super.damage(source, amount);
    }

    @Override
    public void tickMovement() {
        if (!this.onGround && this.getVelocity().y < 0.0) {
            this.setVelocity(this.getVelocity().multiply(1.0, 0.6, 1.0));
        }
        super.tickMovement();
    }

    @Override
    protected void mobTick() {
        LivingEntity livingEntity;
        --this.eyeOffsetCooldown;
        if (this.eyeOffsetCooldown <= 0) {
            this.eyeOffsetCooldown = 100;
            this.eyeOffset = (float)this.random.nextTriangular(0.5, 6.891);
        }
        if ((livingEntity = this.getTarget()) != null && livingEntity.getEyeY() > this.getEyeY() + (double)this.eyeOffset && this.canTarget(livingEntity)) {
            Vec3d vec3d = this.getVelocity();
            this.setVelocity(this.getVelocity().add(0.0, ((double)0.3f - vec3d.y) * (double)0.3f, 0.0));
            this.velocityDirty = true;
        }
        super.mobTick();
    }

    private float eyeOffset = 0.7f;
    private int eyeOffsetCooldown;

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GUARDIAN_DEATH;
    }

    @Override
    public float getSoundPitch() {
        return 0.1f;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.isMoving();

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bulwark_sentry.hover", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    static class ShootBlindballGoal
            extends Goal {
        private final BulwarkSentryEntity bulwark_sentry;
        private int bulletsFired;
        private int bulletCooldown;
        private int targetNotVisibleTicks;

        public ShootBlindballGoal(BulwarkSentryEntity bulwark_sentry) {
            this.bulwark_sentry = bulwark_sentry;
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = this.bulwark_sentry.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.bulwark_sentry.canTarget(livingEntity);
        }

        @Override
        public void start() {
            this.bulletsFired = 0;
        }

        @Override
        public void stop() {
            this.targetNotVisibleTicks = 0;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            --this.bulletCooldown;
            LivingEntity livingEntity = this.bulwark_sentry.getTarget();
            if (livingEntity == null) {
                return;
            }
            boolean bl = this.bulwark_sentry.getVisibilityCache().canSee(livingEntity);
            this.targetNotVisibleTicks = bl ? 0 : ++this.targetNotVisibleTicks;
            double d = this.bulwark_sentry.squaredDistanceTo(livingEntity);
            if (d < 4.0) {
                if (!bl) {
                    return;
                }
                if (this.bulletCooldown <= 0) {
                    this.bulletCooldown = 5;
                    this.bulwark_sentry.tryAttack(livingEntity);
                }
                this.bulwark_sentry.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 3.0);
            }
            else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                double e = livingEntity.getX() - this.bulwark_sentry.getX();
                double f = livingEntity.getBodyY(0.5) - this.bulwark_sentry.getBodyY(0.5);
                double g = livingEntity.getZ() - this.bulwark_sentry.getZ();
                if (this.bulletCooldown <= 0) {
                    ++this.bulletsFired;
                    if (this.bulletsFired == 1) {
                        this.bulletCooldown = 5;
                    } else if (this.bulletsFired <= 6) {
                        this.bulletCooldown = 20;
                    } else {
                        this.bulletCooldown = 40;
                        this.bulletsFired = 0;
                    }
                    if (this.bulletsFired > 1) {
                        double h = Math.sqrt(Math.sqrt(d)) * 0.5;
                        if (!this.bulwark_sentry.isSilent()) {
                            this.bulwark_sentry.world.syncWorldEvent(null, WorldEvents.EYE_OF_ENDER_BREAKS, this.bulwark_sentry.getBlockPos(), 0);
                        }
                        for (int i = 0; i < 1; ++i) {
                            BlindballEntity blindballEntity =
                                    new BlindballEntity(
                                            this.bulwark_sentry.world,
                                            this.bulwark_sentry,
                                            this.bulwark_sentry.getRandom()
                                            .nextTriangular(e, 2.297 * h), f, this.bulwark_sentry.getRandom()
                                            .nextTriangular(g, 2.297 * h));
                            blindballEntity.setPosition(blindballEntity.getX(),
                                    this.bulwark_sentry.getBodyY(0.5) + 0.5, blindballEntity.getZ());
                            this.bulwark_sentry.world.spawnEntity(blindballEntity);
                        }
                    }
                }
                this.bulwark_sentry.getLookControl().lookAt(livingEntity, 10.0f, 10.0f);
            } else if (this.targetNotVisibleTicks < 5) {
                this.bulwark_sentry.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 3.0);
            }
            super.tick();
        }

        private double getFollowRange() {
            return this.bulwark_sentry.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        }
    }
}
