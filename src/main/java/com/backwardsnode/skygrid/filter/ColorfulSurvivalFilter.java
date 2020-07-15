package com.backwardsnode.skygrid.filter;

import org.bukkit.Material;

/**
 * This filter extends the {@link AlphaFilter} which removes unbreakable and glitchy blocks.
 * It is intended for survival use.
 * @author BackwardsNode
 *
 */
public class ColorfulSurvivalFilter extends AlphaFilter {

	@Override
	public boolean includeMaterial(Material material) {
		if (!super.includeMaterial(material)) return false;
		switch (material) {
		/*
		 * Villager Workstations
		 */
		case BLAST_FURNACE:
		case SMOKER:
		case CARTOGRAPHY_TABLE:
		case BREWING_STAND:
		case COMPOSTER:
		case BARREL:
		case FLETCHING_TABLE:
		case CAULDRON:
		case LECTERN:
		case STONECUTTER:
		case LOOM:
		case SMITHING_TABLE:
		case GRINDSTONE:
		
		/*
		 * Misc Craftables
		 */
		case FURNACE:
		case CRAFTING_TABLE:
		case CHEST:
		case TRAPPED_CHEST:
		case ENDER_CHEST:
		case CARVED_PUMPKIN:
		case JACK_O_LANTERN:
		case PISTON:
		case STICKY_PISTON:
		case TNT:
		case OBSERVER:
		case TARGET:
		case DISPENSER:
		case DROPPER:
		case REDSTONE_LAMP:
		case ANVIL:
		case CHIPPED_ANVIL:
		case DAMAGED_ANVIL:
		case BEEHIVE:
		case RESPAWN_ANCHOR:
		case JUKEBOX:
		case NOTE_BLOCK:
		case DAYLIGHT_DETECTOR:
		case LODESTONE:
		case HOPPER:
		case CAKE:
		case CHAIN:
		case BELL:
		case BEACON:
		
		/*
		 * Resource Blocks
		 */
		case IRON_BLOCK:
		case GOLD_BLOCK:
		case REDSTONE_BLOCK:
		case LAPIS_BLOCK:
		case EMERALD_BLOCK:
		case DIAMOND_BLOCK:
		case NETHERITE_BLOCK:
		
		/*
		 * Trapdoors
		 */
		case OAK_TRAPDOOR:
		case SPRUCE_TRAPDOOR:
		case BIRCH_TRAPDOOR:
		case JUNGLE_TRAPDOOR:
		case ACACIA_TRAPDOOR:
		case DARK_OAK_TRAPDOOR:
		case CRIMSON_TRAPDOOR:
		case WARPED_TRAPDOOR:
		case IRON_TRAPDOOR:
		
		/*
		 * Slabs and Stairs
		 */
		case OAK_SLAB:
		case SPRUCE_SLAB:
		case BIRCH_SLAB:
		case JUNGLE_SLAB:
		case ACACIA_SLAB:
		case DARK_OAK_SLAB:
		case CRIMSON_SLAB:
		case WARPED_SLAB:
		case OAK_STAIRS:
		case SPRUCE_STAIRS:
		case BIRCH_STAIRS:
		case JUNGLE_STAIRS:
		case ACACIA_STAIRS:
		case DARK_OAK_STAIRS:
		case CRIMSON_STAIRS:
		case WARPED_STAIRS:
			
		case ANDESITE_SLAB:
		case POLISHED_ANDESITE_SLAB:
		case DIORITE_SLAB:
		case POLISHED_DIORITE_SLAB:
		case GRANITE_SLAB:
		case POLISHED_GRANITE_SLAB:
		case STONE_SLAB:
		case SMOOTH_STONE_SLAB:
		case COBBLESTONE_SLAB:
		case MOSSY_COBBLESTONE_SLAB:
		case STONE_BRICK_SLAB:
		case MOSSY_STONE_BRICK_SLAB:
		case SANDSTONE_SLAB:
		case SMOOTH_SANDSTONE_SLAB:
		case CUT_SANDSTONE_SLAB:
		case RED_SANDSTONE_SLAB:
		case SMOOTH_RED_SANDSTONE_SLAB:
		case CUT_RED_SANDSTONE_SLAB:
		case BRICK_SLAB:
		case PRISMARINE_SLAB:
		case PRISMARINE_BRICK_SLAB:
		case DARK_PRISMARINE_SLAB:
		case NETHER_BRICK_SLAB:
		case RED_NETHER_BRICK_SLAB:
		case QUARTZ_SLAB:
		case SMOOTH_QUARTZ_SLAB:
		case PURPUR_SLAB:
		case END_STONE_BRICK_SLAB:
		case BLACKSTONE_SLAB:
		case POLISHED_BLACKSTONE_SLAB:
		case POLISHED_BLACKSTONE_BRICK_SLAB:
			
		case ANDESITE_STAIRS:
		case POLISHED_ANDESITE_STAIRS:
		case DIORITE_STAIRS:
		case POLISHED_DIORITE_STAIRS:
		case GRANITE_STAIRS:
		case POLISHED_GRANITE_STAIRS:
		case STONE_STAIRS:
		case COBBLESTONE_STAIRS:
		case MOSSY_COBBLESTONE_STAIRS:
		case STONE_BRICK_STAIRS:
		case MOSSY_STONE_BRICK_STAIRS:
		case SANDSTONE_STAIRS:
		case SMOOTH_SANDSTONE_STAIRS:
		case RED_SANDSTONE_STAIRS:
		case SMOOTH_RED_SANDSTONE_STAIRS:
		case BRICK_STAIRS:
		case PRISMARINE_STAIRS:
		case PRISMARINE_BRICK_STAIRS:
		case DARK_PRISMARINE_STAIRS:
		case NETHER_BRICK_STAIRS:
		case RED_NETHER_BRICK_STAIRS:
		case QUARTZ_STAIRS:
		case SMOOTH_QUARTZ_STAIRS:
		case PURPUR_STAIRS:
		case END_STONE_BRICK_STAIRS:
		case BLACKSTONE_STAIRS:
		case POLISHED_BLACKSTONE_STAIRS:
		case POLISHED_BLACKSTONE_BRICK_STAIRS:
		
		/*
		 * Walls
		 */
		case ANDESITE_WALL:
		case DIORITE_WALL:
		case GRANITE_WALL:
		case COBBLESTONE_WALL:
		case MOSSY_COBBLESTONE_WALL:
		case STONE_BRICK_WALL:
		case MOSSY_STONE_BRICK_WALL:
		case SANDSTONE_WALL:
		case RED_SANDSTONE_WALL:
		case BRICK_WALL:
		case PRISMARINE_WALL:
		case NETHER_BRICK_WALL:
		case RED_NETHER_BRICK_WALL:
		case END_STONE_BRICK_WALL:
		case BLACKSTONE_WALL:
		case POLISHED_BLACKSTONE_WALL:
		case POLISHED_BLACKSTONE_BRICK_WALL:
			return false;
		default:
			return true;
		}
	}
	
	@Override
	public int estimatedSelectionSize() {
		return 300;
	}
}
