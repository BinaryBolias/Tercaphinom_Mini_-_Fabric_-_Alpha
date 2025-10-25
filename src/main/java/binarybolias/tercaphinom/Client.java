package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;


public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Reference.logMainEvent("Initializing client");
		
		setBlockRenderLayers();
		
		ModMessages.registerS2CPackets();
		
		ModModelPredicateProvider.register();
	}
	
	
	private void setBlockRenderLayers() {
		// Allow block textures to render with transparency (cutout).
		BlockRenderLayerMap.INSTANCE.putBlock(JAUBlocks.STARCHCAP_MUSHROOM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDAK_HATCH, RenderLayer.getCutout());
		// Allow block textures to render with transparency (translucent).
		BlockRenderLayerMap.INSTANCE.putBlock(JAUBlocks.CHERRY_JELLYBLOCK, RenderLayer.getTranslucent());
//		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(VMOBlocks.GLASS, RenderLayer.getTranslucent());
//		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(VMOBlocks.GLASS_PANE, RenderLayer.getTranslucent());
	}
}
