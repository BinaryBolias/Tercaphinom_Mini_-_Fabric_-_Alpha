package binarybolias.tercaphinom.block;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


/**
 * @see net.minecraft.block.HoneyBlock
 * @see net.minecraft.block.SlimeBlock
 */
public class CherryJellyblockBlock extends TranslucentBlock {
	public static final MapCodec<CherryJellyblockBlock> CODEC = createCodec(CherryJellyblockBlock::new);
	
	// For bouncing.
	private static final double HIGH_BOUNCE_SPEED_THRESHOLD = 0.675; // Downward speeds at or above this value produce maximum bounce.
	private static final double LOW_BOUNCE_SPEED_THRESHOLD = 0.25; // Downward speeds at or below this value produce no bounce.
	private static final double BOUNCE_SPEED_THRESHOLD_DIFFERENCE = HIGH_BOUNCE_SPEED_THRESHOLD - LOW_BOUNCE_SPEED_THRESHOLD;
	// For (wall) sliding.
	private static final double VERTICAL_SLIDE_VELOCITY = -0.1; // -0.05 for Honey Block
	private static final double MAX_VERTICAL_VELOCITY_FOR_SLIDE_DETECTION = VERTICAL_SLIDE_VELOCITY - 0.03125; // -0.08 for Honey Block
	// For walking.
	// Intended to allow for quicker movement speed while sprinting, with heavy speed reduction when not sprinting.
	private static final double HIGH_WALK_SPEED_THRESHOLD = 0.125; // Walk speeds at or above this value allow maximum velocity multiplier.
	private static final double LOW_WALK_SPEED_THRESHOLD = 0.03125; // Walk speeds at or below this value produce minimum velocity multiplier.
	private static final double WALK_SPEED_THRESHOLD_DIFFERENCE = HIGH_WALK_SPEED_THRESHOLD - LOW_WALK_SPEED_THRESHOLD;
	private static final double MIN_WALK_MULTIPLIER = 0.375;
	protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);
	
	
	@Override
	protected MapCodec<? extends TranslucentBlock> getCodec() {
		return CODEC;
	}
	
	
	public CherryJellyblockBlock(Settings settings) {
		super(settings);
	}
	
	
	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}
	
	
	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		// Cancel fall damage unless entity bypasses landing effects.
		if (entity.bypassesLandingEffects()) {
			super.onLandedUpon(world, state, pos, entity, fallDistance);
		} else {
			entity.handleFallDamage(fallDistance, 0.0F, world.getDamageSources().fall());
		}
	}
	
	
	@Override
	public void onEntityLand(BlockView world, Entity entity) {
		// Bounce entity unless entity bypasses landing effects.
		if (entity.bypassesLandingEffects()) {
			super.onEntityLand(world, entity);
		} else {
			// Note: This can be triggered multiple times per entity when the entity lands on a floor of this block type.
			//  Doesn't cause problems in practice, due to:
			//  - Bouncing only modifying velocity if the entity is moving downward.
			//  - Bouncing causes the entity to be moving upward or remaining vertically stationary.
			bounce(entity);
		}
	}
	
	
	private void bounce(Entity entity) {
		// If moving downward, bounce the entity if moving downward faster than the low bounce speed threshold.
		Vec3d velocity = entity.getVelocity();
		if (velocity.y < 0.0) {
			double bounceStrength;
			// Set bounce strength to a linear interpolation between low and high thresholds, without extrapolation.
			double downwardSpeed = -velocity.y;
			if (downwardSpeed <= LOW_BOUNCE_SPEED_THRESHOLD) {
				bounceStrength = 0.0;
			} else if (downwardSpeed >= HIGH_BOUNCE_SPEED_THRESHOLD) {
				bounceStrength = 1.0;
			} else { // downwardSpeed > LOW_BOUNCE_SPEED_THRESHOLD && downwardSpeed < HIGH_BOUNCE_SPEED_THRESHOLD
				bounceStrength = (downwardSpeed - LOW_BOUNCE_SPEED_THRESHOLD) / BOUNCE_SPEED_THRESHOLD_DIFFERENCE;
			}
			
			entity.setVelocity(velocity.x, downwardSpeed * bounceStrength, velocity.z);
			
//			if (downwardSpeed > 0.1F) {
//				String logString = "Cherry Jellyblock bounce:\n - Downward speed: %f\n - Bounce strength: %f";
//				Reference.log(String.format(logString, downwardSpeed, bounceStrength));
//			}
		}
	}
	
	
	@Override
	protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (shouldBeSlidingFromThisBlock(pos, entity)) {
			updateSlidingVelocity(entity);
			addSlidingEffects(world, entity);
		}
		
		super.onEntityCollision(state, world, pos, entity);
	}
	
	
	private boolean shouldBeSlidingFromThisBlock(BlockPos pos, Entity entity) {
		if (entity.isOnGround()) {
			// Don't slide if standing on ground.
			return false;
		} else if (entity.getY() > (double) pos.getY() + 0.9375 - 1.0E-7) { // TODO: Determine what these 'E' values are...
			// Entity is outside of vertical range for this block?
			// - Prevents multiple blocks from affecting the same entity?
			return false;
		} else if (entity.getVelocity().y > MAX_VERTICAL_VELOCITY_FOR_SLIDE_DETECTION) {
			// Don't slide if downwards velocity is not great enough.
			// Because the checked value is less than the ordained sliding velocity,
			//  this incidentally also prevents multiple blocks from acting upon the same entity.
			return false;
		} else {
			// Return whether entity is within horizontal range of this block?
			// - Prevents multiple blocks from affecting the same entity, but horizontally this time?
			double d = Math.abs((double)pos.getX() + 0.5 - entity.getX()); // TODO: Name this variable something more descriptive than 'd'.
			double e = Math.abs((double)pos.getZ() + 0.5 - entity.getZ()); // TODO: Name this variable something more descriptive than 'e'.
			double f = 0.4375 + (double)(entity.getWidth() / 2.0F); // TODO: Name this variable something more descriptive than 'f'.
			return d + 1.0E-7 > f || e + 1.0E-7 > f; // TODO: Determine what these 'E' values are...
		}
	}
	
	
	private void updateSlidingVelocity(Entity entity) {
		Vec3d vec3d = entity.getVelocity();
//		Note: The vanilla Honey Block is weirdly complex for updating sliding velocity for some unknown reason.
		entity.setVelocity(new Vec3d(vec3d.x, VERTICAL_SLIDE_VELOCITY, vec3d.z));
		//TODO: Perhaps also clamp horizontal velocity?
		// - Horizontal movement could be decayed, rather than clamped, since the vertical clamping ensures that sliding velocity is not updated more than once per tick.
		
		entity.onLanding();
	}
	
	
	private void addSlidingEffects(World world, Entity entity) {
		if (isValidForSlidingEffects(entity)) {
			// 1 in 6 chance to trigger sound effect.
			if (world.random.nextInt(5) == 0) {
				entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 0.9375F);
			}
			// 1 in 6 chance to trigger particle effect.
			//TODO: Make this be the same color as the cherry jelly.
			// - Perhaps new entity status?
			//  - Entity status system seems difficult to interface with...
			// - Perhaps use a different mechanism for producing particles...
//			if (!world.isClient() && world.random.nextInt(5) == 0) { // Must be server side.
//				world.sendEntityStatus(entity, EntityStatuses.DRIP_HONEY);
//			}
		}
	}
	
	
	private static boolean isValidForSlidingEffects(Entity entity) {
		return entity instanceof LivingEntity || entity instanceof AbstractMinecartEntity || entity instanceof TntEntity || entity instanceof BoatEntity;
	}
	
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		double verticalSpeed = Math.abs(entity.getVelocity().y);
		if (verticalSpeed < 0.1 && !entity.bypassesSteppingEffects()) {
			double hVelocityMultiplier;
			// Set walk velocity multiplier to a linear interpolation between low and high thresholds, without extrapolation.
			double hSpeed = entity.getVelocity().horizontalLength();
			if (hSpeed <= LOW_WALK_SPEED_THRESHOLD) {
				hVelocityMultiplier = 0.0;
			} else if (hSpeed >= HIGH_WALK_SPEED_THRESHOLD) {
				hVelocityMultiplier = 1.0;
			} else { // hSpeed > LOW_WALK_SPEED_THRESHOLD && hSpeed < HIGH_WALK_SPEED_THRESHOLD
				hVelocityMultiplier = (hSpeed - LOW_WALK_SPEED_THRESHOLD) / WALK_SPEED_THRESHOLD_DIFFERENCE;
			}
			
			hVelocityMultiplier = (hVelocityMultiplier * (1.0 - MIN_WALK_MULTIPLIER)) + MIN_WALK_MULTIPLIER;
//			hVelocityMultiplier += MIN_WALK_MULTIPLIER + verticalSpeed * 0.25;
			entity.setVelocity(entity.getVelocity().multiply(hVelocityMultiplier, 1.0, hVelocityMultiplier));
		}
		
		super.onSteppedOn(world, pos, state, entity);
	}
}
