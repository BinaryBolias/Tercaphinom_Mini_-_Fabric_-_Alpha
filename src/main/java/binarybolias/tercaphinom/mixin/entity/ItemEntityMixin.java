package binarybolias.tercaphinom.mixin.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;


/**
 * Increases time until despawn to 540% of original value.
 * <p>
 * Up-to-date for Minecraft version 1.20.6.
 */
@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity implements Ownable {
	@Unique private static final float FLUID_BUOYANCY_THRESHOLD = 0.1F;
	/**
	 * Item entity to now despawn after this many ticks by default, or double this value for "coveted" items.
	 */
	@Unique private static final int DESPAWN_AGE = 32400; // 27 minutes, 0 seconds, 0 ticks
	
	@Shadow @Final private static int CANNOT_PICK_UP_DELAY;
	@Shadow @Final private static int NEVER_DESPAWN_AGE;
	
	@Shadow private int itemAge;
	@Shadow private int pickupDelay;
	
	
	// Seemingly superfluous constructor...
	public ItemEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}
	
	
	@Shadow public abstract @Nullable Entity getOwner();
	
	
	@Shadow protected abstract void initDataTracker(DataTracker.Builder builder);
	
	
	/**
	 * @author BinaryBolias
	 * @reason Updating despawn logic to wait until new maximum lifetime before despawning.
	 * Also making other minor code adjustments.
	 */
	@Overwrite
	public void tick() {
		if (getStack().isEmpty()) {
			discard();
		} else {
			super.tick();
			// Decrement pickup delay.
			if (pickupDelay > 0 && pickupDelay != CANNOT_PICK_UP_DELAY) {
				pickupDelay--;
			}
			// Update position tracking.
			prevX = getX();
			prevY = getY();
			prevZ = getZ();
			// Record the velocity at the start of this tick for later.
			Vec3d initialVelocity = getVelocity();
			// Apply fluid buoyancy or gravity.
			if (isTouchingWater() && getFluidHeight(FluidTags.WATER) > FLUID_BUOYANCY_THRESHOLD) {
				applyWaterBuoyancy();
			} else if (isInLava() && getFluidHeight(FluidTags.LAVA) > FLUID_BUOYANCY_THRESHOLD) {
				applyLavaBuoyancy();
			} else {
				applyGravity();
			}
			// Push out of blocks if appropriate.
			if (getWorld().isClient) {
				noClip = false;
			} else {
				noClip = !getWorld().isSpaceEmpty(this, this.getBoundingBox().contract(1.0E-7));
				if (noClip) {
					pushOutOfBlocks(getX(), (getBoundingBox().minY + getBoundingBox().maxY) / 2.0, getZ());
				}
			}
			// Apply movement.
			if (!isOnGround() || getVelocity().horizontalLengthSquared() > 1.0E-5F || (age + getId()) % 4 == 0) {
				move(MovementType.SELF, getVelocity());
				// Get (horizontal) velocity retention; effectively the inverse of friction.
				float retention = isOnGround() ?
						getWorld().getBlockState(getVelocityAffectingPos()).getBlock().getSlipperiness() * 0.98F
						: 0.98F;
				// Apply friction.
				setVelocity(getVelocity().multiply(retention, 0.98, retention));
				// Apply upwards force if moving downwards while on the ground.
				if (isOnGround()) {
					if (getVelocity().y < 0.0) {
						setVelocity(getVelocity().multiply(1.0, -0.5, 1.0));
					}
				}
			}
			// Attempt to merge with nearby item entities.
			if (!getWorld().isClient) { // Only try merging on server-side.
				boolean passedBlockThreshold = MathHelper.floor(prevX) != MathHelper.floor(getX())
						|| MathHelper.floor(prevY) != MathHelper.floor(getY())
						|| MathHelper.floor(prevZ) != MathHelper.floor(getZ());
				// Note: Modified for potentially slightly better performance.
				int mergeModulus = passedBlockThreshold ? 4 : 64; // Original: '2 : 40'
				// Attempt to merge with greater frequency/likelihood if a block threshold was passed.
				if (age % mergeModulus == 0 && canMerge()) {
					tryMerge();
				}
			}
			// Yeah! Dirty up that velocity! (not sure what this means, exactly...)
			velocityDirty = velocityDirty | updateWaterState();
			if (!getWorld().isClient) {
				double acceleration = getVelocity().subtract(initialVelocity).lengthSquared();
				if (acceleration > 0.01) {
					velocityDirty = true;
				}
			}
			// Increment age and despawn if appropriate.
			if (itemAge != NEVER_DESPAWN_AGE) {
				itemAge++;
				// Despawn item if too old.
				if (!getWorld().isClient && itemAge >= DESPAWN_AGE) { // This line is why I rewrote the method.
					discard();
				}
			}
		}
	}
	
	
	@Shadow protected abstract void applyWaterBuoyancy();
	
	
	@Shadow protected abstract void applyLavaBuoyancy();
	
	
	@Shadow protected abstract void tryMerge();
	
	
	/**
	 * @author BinaryBolias
	 * @reason Accounting for new maximum lifetime.
	 */
	@Overwrite
	private boolean canMerge() {
		ItemStack stack = getStack();
		return isAlive()
				&& pickupDelay != CANNOT_PICK_UP_DELAY
				&& itemAge != NEVER_DESPAWN_AGE
				&& itemAge < DESPAWN_AGE // This condition was updated.
				&& stack.getCount() < stack.getMaxCount();
	}
	
	
	@Shadow public abstract void writeCustomDataToNbt(NbtCompound nbt);
	
	
	@Shadow public abstract void readCustomDataFromNbt(NbtCompound nbt);
	
	
	@Shadow public abstract ItemStack getStack();
	
	
	@Shadow public abstract void setPickupDelayInfinite();
	
	
	/**
	 * @author BinaryBolias
	 * @reason Accounting for new maximum lifetime.
	 */
	@Overwrite
	public void setCovetedItem() {
		// Double the time until despawn.
		itemAge = -DESPAWN_AGE;
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Accounting for new maximum lifetime.
	 */
	@Overwrite
	public void setDespawnImmediately() {
		setPickupDelayInfinite();
		itemAge = (DESPAWN_AGE - 1);
	}
}
