package com.backwardsnode.skygrid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import com.backwardsnode.skygrid.config.FilterConfig;
import com.backwardsnode.skygrid.config.GeneratorConfig;
import com.backwardsnode.skygrid.filter.AlphaFilter;
import com.backwardsnode.skygrid.generator.BambooGenerator;
import com.backwardsnode.skygrid.generator.BellGenerator;
import com.backwardsnode.skygrid.generator.CactusGenerator;
import com.backwardsnode.skygrid.generator.FarmlandGenerator;
import com.backwardsnode.skygrid.generator.FloraGenerator;
import com.backwardsnode.skygrid.generator.LanternGenerator;
import com.backwardsnode.skygrid.generator.SugarCaneGenerator;
import com.backwardsnode.skygrid.weight.AlphaWeight;
import com.google.gson.Gson;


/**
 * The main generator for SkyGrid
 * @author BackwardsNode
 *
 */
public class SkyGridGenerator extends ChunkGenerator {

	public static final int MIN_VERSION = 1;
	/**
	 * The y-value to start generation from
	 */
	public static final int BOTTOM = 3;
	/**
	 * The maximum y-value for generation
	 */
	public static final int TOP = 250;
	/**
	 * The minimum distance between block placements
	 */
	public static final int MIN_DELTA = 3;
	/**
	 * The default distance between block placements
	 */
	public static final int DEFAULT_DELTA = 5;
	
	private int delta = -1;
	private BlockFilter filter;
	private BlockWeight weight;
	private List<BlockAttemptGenerator> generators;
	
	private FilterConfig secondPass;
	private final WeightedList<Material> materialSelection;
	
	/**
	 * Creates a new Sky Grid Generator
	 * @param instance The SkyGrid plugin
	 * @param id Name of configuration file, given as '#Name'
	 */
	public SkyGridGenerator(Plugin instance, String id) {
		generators = new ArrayList<BlockAttemptGenerator>();
		
		boolean loaded = false;
		if (id != null && id.startsWith("#")) {
			instance.getLogger().info("ID provided, loading configuration from " + id);
			loaded = loadConfiguration(instance, id.substring(1));
		}
		if (!loaded) {
			instance.getLogger().info("Using default settings: Alpha");
			delta = 5;
			filter = new AlphaFilter();
			weight = new AlphaWeight();
			
			generators.add(new FarmlandGenerator());
			generators.add(new CactusGenerator());
			generators.add(new SugarCaneGenerator());
			generators.add(new BambooGenerator());
			generators.add(new BellGenerator());
			generators.add(new FloraGenerator());
			generators.add(new LanternGenerator());
		}
		
		materialSelection = new WeightedList<Material>(filter.estimatedSelectionSize());
		if (secondPass == null) {
			for (Material mat : Material.values()) {
				if (filter.includeMaterial(mat)) {
					materialSelection.add(mat, weight.getWeight(mat));
				}
			}
		} else {
			for (Material mat : Material.values()) {
				if (filter.includeMaterial(mat) && !secondPass.exclusionList.contains(mat.toString())) {
					materialSelection.add(mat, weight.getWeight(mat));
				} else if (mat.isBlock() && secondPass.inclusionList.contains(mat.toString())) {
					materialSelection.add(mat, weight.getWeight(mat));
				}
			}
		}
		instance.getLogger().info("Material selection size: " + materialSelection.size());
	}
	
	private boolean loadConfiguration(Plugin instance, String fileName) {
		File file = new File(instance.getDataFolder(), fileName.endsWith(".json") ? fileName : fileName + ".json");
		fileName = file.getName();
		if (!file.exists()) {
			instance.getLogger().warning("Could not load generator config for file " + fileName + " - The file does not exist");
			return false;
		}
		
		boolean success = false;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			GeneratorConfig config = new Gson().fromJson(fr, GeneratorConfig.class);
			if (config.version < MIN_VERSION) {
				instance.getLogger().warning("The configuration for " + fileName + " is outdated: " + config.version + "<" + MIN_VERSION);
			} else {
				delta = config.delta;
				if (delta < MIN_DELTA) {
					instance.getLogger().warning("The configuration delta value is too small, setting to " + MIN_DELTA);
					delta = DEFAULT_DELTA;
				}
				filter = createInstance(BlockFilter.class, config.filter.filterClass);
				weight = createInstance(BlockWeight.class, config.weight.weightClass);
				
				if (filter != null && weight != null) {
					if (!config.filter.exclusionList.isEmpty() || !config.filter.inclusionList.isEmpty()) {
						secondPass = config.filter;
					} else {
						secondPass = null;
					}
					BlockAttemptGenerator bag = null;
					for (String genClassName : config.blockAttemptGenerators) {
						bag = createInstance(BlockAttemptGenerator.class, genClassName);
						if (bag == null) {
							instance.getLogger().warning("Could not load generator class " + genClassName);
						} else {
							generators.add(bag);
						}
					}
					success = true;
				} else {
					instance.getLogger().warning("The configuration has an invalid filter/weight class path set");
				}
			}
			
		} catch (FileNotFoundException e) {
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {}
			}
		}
		return success;
	}
	
	private <T> T createInstance(Class<T> type, String className) {
		if (type == null || className == null) {
			return null;
		}
		try {
			Class<?> clazz = Class.forName(className);
			Object o = clazz.getConstructor().newInstance();
			if (type.isInstance(o)) {
				return type.cast(o);
			}
			
		} catch (Exception e) { }
		return null;
	}
	
	@Override
	public boolean canSpawn(World world, int x, int z) {
		return super.canSpawn(world, x, z);
	}
	
	@Override
	public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
		ChunkData chunk = createChunkData(world);
		
		int aX = (delta - (x % delta)) % delta;
		int aZ = (delta - (z % delta)) % delta;
		
		boolean setTop, setSide, setN, setE, setS, setW, setBottom;
		
		BlockData bd;
		Material mat;
		for (int kX = aX; kX < 16; kX += delta) {
			for (int kY = BOTTOM; kY < TOP; kY += delta) {
				for (int kZ = aZ; kZ < 16; kZ += delta) {
					setTop = setSide = setN = setE = setS = setW = setBottom = false;
					mat = materialSelection.getRandom(random);
					bd = Bukkit.createBlockData(mat);
					/*
					 * BlockData modifiers
					 */
					if (bd instanceof Stairs) {
						((Stairs)bd).setFacing(getRandomFacing(random));
					}
					
					chunk.setBlock(kX, kY, kZ, bd);
					
					/*
					 * BlockState modifiers
					 */
					
					// TODO currently causes circular crashes internally, likely because chunk isn't ready yet
					/*if (mat == Material.SPAWNER) {
						Block b = world.getBlockAt(kX, kY, kZ);
						CreatureSpawner cs = (CreatureSpawner) b.getState();
						cs.setSpawnedType(EntityType.MUSHROOM_COW);
						cs.update();
					}*/
					
					/*
					 * Start Other Generation
					 */
					for (BlockAttemptGenerator bag : generators) {
						if (bag.canGenerateOn(bd)) {
							switch (bag.getGenerateCondition()) {
							case BOTTOM:
								if (!setBottom) {
									if (bag.getGeneratorChance() < random.nextDouble()) break;
									chunk.setBlock(kX, kY - 1, kZ, bag.getBlockData(bd, random));
									setBottom = true;
								}
								break;
							case SIDE:
								if (!setSide) {
									if (bag.getGeneratorChance() < random.nextDouble()) break;
									setSide = true;
									// Not yet implemented
								}
								break;
							case SIDE_MULTI:
								if (!setSide) {
									if (bag.getGeneratorChance() < random.nextDouble()) break;
									setSide = true;
									// Not yet implemented
								}
								break;
							case TOP:
								if (!setTop) {
									if (bag.getGeneratorChance() < random.nextDouble()) break;
									chunk.setBlock(kX, kY + 1, kZ, bag.getBlockData(bd, random));
									setTop = true;
								}
								break;
							}
						}
					}
					/*
					 * End Other Generation
					 */
				}
			}
		}
		
		return chunk;
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return super.getDefaultPopulators(world);
	}
	
	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		double rX = (random.nextInt(7) - 3) * delta;
		double rY = delta * (random.nextInt(20) + 10) + BOTTOM + 1;
		double rZ = (random.nextInt(7) - 3) * delta;
		return new Location(world, rX + 0.5, rY, rZ + 0.5);
	}
	
	@Override
	public boolean isParallelCapable() {
		return true;
	}
	
	@Override
	public boolean shouldGenerateCaves() {
		return false;
	}
	
	@Override
	public boolean shouldGenerateMobs() {
		return true;
	}
	
	@Override
	public boolean shouldGenerateDecorations() {
		return false;
	}
	
	@Override
	public boolean shouldGenerateStructures() {
		return false;
	}
	
	public static BlockFace getRandomFacing(Random randomSource) {
		switch (randomSource.nextInt(4)) {
		case 0:
			return BlockFace.NORTH;
		case 1:
			return BlockFace.EAST;
		case 2:
			return BlockFace.SOUTH;
		default:
			return BlockFace.WEST;
		}
	}
}
