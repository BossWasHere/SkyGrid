package com.backwardsnode.skygrid;

import static org.junit.jupiter.api.Assertions.*;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.generator.ChunkGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Plugin.class)
public class ConfigTest {

	private Logger logger;
	
	@Test
	void TestLoad() {
		final Plugin plugin = mock(Plugin.class);
		when(plugin.getLogger()).thenReturn(getLogger());

		File mockPluginDir = new File("src/test/resources");
		
		//getDataFolder() is final and PowerMockito doesn't work
		
		//suppress(methods(JavaPlugin.class, "getDataFolder"));
		//when(plugin.getDataFolder()).thenReturn(mockPluginDir);
		
		when(plugin.getConfigFolder()).thenReturn(mockPluginDir);
		
		SkyGridGenerator mockGenerator = new SkyGridGenerator(plugin, "#config.json");
		when(plugin.getDefaultWorldGenerator(null, null)).thenReturn(mockGenerator);
		
		ChunkGenerator cg = plugin.getDefaultWorldGenerator(null, null);
		assertTrue(cg instanceof SkyGridGenerator);
		
	}
	
	Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger(ConfigTest.class.getName());
		}
		return logger;
	}
}
