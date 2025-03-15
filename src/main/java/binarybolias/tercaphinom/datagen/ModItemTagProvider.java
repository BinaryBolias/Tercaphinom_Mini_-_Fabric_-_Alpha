package binarybolias.tercaphinom.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.LOGGER;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating item tag data");
		
		// NOTE: These method calls are merely for reference; they effectively do nothing.
		getOrCreateTagBuilder(ItemTags.ARROWS);
		getOrCreateTagBuilder(ItemTags.AXES);
		getOrCreateTagBuilder(ItemTags.BEDS);
		getOrCreateTagBuilder(ItemTags.BOATS);
		getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
		
		// NOTE: This actually does do something (as an example); it allows leather to be used as "stone" for stone tools.
		// Thus, two sticks and three leather can be used to make any of:
		// - Stone Axe
		// - Stone Hoe
		// - Stone Pickaxe
		// - Stone Shovel
		// - Stone Sword
		getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS).add(Items.LEATHER);
	}
}
