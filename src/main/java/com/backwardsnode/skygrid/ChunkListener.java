package com.backwardsnode.skygrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

public class ChunkListener implements Listener {

	private final Plugin INSTANCE;
	private static final List<EntityType> SPAWNABLE;
	
	static {
		SPAWNABLE = new ArrayList<EntityType>();
		for (EntityType et : EntityType.values()) {
			switch (et) {
			case AREA_EFFECT_CLOUD:
			case ARMOR_STAND:
			case ARROW:
			case BOAT:
			case DRAGON_FIREBALL:
			case DROPPED_ITEM:
			case EGG:
			case ENDER_CRYSTAL:
			case ENDER_DRAGON:
			case ENDER_PEARL:
			case ENDER_SIGNAL:
			case EVOKER_FANGS:
			case EXPERIENCE_ORB:
			case FALLING_BLOCK:
			case FIREBALL:
			case FIREWORK:
			case FISHING_HOOK:
			case ITEM_FRAME:
			case LEASH_HITCH:
			case LIGHTNING:
			case LLAMA_SPIT:
			case MINECART:
			case MINECART_CHEST:
			case MINECART_COMMAND:
			case MINECART_FURNACE:
			case MINECART_HOPPER:
			case MINECART_MOB_SPAWNER:
			case MINECART_TNT:
			case PAINTING:
			case PLAYER:
			case PRIMED_TNT:
			case SHULKER:
			case SHULKER_BULLET:
			case SMALL_FIREBALL:
			case SNOWBALL:
			case SPECTRAL_ARROW:
			case SPLASH_POTION:
			case THROWN_EXP_BOTTLE:
			case TRIDENT:
			case UNKNOWN:
			case WITHER:
			case WITHER_SKULL:
				continue;
			default:
				SPAWNABLE.add(et);
			}
		}
	}
	
	public ChunkListener(Plugin instance) {
		INSTANCE = instance;
	}
	
	@EventHandler
	public void onChunkPopulate(ChunkPopulateEvent e) {
		if (e.getWorld().getGenerator() instanceof SkyGridGenerator) {
			Random random = new Random();
			SkyGridGenerator generator = (SkyGridGenerator) e.getWorld().getGenerator();
			
			BlockState[] tiles = e.getChunk().getTileEntities();
			if (generator.doSpawnerRandomizing()) {
				for (BlockState tile : tiles) {
					if (tile instanceof CreatureSpawner) {
						CreatureSpawner cs = (CreatureSpawner) tile;
						cs.setSpawnedType(getRandomEntity(random));
						cs.update(true);
					}
				}
			}
		}
	}
	
	private static EntityType getRandomEntity(Random randomSource) {
		return SPAWNABLE.get(randomSource.nextInt(SPAWNABLE.size()));
	}
}
