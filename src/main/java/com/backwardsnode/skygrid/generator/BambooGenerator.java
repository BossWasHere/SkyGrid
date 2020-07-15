package com.backwardsnode.skygrid.generator;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Bamboo;

import com.backwardsnode.skygrid.BlockAttemptGenerator;
import com.backwardsnode.skygrid.SpawnCondition;

public class BambooGenerator implements BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block) {
		if (block == null) return false;
		switch (block.getMaterial()) {
		case DIRT:
		case GRASS_BLOCK:
		case COARSE_DIRT:
		case GRAVEL:
		case MYCELIUM:
		case PODZOL:
		case SAND:
		case RED_SAND:
			return true;
		default:
			return false;
		}
	}
	
	public double getGeneratorChance() {
		return 0.01;
	}
	
	public SpawnCondition getGenerateCondition() {
		return SpawnCondition.TOP;
	}
	
	public BlockData getBlockData(BlockData basedOn, Random random) {
		Bamboo bd = (Bamboo) Bukkit.createBlockData(Material.BAMBOO);
		//bd.setAge(0);
		return bd;
		
	}
}
