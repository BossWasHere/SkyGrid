package com.backwardsnode.skygrid.weight;

import org.bukkit.Material;

import com.backwardsnode.skygrid.BlockWeight;

public class AlphaWeight implements BlockWeight {

	@Override
	public int getWeight(Material material) {
		switch (material) {
		case DIRT:
		case COARSE_DIRT:
		case COBBLESTONE:
			return 500;
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
			return 450;
		case STONE:
		case MOSSY_COBBLESTONE:
		case STONE_BRICKS:
		case OAK_LOG:
		case SPRUCE_LOG:
		case BIRCH_LOG:
		case JUNGLE_LOG:
		case ACACIA_LOG:
		case DARK_OAK_LOG:
			return 400;
		case PODZOL:
		case CRIMSON_STEM:
		case WARPED_STEM:
		case FARMLAND:
			return 350;
		case GRASS_BLOCK:
		case RED_SAND:
			return 300;
		case MYCELIUM:
		case CLAY:
		case OBSIDIAN:
			return 200;
		case NETHERRACK:
		case BLACKSTONE:
			return 150;
		case IRON_ORE:
		case GOLD_ORE:
		case WATER:
			return 100;
		case DIAMOND_ORE:
		case LAPIS_ORE:
		case REDSTONE_ORE:
		case LAVA:
			return 50;
		case EMERALD_ORE:
		case ANCIENT_DEBRIS:
		//case BEDROCK:
			return 20;
		case IRON_BLOCK:
		case GOLD_BLOCK:
			return 10;
		case NETHER_PORTAL:
		case REDSTONE_BLOCK:
		case LAPIS_BLOCK:
		case ENDER_CHEST:
		case EMERALD_BLOCK:
		case DIAMOND_BLOCK:
		case SPAWNER:
			return 5;
		case BEACON:
		case END_PORTAL:
		case ENCHANTING_TABLE:
			return 1;
		default: 
			return 100;
		}
	}
	
}
