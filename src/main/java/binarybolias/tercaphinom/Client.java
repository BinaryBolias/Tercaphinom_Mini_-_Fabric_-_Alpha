package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModMessages;
import binarybolias.tercaphinom.references.ModModelPredicateProvider;
import binarybolias.tercaphinom.references.Reference;
import net.fabricmc.api.ClientModInitializer;
//import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.minecraft.client.render.RenderLayer;

public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Reference.log("Initializing client");
		// Ths necessary packages are somehow not found, for an unknown reason, so we can't have blocks with transparency.
		// Map block states to render layers.
		// Necessary for blocks with transparency.
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_DOOR, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_HATCH, RenderLayer.getCutout());
		
		ModMessages.registerS2CPackets();
		
		ModModelPredicateProvider.register();
	}
}
