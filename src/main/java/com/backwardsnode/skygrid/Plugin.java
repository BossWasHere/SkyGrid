package com.backwardsnode.skygrid;

import java.util.logging.Level;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

	@Override
	public void onLoad() {
	}
	
	@Override
	public void onEnable() {
		getLogger().log(Level.INFO, "Enabled SkyGrid Chunk Generator");
	}
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new SkyGridGenerator(this, id);
	}
}
