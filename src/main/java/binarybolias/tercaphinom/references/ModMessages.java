package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModMessages {
	public ModMessages() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void registerC2SPackets() {
		log("Registering client-to-server messages");
	}
	
	public static void registerS2CPackets() {
		log("Registering server-to-client messages");
	}
	
	public static void sendToClientPlayerEntities(World world, BlockPos pos, CustomPayload payload) {
		// TODO: Add a method here. ("PlayerLookup.tracking...")
		PlayerLookup.tracking((ServerWorld) world, pos).forEach(player ->
				ServerPlayNetworking.send(player, payload));
	}
}
