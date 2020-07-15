package com.backwardsnode.skygrid.generator;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import com.backwardsnode.skygrid.BlockAttemptGenerator;
import com.backwardsnode.skygrid.SpawnCondition;

public class BellGenerator implements BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block) {
		if (block == null) return false;
		switch (block.getMaterial()) {
		case OAK_PLANKS:
		case SPRUCE_PLANKS:
		case BIRCH_PLANKS:
		case JUNGLE_PLANKS:
		case ACACIA_PLANKS:
		case SANDSTONE:
			return true;
		default:
			return false;
		}
	}
	
	public double getDefaultGeneratorChance() {
		return 0.0001;
	}
	
	public SpawnCondition getGenerateCondition() {
		return SpawnCondition.TOP;
	}
	
	public BlockData getBlockData(BlockData basedOn, Random random) {
		return Bukkit.createBlockData(Material.BELL);
		
	}
}
