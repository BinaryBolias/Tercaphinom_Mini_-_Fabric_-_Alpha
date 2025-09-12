package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModMessages;
import binarybolias.tercaphinom.references.ModModelPredicateProvider;
import binarybolias.tercaphinom.references.Reference;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;


public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Reference.logMainEvent("Initializing client");
		
		// Allow block textures to render with transparency (cutout).
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STARCHCAP_MUSHROOM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_HATCH, RenderLayer.getCutout());
		// Allow block textures to render with transparency (translucent).
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHERRY_JELLYBLOCK, RenderLayer.getTranslucent());
		
		ModMessages.registerS2CPackets();
		
		ModModelPredicateProvider.register();
	}
}
