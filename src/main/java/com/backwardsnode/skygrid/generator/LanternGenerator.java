package com.backwardsnode.skygrid.generator;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Lantern;

import com.backwardsnode.skygrid.BlockAttemptGenerator;
import com.backwardsnode.skygrid.SpawnCondition;

public class LanternGenerator implements BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block) {
		if (block == null) return false;
		return block.getMaterial().isSolid();
	}
	
	public double getDefaultGeneratorChance() {
		return 0.005;
	}
	
	public SpawnCondition getGenerateCondition() {
		return SpawnCondition.BOTTOM;
	}
	
	public BlockData getBlockData(BlockData basedOn, Random random) {
		Lantern lantern = (Lantern) Bukkit.createBlockData(Material.LANTERN);
		lantern.setHanging(true);
		return lantern;
	}
}
