package net.primal.enhancedend.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BulwarkShadowEntity extends HostileEntity implements IAnimatable {
    public BulwarkShadowEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1, false));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
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
            this.playSound(SoundEvents.ENTITY_WITHER_SKELETON_HURT, 1.0f, 0.1f);
        }
        return super.damage(source, amount);
    }

    @Override
    public void tickMovement() {
        if (this.world.isClient) {
            for (int i = 0; i < 2; ++i) {
                this.world.addParticle(ParticleTypes.ASH,
                        this.getParticleX(0.5), this.getRandomBodyY() - 0.25,
                        this.getParticleZ(0.5), (this.random.nextDouble() - 0.5) * 2.0,
                        -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
            }
        }
        this.jumping = false;
        super.tickMovement();
    }

    private final AnimationFactory factory = new AnimationFactory(this);

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.isMoving();

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bulwark_shadow.movement", true));
        return PlayState.CONTINUE;
    }
    private PlayState attackPredicate(AnimationEvent event) {
        if(this.handSwinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bulwark_shadow.attack", false));
            this.handSwinging = false;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        animationData.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }

    @Override
    public float getSoundPitch() {
        return 0.01f;
    }
}