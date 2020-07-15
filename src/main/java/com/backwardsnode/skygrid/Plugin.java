package com.backwardsnode.skygrid;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	private ChunkListener chunkListener;
	
	@Override
	public void onLoad() {
	}
	
	@Override
	public void onEnable() {
		getLogger().log(Level.INFO, "Enabled SkyGrid Chunk Generator");
		chunkListener = new ChunkListener(this);
		
		getServer().getPluginManager().registerEvents(chunkListener, this);
	}
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new SkyGridGenerator(this, id);
	}
	
	/*
	 * Unit test workaround
	 */
	public File getConfigFolder() {
		return getDataFolder();
	}
}
