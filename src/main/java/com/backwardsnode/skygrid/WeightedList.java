package com.backwardsnode.skygrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightedList<T> {

	private List<WeightedObject> entryList;
	private int totalWeight;
	
	public WeightedList() {
		entryList = new ArrayList<WeightedObject>();
		totalWeight = 0;
	}
	
	public WeightedList(int initialCapacity) {
		entryList = new ArrayList<WeightedObject>(initialCapacity);
		totalWeight = 0;
	}
	
	public boolean add(T object, int weight) {
		totalWeight += weight;
		return entryList.add(new WeightedObject(object, totalWeight));
	}

	public int size() {
		return entryList.size();
	}
	
	public T getRandom(Random randomSource) {
		int x = randomSource.nextInt(totalWeight);
		for (WeightedObject wo : entryList) {
			if (wo.minWeight > x) {
				return wo.object;
			}
		}
		return null;
	}
	
	private class WeightedObject {

		final T object;
		final int minWeight;
		
		WeightedObject(T object, int minWeight) {
			this.object = object;
			this.minWeight = minWeight;
		}
	}
}
