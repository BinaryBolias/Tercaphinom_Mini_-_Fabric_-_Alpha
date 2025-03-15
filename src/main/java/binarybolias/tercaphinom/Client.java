package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.ModMessages;
import binarybolias.tercaphinom.references.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModMessages.registerS2CPackets();
		
		ModModelPredicateProvider.register();
	}
}
