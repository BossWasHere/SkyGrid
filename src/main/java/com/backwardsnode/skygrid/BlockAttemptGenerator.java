package com.backwardsnode.skygrid;

import java.util.Random;

import org.bukkit.block.data.BlockData;

public interface BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block);
	public SpawnCondition getGenerateCondition();
	public double getGeneratorChance();
	public BlockData getBlockData(BlockData basedOn, Random random);
	
}
