package com.backwardsnode.skygrid.weight;

import org.bukkit.Material;

import com.backwardsnode.skygrid.BlockWeight;

public class UniformWeight implements BlockWeight {

	@Override
	public int getWeight(Material material) {
		return 1;
	}
	
}
