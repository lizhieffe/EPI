package Chap09;

import java.util.LinkedList;

public class Q08 {
	public int getNumSunset(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		if (height.length == 1)
			return 1;
		
		LinkedList<Integer> buildings = new LinkedList<Integer>();
		buildings.add(height[0]);
		
		for (int i = 1; i < height.length; i ++) {
			while (buildings.size() > 0 && height[i] >= buildings.getLast())
				buildings.removeLast();
			buildings.add(height[i]);
		}
		
		return buildings.size();
	}
	
	public static void main(String[] args) {
		int[] height = {8, 3, 4, 2, 7, 5, 2, 3, 1};
		System.out.println(new Q08().getNumSunset(height));
	}
}
