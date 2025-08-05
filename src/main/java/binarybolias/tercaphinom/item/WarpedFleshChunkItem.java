package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class WarpedFleshChunkItem extends Item {
	public WarpedFleshChunkItem(Settings settings) {
		super(settings);
	}
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		ItemStack itemStack = super.finishUsing(stack, world, user);
		
		if (!world.isClient && checkRandomChance(user)) {
			tryTeleport(world, user, 2);
		}
		
		// Add a cooldown for item use.
		if (user instanceof PlayerEntity playerEntity) {
			playerEntity.getItemCooldownManager().set(this, 20);
		}
		
		return itemStack;
	}
	
	
	private boolean checkRandomChance(LivingEntity user) {
		// Return 'true' with a 1/2 chance.
		return (user.getRandom().nextDouble() > 0.5);
	}
	
	
	private void tryTeleport(World world, LivingEntity user, int maxDistance) {
		// Stop riding any vehicle.
		if (user.hasVehicle()) {
			user.stopRiding();
		}
		// Make up to 16 teleportation attempts.
		for (int i = 0; i < 16; i++) {
			// Get a random set of coordinates within 'maxDistance'
			double targetX = user.getX() + (user.getRandom().nextDouble() - 0.5) * (2.0 * maxDistance);
			double targetY = MathHelper.clamp(
					user.getY() + (double)(user.getRandom().nextInt(2 * maxDistance) - maxDistance),
					(double)world.getBottomY(),
					(double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1)
			);
			double targetZ = user.getZ() + (user.getRandom().nextDouble() - 0.5) * (2.0 * maxDistance);
			// Attempt a teleport to the target coordinates.
			Vec3d initialUserPosition = user.getPos();
			if (user.teleport(targetX, targetY, targetZ, true)) {
				handleSuccessfulTeleport(world, user, initialUserPosition);
				break;
			}
		}
	}
	
	
	private void handleSuccessfulTeleport(World world, LivingEntity user, Vec3d initialUserPosition) {
		world.emitGameEvent(GameEvent.TELEPORT, initialUserPosition, GameEvent.Emitter.of(user));
		SoundCategory soundCategory;
		SoundEvent soundEvent;
		if (user instanceof FoxEntity) {
			soundCategory = SoundCategory.NEUTRAL;
			soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
		} else {
			soundCategory = SoundCategory.PLAYERS;
			soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
		}
		
		world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
		user.onLanding();
	}
}
