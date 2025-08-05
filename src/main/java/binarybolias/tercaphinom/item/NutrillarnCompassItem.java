package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;
import java.util.Set;

public class NutrillarnCompassItem extends Item {
	public NutrillarnCompassItem(Settings settings) {
		super(settings);
	}
	// TODO: Allow for attuning to a Lodestone.
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		ItemStack itemStack = super.finishUsing(stack, world, user);
		
		if (!world.isClient && user instanceof ServerPlayerEntity serverPlayerEntity) {
			teleportToSpawn(world, serverPlayerEntity);
			serverPlayerEntity.getItemCooldownManager().set(this, 20);
		}
		
		return itemStack;
	}
	
	
	private void teleportToSpawn(World world, ServerPlayerEntity serverPlayerEntity) {
		// Get player spawn location.
		BlockPos targetPos = serverPlayerEntity.getSpawnPointPosition();
		ServerWorld targetWorld;
		// Get world spawn location if player spawn location is not set.
		if (targetPos == null) {
			targetPos = world.getSpawnPos();
			targetWorld = Objects.requireNonNull(world.getServer()).getOverworld();
		} else {
			targetWorld = serverPlayerEntity.server.getWorld(serverPlayerEntity.getSpawnPointDimension());
		}
		
		if (serverPlayerEntity.teleport(
				targetWorld, targetPos.getX(), targetPos.getY(), targetPos.getZ(),
				Set.of(), serverPlayerEntity.getYaw(), serverPlayerEntity.getPitch())
		) {
			// Emit game event.
			world.emitGameEvent(GameEvent.TELEPORT, serverPlayerEntity.getPos(), GameEvent.Emitter.of(serverPlayerEntity));
			// Emit sound.
			SoundCategory soundCategory = SoundCategory.PLAYERS;
			SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
			world.playSound(null, serverPlayerEntity.getX(), serverPlayerEntity.getY(), serverPlayerEntity.getZ(), soundEvent, soundCategory);
			
			serverPlayerEntity.onLanding();
		}
		
		// NOTE: Old:
//		world.getServer().getPlayerManager().respawnPlayer(serverPlayerEntity, true);
	}
}
