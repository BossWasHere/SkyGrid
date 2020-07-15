package com.backwardsnode.skygrid;

import java.util.Random;

import org.bukkit.block.data.BlockData;

public class WeightedBlockAttemptGenerator implements BlockAttemptGenerator {

	private final BlockAttemptGenerator GENERATOR;
	private final double WEIGHT;
	
	public WeightedBlockAttemptGenerator(BlockAttemptGenerator generator) {
		GENERATOR = generator;
		WEIGHT = generator.getDefaultGeneratorChance();
	}
	
	public WeightedBlockAttemptGenerator(BlockAttemptGenerator generator, double weight) {
		GENERATOR = generator;
		WEIGHT = weight;
	}

	@Override
	public boolean canGenerateOn(BlockData block) {
		return GENERATOR.canGenerateOn(block);
	}

	@Override
	public SpawnCondition getGenerateCondition() {
		return GENERATOR.getGenerateCondition();
	}

	public double getPreferredChance() {
		return WEIGHT;
	}
	
	@Override
	public double getDefaultGeneratorChance() {
		return GENERATOR.getDefaultGeneratorChance();
	}

	@Override
	public BlockData getBlockData(BlockData basedOn, Random random) {
		return GENERATOR.getBlockData(basedOn, random);
	}
}
