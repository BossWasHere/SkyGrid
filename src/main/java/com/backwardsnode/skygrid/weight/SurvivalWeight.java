package com.backwardsnode.skygrid.weight;

import org.bukkit.Material;

import com.backwardsnode.skygrid.BlockWeight;

public class SurvivalWeight implements BlockWeight {

	@Override
	public int getWeight(Material material) {
		switch (material) {
		case DIRT:
		case COBBLESTONE:
			return 500;
		case COARSE_DIRT:
		case SAND:
		case GRAVEL:
		case OAK_PLANKS:
		case SPRUCE_PLANKS:
		case BIRCH_PLANKS:
		case JUNGLE_PLANKS:
		case ACACIA_PLANKS:
		case DARK_OAK_PLANKS:
		case CRIMSON_PLANKS:
		case WARPED_PLANKS:
			return 200;
		case STONE:
		case RED_SAND:
		case MOSSY_COBBLESTONE:
		case STONE_BRICKS:
		case OAK_LOG:
		case SPRUCE_LOG:
		case BIRCH_LOG:
		case JUNGLE_LOG:
		case ACACIA_LOG:
		case DARK_OAK_LOG:
		case FARMLAND:
			return 100;
		case PODZOL:
		case CLAY:
		case GRASS_BLOCK:
		case CRIMSON_STEM:
		case WARPED_STEM:
		case IRON_ORE:
			return 50;
		case MYCELIUM:
		case OBSIDIAN:
		case NETHERRACK:
		case BLACKSTONE:
		case GOLD_ORE:
		case WATER:
			return 40;
		case LAPIS_ORE:
		case REDSTONE_ORE:
		case LAVA:
			return 30;
		case DIAMOND_ORE:
		case EMERALD_ORE:
			return 20;
		case BOOKSHELF:
			return 10;
		case SPAWNER:
		case ANCIENT_DEBRIS:
			return 5;
		case END_PORTAL:
			return 1;
		default: 
			return 25;
		}
	}

}
