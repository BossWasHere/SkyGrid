package com.backwardsnode.skygrid;

import org.bukkit.Material;

public interface BlockFilter {

	public boolean includeMaterial(Material material);
	default public int estimatedSelectionSize() {
		return 600;
	}
	
}
