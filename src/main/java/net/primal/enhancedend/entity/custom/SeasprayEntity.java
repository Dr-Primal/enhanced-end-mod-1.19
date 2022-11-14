package net.primal.enhancedend.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;

public class SeasprayEntity extends FlyingEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);
    public static final int field_28641 = MathHelper.ceil(24.166098f);
    private static final TrackedData<Integer> SIZE = DataTracker.registerData(SeasprayEntity.class, TrackedDataHandlerRegistry.INTEGER);
    Vec3d targetPosition = Vec3d.ZERO;
    BlockPos circlingCenter = BlockPos.ORIGIN;
    SeasprayMovementType movementType = SeasprayMovementType.CIRCLE;

    public SeasprayEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.moveControl = new SeasprayEntity.SeasprayMoveControl(this);
        this.lookControl = new SeasprayLookControl(this);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.seaspray.fly", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.seaspray.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public boolean hasWings() {
        return (this.method_33588() + this.age) % field_28641 == 0;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SeasprayEntity.SeasprayBodyControl(this);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SeasprayEntity.CircleMovementGoal());
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SIZE, 0);
    }

    public void setSeaspraySize(int size) {
        this.dataTracker.set(SIZE, MathHelper.clamp(size, 0, 64));
    }

    private void onSizeChanged() {
        this.calculateDimensions();
    }

    public int getSeaspraySize() {
        return this.dataTracker.get(SIZE);
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.3f;
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (SIZE.equals(data)) {
            this.onSizeChanged();
        }
        super.onTrackedDataSet(data);
    }

    public int method_33588() {
        return this.getId() * 3;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient) {
            float f = MathHelper.cos((float)(this.method_33588() + this.age) * 7.448451f * ((float)Math.PI / 180) + (float)Math.PI);
            float g = MathHelper.cos((float)(this.method_33588() + this.age + 1) * 7.448451f * ((float)Math.PI / 180) + (float)Math.PI);
            if (f > 0.0f && g <= 0.0f) {
                this.world.playSound(this.getX(), this.getY(), this.getZ(),
                        SoundEvents.ENTITY_PHANTOM_FLAP,
                        this.getSoundCategory(), 0.7f
                                + this.random.nextFloat()
                                * 0.05f, 3f
                                + this.random.nextFloat()
                                * 0.05f, false);
            }
        }
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.circlingCenter = this.getBlockPos().up(5);
        this.setSeaspraySize(0);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("AX")) {
            this.circlingCenter = new BlockPos(nbt.getInt("AX"), nbt.getInt("AY"), nbt.getInt("AZ"));
        }
        this.setSeaspraySize(nbt.getInt("Size"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("AX", this.circlingCenter.getX());
        nbt.putInt("AY", this.circlingCenter.getY());
        nbt.putInt("AZ", this.circlingCenter.getZ());
        nbt.putInt("Size", this.getSeaspraySize());
    }

    @Override
    public boolean shouldRender(double distance) {
        return true;
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.NEUTRAL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_STRIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_STRIDER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0f;
    }

    @Override
    public float getSoundPitch() {
        return 3f;
    }

    @Override
    public boolean canTarget(EntityType<?> type) {
        return true;
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        int i = this.getSeaspraySize();
        EntityDimensions entityDimensions = super.getDimensions(pose);
        float f = (entityDimensions.width + 0.2f * (float)i) / entityDimensions.width;
        return entityDimensions.scaled(f);
    }

    static enum SeasprayMovementType {
        CIRCLE

    }

    class SeasprayMoveControl
            extends MoveControl {
        private float targetSpeed;

        public SeasprayMoveControl(MobEntity owner) {
            super(owner);
            this.targetSpeed = 0.1f;
        }

        @Override
        public void tick() {
            if (SeasprayEntity.this.horizontalCollision) {
                SeasprayEntity.this.setYaw(SeasprayEntity.this.getYaw() + 180.0f);
                this.targetSpeed = 0.1f;
            }
            double d = SeasprayEntity.this.targetPosition.x - SeasprayEntity.this.getX();
            double e = SeasprayEntity.this.targetPosition.y - SeasprayEntity.this.getY();
            double f = SeasprayEntity.this.targetPosition.z - SeasprayEntity.this.getZ();
            double g = Math.sqrt(d * d + f * f);
            if (Math.abs(g) > (double)1.0E-5f) {
                double h = 1.0 - Math.abs(e * (double)0.7f) / g;
                g = Math.sqrt((d *= h) * d + (f *= h) * f);
                double i = Math.sqrt(d * d + f * f + e * e);
                float j = SeasprayEntity.this.getYaw();
                float k = (float)MathHelper.atan2(f, d);
                float l = MathHelper.wrapDegrees(SeasprayEntity.this.getYaw() + 90.0f);
                float m = MathHelper.wrapDegrees(k * 57.295776f);
                SeasprayEntity.this.setYaw(MathHelper.stepUnwrappedAngleTowards(l, m, 4.0f) - 90.0f);
                SeasprayEntity.this.bodyYaw = SeasprayEntity.this.getYaw();
                this.targetSpeed = MathHelper.angleBetween(j, SeasprayEntity.this.getYaw()) < 3.0f ? MathHelper.stepTowards(this.targetSpeed, 1.8f, 0.005f * (1.8f / this.targetSpeed)) : MathHelper.stepTowards(this.targetSpeed, 0.2f, 0.025f);
                float n = (float)(-(MathHelper.atan2(-e, g) * 57.2957763671875));
                SeasprayEntity.this.setPitch(n);
                float o = SeasprayEntity.this.getYaw() + 90.0f;
                double p = (double)(this.targetSpeed * MathHelper.cos(o * ((float)Math.PI / 180))) * Math.abs(d / i);
                double q = (double)(this.targetSpeed * MathHelper.sin(o * ((float)Math.PI / 180))) * Math.abs(f / i);
                double r = (double)(this.targetSpeed * MathHelper.sin(n * ((float)Math.PI / 180))) * Math.abs(e / i);
                Vec3d vec3d = SeasprayEntity.this.getVelocity();
                SeasprayEntity.this.setVelocity(vec3d.add(new Vec3d(p, r, q).subtract(vec3d).multiply(0.2)));
            }
        }
    }

    static class SeasprayLookControl
            extends LookControl {
        public SeasprayLookControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
        }
    }

    class SeasprayBodyControl
            extends BodyControl {
        public SeasprayBodyControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
            SeasprayEntity.this.headYaw = SeasprayEntity.this.bodyYaw;
            SeasprayEntity.this.bodyYaw = SeasprayEntity.this.getYaw();
        }
    }

    class CircleMovementGoal
            extends SeasprayEntity.MovementGoal {
        private float angle;
        private float radius;
        private float yOffset;
        private float circlingDirection;

        CircleMovementGoal() {
        }

        @Override
        public boolean canStart() {
            return SeasprayEntity.this.movementType == SeasprayEntity.SeasprayMovementType.CIRCLE;
        }

        @Override
        public void start() {
            this.radius = 5.0f + SeasprayEntity.this.random.nextFloat() * 10.0f;
            this.yOffset = -4.0f + SeasprayEntity.this.random.nextFloat() * 9.0f;
            this.circlingDirection = SeasprayEntity.this.random.nextBoolean() ? 1.0f : -1.0f;
            this.adjustDirection();
        }

        @Override
        public void tick() {
            if (SeasprayEntity.this.random.nextInt(this.getTickCount(350)) == 0) {
                this.yOffset = -4.0f + SeasprayEntity.this.random.nextFloat() * 9.0f;
            }
            if (SeasprayEntity.this.random.nextInt(this.getTickCount(250)) == 0) {
                this.radius += 1.0f;
                if (this.radius > 15.0f) {
                    this.radius = 5.0f;
                    this.circlingDirection = -this.circlingDirection;
                }
            }
            if (SeasprayEntity.this.random.nextInt(this.getTickCount(450)) == 0) {
                this.angle = SeasprayEntity.this.random.nextFloat() * 2.0f * (float)Math.PI;
                this.adjustDirection();
            }
            if (SeasprayEntity.this.targetPosition.y < SeasprayEntity.this.getY() && !SeasprayEntity.this.world.isAir(SeasprayEntity.this.getBlockPos().down(1))) {
                this.yOffset = Math.max(1.0f, this.yOffset);
                this.adjustDirection();
            }
            if (SeasprayEntity.this.targetPosition.y > SeasprayEntity.this.getY() && !SeasprayEntity.this.world.isAir(SeasprayEntity.this.getBlockPos().up(1))) {
                this.yOffset = Math.min(-1.0f, this.yOffset);
                this.adjustDirection();
            }
        }

        private void adjustDirection() {
            if (BlockPos.ORIGIN.equals(SeasprayEntity.this.circlingCenter)) {
                SeasprayEntity.this.circlingCenter = SeasprayEntity.this.getBlockPos();
            }
            this.angle += this.circlingDirection * 15.0f * ((float)Math.PI / 180);
            SeasprayEntity.this.targetPosition = Vec3d.of(SeasprayEntity.this.circlingCenter).add(this.radius * MathHelper.cos(this.angle), -4.0f + this.yOffset, this.radius * MathHelper.sin(this.angle));
        }
    }
    abstract class MovementGoal
            extends Goal {
        public MovementGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }
    }

}
