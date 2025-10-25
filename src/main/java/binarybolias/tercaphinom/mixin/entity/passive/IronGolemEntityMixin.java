package binarybolias.tercaphinom.mixin.entity.passive;


import binarybolias.tercaphinom.registry.tag.EntityTags;
import binarybolias.tercaphinom.registry.tag.ItemTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


/**
 * Modifies attack target recognition to utilize an entity tag, and to not exclude Creepers.<br>
 * Modifies repair functionality to use an item tag for valid repair materials, rather than specifically requiring an Iron Ingot.
 * <p>
 * Up-to-date for Minecraft version 1.20.6.
 */
@Mixin(IronGolemEntity.class)
public abstract class IronGolemEntityMixin extends GolemEntity implements Angerable {
	// Seemingly superfluous constructor...
	protected IronGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	
//	@Inject(method = "initGoals",
//			at = @At(value = "INVOKE",
//					ordinal = 10,
//					target = "Lnet/minecraft/entity/ai/goal/GoalSelector;add(ILnet/minecraft/entity/ai/goal/Goal;)V"),
//			require = 12,
//			cancellable = true)
//	private void onInitGoals(CallbackInfo ci) {
//		// The expected method body:
////		goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
////		goalSelector.add(2, new WanderNearTargetGoal(this, 0.9, 32.0F));
////		goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.6, false));
////		goalSelector.add(4, new IronGolemWanderAroundGoal(this, 0.6));
////		goalSelector.add(5, new IronGolemLookGoal(this));
////		goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
////		goalSelector.add(8, new LookAroundGoal(this));
////
////		targetSelector.add(1, new TrackIronGolemTargetGoal(this));
////		targetSelector.add(2, new RevengeGoal(this));
////		targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
////		>> INJECTION POINT HERE <<
////		targetSelector
////				.add(3, new ActiveTargetGoal<>(this, MobEntity.class, 5, false, false, entity -> entity instanceof Monster && !(entity instanceof CreeperEntity)));
////		targetSelector.add(4, new UniversalAngerGoal<>(this, false));
//
//		// Thus, with injection ordinal '10', this intends to replace the last two method calls.
//
//		// Make automatic hostility use an entity tag, and not exclude Creepers.
//		targetSelector.add(3, new ActiveTargetGoal<>(
//				this, LivingEntity.class, 5, false, false,
//				entity -> entity.getType().isIn(EntityTags.VILBIARN_GOLEM_ENEMIES)));
//		// Replicate original method call.
//		targetSelector.add(4, new UniversalAngerGoal<>(this, false));
//		// Bypass the original last two method calls.
//		ci.cancel();
//	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason The injection for this didn't work; it somehow only found 1 invocation target when there are CLEARLY 12.
	 * Making automatic hostility use an entity tag, and not exclude Creepers.
	 */
	@Overwrite
	public void initGoals() {
		goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
		goalSelector.add(2, new WanderNearTargetGoal(this, 0.9, 32.0F));
		goalSelector.add(2, new WanderAroundPointOfInterestGoal(this, 0.6, false));
		goalSelector.add(4, new IronGolemWanderAroundGoal(this, 0.6));
		// NOTE: Doing a wacky double cast to prevent the compiler from yapping about incompatible types.
		goalSelector.add(5, new IronGolemLookGoal((IronGolemEntity) (Object) this));
		goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
		goalSelector.add(8, new LookAroundGoal(this));
		
		// NOTE: Doing a wacky double cast to prevent the compiler from yapping about incompatible types.
		targetSelector.add(1, new TrackIronGolemTargetGoal((IronGolemEntity) (Object) this));
		targetSelector.add(2, new RevengeGoal(this));
		targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
		
		// Make automatic hostility use an entity tag, and not exclude Creepers.
		targetSelector.add(3, new ActiveTargetGoal<>(
				this, LivingEntity.class, 5, false, false,
				entity -> entity.getType().isIn(EntityTags.VILBIARN_GOLEM_ENEMIES)));
		
		targetSelector.add(4, new UniversalAngerGoal<>(this, false));
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Using entity tag for triggering automatic hostility.
	 */
	@Overwrite
	public void pushAway(Entity entity) {
		if (entity.getType().isIn(EntityTags.VILBIARN_GOLEM_ENEMIES) && getRandom().nextInt(20) == 0) {
			setTarget((LivingEntity) entity);
		}
		
		super.pushAway(entity);
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Removing target exception for Creepers.
	 */
	@Overwrite
	public boolean canTarget(EntityType<?> type) {
		return !isPlayerCreated() || type != EntityType.PLAYER;
	}
	
	
	@Shadow public abstract boolean isPlayerCreated();
	
	
	/**
	 * @author BinaryBolias
	 * @reason Implementing item of tag for repair instead of hardcoded Iron Ingot.
	 */
	@Overwrite
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack heldStack = player.getStackInHand(hand);
		// Require the held material to be within the repair material tag.
		if (!heldStack.isIn(ItemTags.VILBIARN_GOLEM_REPAIR_MATERIALS)) {
			return ActionResult.PASS;
		}
		// TODO:
		//  - Make the golem passively regenerate health over time, up to a threshold based on corrosion/crackiness stage:
		//   - Corrosion 0: Heals up to (100% of) max health.
		//   - Corrosion 1: Heals up to 75% of max health.
		//   - Corrosion 2: Heals up to 50% of max health.
		//   - Corrosion 3: Heals up to 25% of max health.
		//  - Only allow repair if corrosion is above 0, and reduce it by 1 upon successful repair item use.
		//   - This is in addition to instantaneously healing 25% of the golem's max health.
		//  - This prevents small and infrequent amounts of damage from causing chronic damage.
		// Attempt to heal, and require that healing is possible.
		float initialHealth = getHealth();
		heal(25.0F); // Note: For logical precision, this should be calculated based on max health (25%).
		if (getHealth() == initialHealth) {
			return ActionResult.PASS;
		}
		
		float pitch = 1.0F + (random.nextFloat() - random.nextFloat()) * 0.2F;
		playSound(SoundEvents.ENTITY_IRON_GOLEM_REPAIR, 1.0F, pitch);
		heldStack.decrementUnlessCreative(1, player);
		return ActionResult.success(getWorld().isClient);
	}
}
