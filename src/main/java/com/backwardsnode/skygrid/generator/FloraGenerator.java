package com.backwardsnode.skygrid.generator;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import com.backwardsnode.skygrid.BlockAttemptGenerator;
import com.backwardsnode.skygrid.SpawnCondition;

public class FloraGenerator implements BlockAttemptGenerator {

	public boolean canGenerateOn(BlockData block) {
		if (block == null) return false;
		switch (block.getMaterial()) {
		case GRASS_BLOCK:
		case MYCELIUM:
			return true;
		default:
			return false;
		}
	}
	
	public double getGeneratorChance() {
		return 0.4;
	}
	
	public SpawnCondition getGenerateCondition() {
		return SpawnCondition.TOP;
	}
	
	public BlockData getBlockData(BlockData basedOn, Random random) {
		Material mat;
		switch (basedOn.getMaterial()) {
		case GRASS_BLOCK:
			switch (random.nextInt(16)) {
			case 0:
				mat = Material.DANDELION;
				break;
			case 1:
				mat = Material.POPPY;
				break;
			case 2:
				mat = Material.BLUE_ORCHID;
				break;
			case 3:
				mat = Material.ALLIUM;
				break;
			case 4:
				mat = Material.AZURE_BLUET;
				break;
			case 5:
				mat = Material.RED_TULIP;
				break;
			case 6:
				mat = Material.ORANGE_TULIP;
				break;
			case 7:
				mat = Material.WHITE_TULIP;
				break;
			case 8:
				mat = Material.PINK_TULIP;
				break;
			case 9:
				mat = Material.OXEYE_DAISY;
				break;
			case 10:
				mat = Material.CORNFLOWER;
				break;
			case 11:
				mat = Material.LILY_OF_THE_VALLEY;
				break;
			case 12:
				mat = Material.SUNFLOWER;
				break;
			case 13:
				mat = Material.LILAC;
				break;
			case 14:
				mat = Material.ROSE_BUSH;
				break;
			default:
				mat = Material.PEONY;
				break;
			}
			break;
		default:
			mat = random.nextBoolean() ? Material.BROWN_MUSHROOM : Material.RED_MUSHROOM;
			break;
		}
		return Bukkit.createBlockData(mat);
	}
}