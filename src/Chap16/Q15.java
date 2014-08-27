package Chap16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q15 {
	public int[] getSkyline(LinkedList<Building> buildings) {
		
		if (buildings == null || buildings.size() == 0)
			return new int[0];
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		Collections.sort(buildings, new BuildingStartComparator());
		
		PriorityQueue<Building> ongoingBuildings = new PriorityQueue<Building>(buildings.size(), new BuildingHeightComparator());
		
		int i = 0;
		while (buildings.size() > 0 || ongoingBuildings.size() > 0) {
			while (buildings.size() > 0 && buildings.get(0).start == i)
				ongoingBuildings.add(buildings.remove(0));
			
			while (ongoingBuildings.size() > 0 && ongoingBuildings.peek().end <= i) {
				ongoingBuildings.poll();
			}
			
			if (ongoingBuildings.size() > 0)
				results.add(ongoingBuildings.peek().height);
			else if (buildings.size() > 0) // 0 height if no building
				results.add(0);
			
			i ++;
		}
		
		int[] output = new int[results.size()];
		for (int j = 0; j < results.size(); j ++)
			output[j] = results.get(j);
		
		return output;
	}
	
	private class BuildingStartComparator implements Comparator <Building> {

		@Override
		public int compare(Building arg0, Building arg1) {
			if (arg0.start < arg1.start)
				return -1;
			else if (arg0.start == arg1.start)
				return 0;
			else
				return 1;
		}
		
	}
	
	private class BuildingHeightComparator implements Comparator <Building> {
		@Override
		public int compare(Building arg0, Building arg1) {
			if (arg0.height < arg1.height)
				return 1;
			else if (arg0.height == arg1.height)
				return 0;
			else
				return -1;
		}
	}
	
	public static void main(String[] args) {
		Building b0 = new Building(0, 5, 2);
		Building b1 = new Building(2, 7, 3);
		Building b2 = new Building(1, 3, 4);
		Building b3 = new Building(10, 15, 2);
		Building b4 = new Building(0, 5, 2);
		Building b5 = new Building(0, 5, 2);
		LinkedList<Building> buildings = new LinkedList<Building>();
		buildings.add(b0);
		buildings.add(b1);
		buildings.add(b2);
		buildings.add(b3);
		buildings.add(b4);
		buildings.add(b5);

		System.out.println(new Q15().getSkyline(buildings));
	}
}
