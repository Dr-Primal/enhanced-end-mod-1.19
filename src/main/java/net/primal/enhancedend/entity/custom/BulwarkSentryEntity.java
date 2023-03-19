package net.primal.enhancedend.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
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
import net.primal.enhancedend.entity.projectile.thrown.BlindDiskEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BulwarkSentryEntity extends HostileEntity implements IAnimatable, RangedAttackMob {
    public BulwarkSentryEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private final AnimationFactory factory = new AnimationFactory(this);

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 0.8, 60, 24.0f));
        this.goalSelector.add(2, new GoToWalkTargetGoal(this, 0.8));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 24.0f));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0);
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
        if (
                source == DamageSource.LAVA ||
                source == DamageSource.CACTUS ||
                source == DamageSource.MAGIC ||
                source == DamageSource.HOT_FLOOR ||
                source == DamageSource.FREEZE ||
                source == DamageSource.WITHER ||
                source == DamageSource.ON_FIRE ||
                source == DamageSource.IN_FIRE ||
                source == DamageSource.SWEET_BERRY_BUSH ||
                source.isExplosive() ||
                source.isFire() ||
                source.isMagic()) {
            return true;
        }
        boolean bl = super.damage(source, amount);
        if (bl) {
            this.playSound(SoundEvents.ENTITY_BEE_HURT, 1.0f, 0.1f);
        }
        return super.damage(source, amount);
    }

    @Override
    public boolean disablesShield() {
        return true;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
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

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        BlindDiskEntity blindDiskEntity = new BlindDiskEntity(this.world, this);
        double d = target.getEyeY() - (double)1.1f;
        double e = target.getX() - this.getX();
        double f = d - blindDiskEntity.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * (double)0.2f;
        blindDiskEntity.setVelocity(e, f + h, g, 1.35f, 0.0f);
        this.playSound(SoundEvents.ENTITY_BEE_STING, 1.0f, 0.01f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.world.spawnEntity(blindDiskEntity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BEE_LOOP_AGGRESSIVE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BEE_DEATH;
    }

    @Override
    public float getSoundPitch() {
        return 0.01f;
    }
}