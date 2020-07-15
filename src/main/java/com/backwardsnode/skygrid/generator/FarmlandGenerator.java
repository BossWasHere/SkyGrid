package com.backwardsnode.skygrid.generator;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import com.backwardsnode.skygrid.BlockAttemptGenerator;
import com.backwardsnode.skygrid.SpawnCondition;

public class FarmlandGenerator implements BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block) {
		if (block == null) return false;
		return block.getMaterial().equals(Material.FARMLAND);
	}
	
	public double getGeneratorChance() {
		return 0.9;
	}
	
	public SpawnCondition getGenerateCondition() {
		return SpawnCondition.TOP;
	}
	
	public BlockData getBlockData(BlockData basedOn, Random random) {
		Material mat;
		switch (random.nextInt(6)) {
		case 0:
			mat = Material.WHEAT;
			break;
		case 1:
			mat = Material.CARROTS;
			break;
		case 2:
			mat = Material.POTATOES;
			break;
		case 3:
			mat = Material.BEETROOTS;
			break;
		case 4:
			mat = Material.MELON_STEM;
			break;
		default:
			mat = Material.PUMPKIN_STEM;
			break;
		}
		return Bukkit.createBlockData(mat);
	}
}
