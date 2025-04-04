package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.ModMessages;
import binarybolias.tercaphinom.references.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
//import net.fabricmc.fabric.api.blockrenderlayer.v1; // This doesn't exist for an unknown reason.

public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This would seemingly be required for rendering the texture with (boolean) transparency,
		//  but doesn't seem to be implemented.
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_DOOR, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_HATCH, RenderLayer.getCutout());
		
		ModMessages.registerS2CPackets();
		
		ModModelPredicateProvider.register();
	}
}
