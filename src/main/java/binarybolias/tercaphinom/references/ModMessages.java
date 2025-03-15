package binarybolias.tercaphinom.references;

import net.minecraft.network.PacketByteBuf;
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
	
	public static void sendToClientPlayerEntities(World world, BlockPos pos, Identifier message, PacketByteBuf data) {
		// TODO: Add a method here. ("PlayerLookup.tracking...")
	}
}
