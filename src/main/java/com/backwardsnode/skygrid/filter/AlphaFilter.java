package com.backwardsnode.skygrid.filter;

import org.bukkit.Material;

import com.backwardsnode.skygrid.BlockFilter;

public class AlphaFilter implements BlockFilter {

	@Override
	public boolean includeMaterial(Material material) {
		// for some reason isSolid() includes legacy blocks but also calls isBlock() which excludes them
		if (!material.isSolid() && !(material.equals(Material.WATER) || material.equals(Material.LAVA))) return false;
		switch (material) {
		/*
		 * Unbreakable Blocks
		 */
		case BARRIER:
		case BEDROCK:
		case CHAIN_COMMAND_BLOCK:
		case COMMAND_BLOCK:
		case END_GATEWAY:
		case END_PORTAL_FRAME:
		case JIGSAW:
		case STRUCTURE_VOID:
		case MOVING_PISTON:
		case REPEATING_COMMAND_BLOCK:
		case STRUCTURE_BLOCK:
		/*
		 * Double-Blocks
		 */
		case WHITE_BED:
		case ORANGE_BED:
		case MAGENTA_BED:
		case LIGHT_BLUE_BED:
		case YELLOW_BED:
		case LIME_BED:
		case PINK_BED:
		case GRAY_BED:
		case LIGHT_GRAY_BED:
		case CYAN_BED:
		case PURPLE_BED:
		case BLUE_BED:
		case BROWN_BED:
		case GREEN_BED:
		case RED_BED:
		case BLACK_BED:
		case WHITE_BANNER:
		case ORANGE_BANNER:
		case MAGENTA_BANNER:
		case LIGHT_BLUE_BANNER:
		case YELLOW_BANNER:
		case LIME_BANNER:
		case PINK_BANNER:
		case GRAY_BANNER:
		case LIGHT_GRAY_BANNER:
		case CYAN_BANNER:
		case PURPLE_BANNER:
		case BLUE_BANNER:
		case BROWN_BANNER:
		case GREEN_BANNER:
		case RED_BANNER:
		case BLACK_BANNER:
		case WHITE_WALL_BANNER:
		case ORANGE_WALL_BANNER:
		case MAGENTA_WALL_BANNER:
		case LIGHT_BLUE_WALL_BANNER:
		case YELLOW_WALL_BANNER:
		case LIME_WALL_BANNER:
		case PINK_WALL_BANNER:
		case GRAY_WALL_BANNER:
		case LIGHT_GRAY_WALL_BANNER:
		case CYAN_WALL_BANNER:
		case PURPLE_WALL_BANNER:
		case BLUE_WALL_BANNER:
		case BROWN_WALL_BANNER:
		case GREEN_WALL_BANNER:
		case RED_WALL_BANNER:
		case BLACK_WALL_BANNER:

		case OAK_DOOR:
		case SPRUCE_DOOR:
		case BIRCH_DOOR:
		case JUNGLE_DOOR:
		case ACACIA_DOOR:
		case DARK_OAK_DOOR:
		case CRIMSON_DOOR:
		case WARPED_DOOR:
		case IRON_DOOR:
		/*
		 * Vegetation can be spawned later
		*/
		case CACTUS:
		case BAMBOO:
		/*
		 * Are these "solid"?
		 */
		case DEAD_BRAIN_CORAL:
		case DEAD_BRAIN_CORAL_FAN:
		case DEAD_BRAIN_CORAL_WALL_FAN:
		case DEAD_BUBBLE_CORAL:
		case DEAD_BUBBLE_CORAL_FAN:
		case DEAD_BUBBLE_CORAL_WALL_FAN:
		case DEAD_FIRE_CORAL:
		case DEAD_FIRE_CORAL_FAN:
		case DEAD_FIRE_CORAL_WALL_FAN:
		case DEAD_HORN_CORAL:
		case DEAD_HORN_CORAL_FAN:
		case DEAD_HORN_CORAL_WALL_FAN:
		case DEAD_TUBE_CORAL:
		case DEAD_TUBE_CORAL_FAN:
		case DEAD_TUBE_CORAL_WALL_FAN:

		case OAK_SIGN:
		case SPRUCE_SIGN:
		case BIRCH_SIGN:
		case JUNGLE_SIGN:
		case ACACIA_SIGN:
		case DARK_OAK_SIGN:
		case CRIMSON_SIGN:
		case WARPED_SIGN:
		case OAK_WALL_SIGN:
		case SPRUCE_WALL_SIGN:
		case BIRCH_WALL_SIGN:
		case JUNGLE_WALL_SIGN:
		case ACACIA_WALL_SIGN:
		case DARK_OAK_WALL_SIGN:
		case CRIMSON_WALL_SIGN:
		case WARPED_WALL_SIGN:

		case OAK_PRESSURE_PLATE:
		case SPRUCE_PRESSURE_PLATE:
		case BIRCH_PRESSURE_PLATE:
		case JUNGLE_PRESSURE_PLATE:
		case ACACIA_PRESSURE_PLATE:
		case DARK_OAK_PRESSURE_PLATE:
		case CRIMSON_PRESSURE_PLATE:
		case WARPED_PRESSURE_PLATE:
		case STONE_PRESSURE_PLATE:
		case POLISHED_BLACKSTONE_PRESSURE_PLATE:
		case HEAVY_WEIGHTED_PRESSURE_PLATE:
		case LIGHT_WEIGHTED_PRESSURE_PLATE:
		/*
		 * Dangerous
		 */
		case IRON_BARS:
		case OAK_FENCE:
		case SPRUCE_FENCE:
		case BIRCH_FENCE:
		case JUNGLE_FENCE:
		case ACACIA_FENCE:
		case DARK_OAK_FENCE:
		case CRIMSON_FENCE:
		case WARPED_FENCE:
		case OAK_FENCE_GATE:
		case SPRUCE_FENCE_GATE:
		case BIRCH_FENCE_GATE:
		case JUNGLE_FENCE_GATE:
		case ACACIA_FENCE_GATE:
		case DARK_OAK_FENCE_GATE:
		case CRIMSON_FENCE_GATE:
		case WARPED_FENCE_GATE:
		case NETHER_BRICK_FENCE:
		
		case GLASS_PANE:
		case WHITE_STAINED_GLASS_PANE:
		case ORANGE_STAINED_GLASS_PANE:
		case MAGENTA_STAINED_GLASS_PANE:
		case LIGHT_BLUE_STAINED_GLASS_PANE:
		case YELLOW_STAINED_GLASS_PANE:
		case LIME_STAINED_GLASS_PANE:
		case PINK_STAINED_GLASS_PANE:
		case GRAY_STAINED_GLASS_PANE:
		case LIGHT_GRAY_STAINED_GLASS_PANE:
		case CYAN_STAINED_GLASS_PANE:
		case PURPLE_STAINED_GLASS_PANE:
		case BLUE_STAINED_GLASS_PANE:
		case BROWN_STAINED_GLASS_PANE:
		case GREEN_STAINED_GLASS_PANE:
		case RED_STAINED_GLASS_PANE:
		case BLACK_STAINED_GLASS_PANE:

		/*
		 * Other
		 */
		case SHULKER_BOX:
		case WHITE_SHULKER_BOX:
		case ORANGE_SHULKER_BOX:
		case MAGENTA_SHULKER_BOX:
		case LIGHT_BLUE_SHULKER_BOX:
		case YELLOW_SHULKER_BOX:
		case LIME_SHULKER_BOX:
		case PINK_SHULKER_BOX:
		case GRAY_SHULKER_BOX:
		case LIGHT_GRAY_SHULKER_BOX:
		case CYAN_SHULKER_BOX:
		case PURPLE_SHULKER_BOX:
		case BLUE_SHULKER_BOX:
		case BROWN_SHULKER_BOX:
		case GREEN_SHULKER_BOX:
		case RED_SHULKER_BOX:
		case BLACK_SHULKER_BOX:

		case CAMPFIRE:
		case SOUL_CAMPFIRE:

		case BARREL:
		case LANTERN:
		case SOUL_LANTERN:
		case FLOWER_POT:
		case DRAGON_EGG:
		case TURTLE_EGG:
		case CONDUIT:
		case PISTON_HEAD:
			return false;
		default:
			return true;
		}
	}

	@Override
	public int estimatedSelectionSize() {
		return 500;
	}
}
