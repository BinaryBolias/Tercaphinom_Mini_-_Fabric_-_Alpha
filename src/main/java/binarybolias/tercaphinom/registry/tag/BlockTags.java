package binarybolias.tercaphinom.registry.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static binarybolias.tercaphinom.references.Reference.identifier;


/**
 * Provides code access to block tags.
 * @apiNote Tags defined here should be populated by {@link binarybolias.tercaphinom.datagen.ModBlockTagProvider}.
 * @see net.minecraft.registry.tag.BlockTags
 */
public interface BlockTags {
	/**
	 * Intended to be left empty.<br>
	 * Used for situations where defining a block tag is necessary, but undesired.
	 * @apiNote This is used by {@link binarybolias.tercaphinom.references.ModToolMaterials}
	 * for the inverse tag of every tool material.
	 */
	TagKey<Block> NIL = of("nil");
	
	//region ## Blacklists & Whitelists ##
	TagKey<Block> BLACKLISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON = of("blacklisted_for_layered_mound_placement_upon");
	TagKey<Block> WHITELISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON = of("whitelisted_for_layered_mound_placement_upon");
	//endregion
	
	//region ## Block Categories ##
	//# Stone #
	TagKey<Block> ALL_COBBLED_STONE_BLOCKS = of("all_cobbled_stone_blocks");
	TagKey<Block> ALL_NATURAL_STONE_BLOCKS = of("all_natural_stone_blocks");
	TagKey<Block> ALL_REFINED_STONE_BLOCKS = of("all_refined_stone_blocks");
	//# Metal #
	TagKey<Block> ALL_RAW_METAL_BLOCKS = of("all_raw_metal_blocks");
	TagKey<Block> ALL_REFINED_METAL_BLOCKS = of("all_refined_metal_blocks");
	//# Miscellaneous #
	TagKey<Block> ALL_ETERNALITH_BLOCKS = of("all_eternalith_blocks");
	//endregion
	
	//region ## Geological ##
	TagKey<Block> GEOLOGICALLY_COMPACTS_STRONGLY = of("geologically_compacts_strongly");
	TagKey<Block> GEOLOGICALLY_COMPACTS_WEAKLY = of("geologically_compacts_weakly");
	//endregion
	
	//region ## Vulnerability ##
	TagKey<Block> VULNERABLE_TO_CREEPER_EXPLOSION = of("vulnerable_to_creeper_explosion");
	//endregion
	
	//region ## Miscellaneous ##
	//# Ashy Netherrack Behavior #
	TagKey<Block> SPREADABLE_ATOP_ASHY_NETHERRACK = of("spreadable_atop_ashy_netherrack");
	TagKey<Block> SPREADABLE_INTO_ASHY_NETHERRACK = of("spreadable_into_ashy_netherrack");
	TagKey<Block> SPREADABLE_ONTO_ASHY_NETHERRACK = of("spreadable_onto_ashy_netherrack");
	//endregion
	
	
	
	private static TagKey<Block> of(String id) {
		return TagKey.of(RegistryKeys.BLOCK, identifier(id));
	}
	
	
	private static TagKey<net.minecraft.block.Block> ofCommon(String id) {
		return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", id));
	}
}
