package com.backwardsnode.skygrid.filter;

import org.bukkit.Material;

/**
 * This filter extends the {@link ColorfulSurvivalFilter} which removes most of the craftable blocks.
 * Instead, this filter removes the colored block variants.
 * @author BackwardsNode
 *
 */
public class SurvivalFilter extends ColorfulSurvivalFilter {
	
	@Override
	public boolean includeMaterial(Material material) {
		if (!super.includeMaterial(material)) return false;
		switch (material) {
		/*
		 * Colorful Stuff
		 */
		//case WHITE_WOOL: // Include basic wool
		case ORANGE_WOOL:
		case MAGENTA_WOOL:
		case LIGHT_BLUE_WOOL:
		case YELLOW_WOOL:
		case LIME_WOOL:
		case PINK_WOOL:
		case GRAY_WOOL:
		case LIGHT_GRAY_WOOL:
		case CYAN_WOOL:
		case PURPLE_WOOL:
		case BLUE_WOOL:
		case BROWN_WOOL:
		case GREEN_WOOL:
		case RED_WOOL:
		case BLACK_WOOL:
			
		case WHITE_STAINED_GLASS:
		case ORANGE_STAINED_GLASS:
		case MAGENTA_STAINED_GLASS:
		case LIGHT_BLUE_STAINED_GLASS:
		case YELLOW_STAINED_GLASS:
		case LIME_STAINED_GLASS:
		case PINK_STAINED_GLASS:
		case GRAY_STAINED_GLASS:
		case LIGHT_GRAY_STAINED_GLASS:
		case CYAN_STAINED_GLASS:
		case PURPLE_STAINED_GLASS:
		case BLUE_STAINED_GLASS:
		case BROWN_STAINED_GLASS:
		case GREEN_STAINED_GLASS:
		case RED_STAINED_GLASS:
		case BLACK_STAINED_GLASS:
		
		case TERRACOTTA: // Can be crafted
		case WHITE_TERRACOTTA:
		case ORANGE_TERRACOTTA:
		case MAGENTA_TERRACOTTA:
		case LIGHT_BLUE_TERRACOTTA:
		case YELLOW_TERRACOTTA:
		case LIME_TERRACOTTA:
		case PINK_TERRACOTTA:
		case GRAY_TERRACOTTA:
		case LIGHT_GRAY_TERRACOTTA:
		case CYAN_TERRACOTTA:
		case PURPLE_TERRACOTTA:
		case BLUE_TERRACOTTA:
		case BROWN_TERRACOTTA:
		case GREEN_TERRACOTTA:
		case RED_TERRACOTTA:
		case BLACK_TERRACOTTA:
			
		case WHITE_GLAZED_TERRACOTTA:
		case ORANGE_GLAZED_TERRACOTTA:
		case MAGENTA_GLAZED_TERRACOTTA:
		case LIGHT_BLUE_GLAZED_TERRACOTTA:
		case YELLOW_GLAZED_TERRACOTTA:
		case LIME_GLAZED_TERRACOTTA:
		case PINK_GLAZED_TERRACOTTA:
		case GRAY_GLAZED_TERRACOTTA:
		case LIGHT_GRAY_GLAZED_TERRACOTTA:
		case CYAN_GLAZED_TERRACOTTA:
		case PURPLE_GLAZED_TERRACOTTA:
		case BLUE_GLAZED_TERRACOTTA:
		case BROWN_GLAZED_TERRACOTTA:
		case GREEN_GLAZED_TERRACOTTA:
		case RED_GLAZED_TERRACOTTA:
		case BLACK_GLAZED_TERRACOTTA:
			
		case WHITE_CONCRETE_POWDER:
		case ORANGE_CONCRETE_POWDER:
		case MAGENTA_CONCRETE_POWDER:
		case LIGHT_BLUE_CONCRETE_POWDER:
		case YELLOW_CONCRETE_POWDER:
		case LIME_CONCRETE_POWDER:
		case PINK_CONCRETE_POWDER:
		case GRAY_CONCRETE_POWDER:
		case LIGHT_GRAY_CONCRETE_POWDER:
		case CYAN_CONCRETE_POWDER:
		case PURPLE_CONCRETE_POWDER:
		case BLUE_CONCRETE_POWDER:
		case BROWN_CONCRETE_POWDER:
		case GREEN_CONCRETE_POWDER:
		case RED_CONCRETE_POWDER:
		case BLACK_CONCRETE_POWDER:
			
		case WHITE_CONCRETE:
		case ORANGE_CONCRETE:
		case MAGENTA_CONCRETE:
		case LIGHT_BLUE_CONCRETE:
		case YELLOW_CONCRETE:
		case LIME_CONCRETE:
		case PINK_CONCRETE:
		case GRAY_CONCRETE:
		case LIGHT_GRAY_CONCRETE:
		case CYAN_CONCRETE:
		case PURPLE_CONCRETE:
		case BLUE_CONCRETE:
		case BROWN_CONCRETE:
		case GREEN_CONCRETE:
		case RED_CONCRETE:
		case BLACK_CONCRETE:
		
		/*
		 * "Wood" and Stripped Variants
		 */
		case OAK_WOOD:
		case SPRUCE_WOOD:
		case BIRCH_WOOD:
		case JUNGLE_WOOD:
		case ACACIA_WOOD:
		case DARK_OAK_WOOD:
		case CRIMSON_HYPHAE:
		case WARPED_HYPHAE:
		case STRIPPED_OAK_LOG:
		case STRIPPED_SPRUCE_LOG:
		case STRIPPED_BIRCH_LOG:
		case STRIPPED_JUNGLE_LOG:
		case STRIPPED_ACACIA_LOG:
		case STRIPPED_DARK_OAK_LOG:
		case STRIPPED_CRIMSON_STEM:
		case STRIPPED_WARPED_STEM:
		case STRIPPED_OAK_WOOD:
		case STRIPPED_SPRUCE_WOOD:
		case STRIPPED_BIRCH_WOOD:
		case STRIPPED_JUNGLE_WOOD:
		case STRIPPED_ACACIA_WOOD:
		case STRIPPED_DARK_OAK_WOOD:
		case STRIPPED_CRIMSON_HYPHAE:
		case STRIPPED_WARPED_HYPHAE:
			
		/*
		 * Smooth Variants
		 */
		case POLISHED_ANDESITE:
		case POLISHED_DIORITE:
		case POLISHED_GRANITE:
			return false;
		default:
			return true;
		}
	}
	
	@Override
	public int estimatedSelectionSize() {
		return 200;
	}
}
