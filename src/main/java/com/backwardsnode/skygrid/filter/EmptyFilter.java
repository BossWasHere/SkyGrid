package com.backwardsnode.skygrid.filter;

import org.bukkit.Material;

import com.backwardsnode.skygrid.BlockFilter;

public class EmptyFilter implements BlockFilter {

	@Override
	public boolean includeMaterial(Material material) {
		return material.isBlock();
	}
}
