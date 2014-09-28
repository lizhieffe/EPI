package Chap19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q10 {
	
	int[] shortestDistance;
	int[] predecessor;
	
	public List<Integer> findShortestPath(int[][] neighbors, int beg, int end) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (neighbors.length == 0 || neighbors[0].length == 0)
			return result;
		
		if (beg == end) {
			result.add(beg);
			result.add(end);
			return result;
		}
		
		shortestDistance = new int[neighbors.length];
		predecessor = new int[neighbors.length];
		PriorityQueue<Distance> priorityQueue 
				= new PriorityQueue<Distance>(neighbors.length, new DistanceComparator());
		for (int i = 0; i < neighbors.length; i++) {
			shortestDistance[i] = Integer.MAX_VALUE;
			if (i != beg)
				priorityQueue.add(new Distance(i, shortestDistance[i]));
		}
		shortestDistance[beg] = 0;
		predecessor[beg] = beg;
		priorityQueue.add(new Distance(beg, 0));

		while (priorityQueue.size() > 0) {
			Distance tmp = priorityQueue.poll();
			int cId = tmp.id;
			int cDistance = tmp.distance;
			if (cDistance == Integer.MAX_VALUE)
				break;
			
			for (int i = 0; i < neighbors[0].length; i ++) {
				if (i == cId)
					continue;
				
				int neighborId = i;
				int localDistance = neighbors[cId][neighborId];
				if (neighborId >= 0 && localDistance >= 0 && shortestDistance[neighborId] 
						> shortestDistance[cId] + localDistance) {
					priorityQueue.remove(new Distance(neighborId, shortestDistance[neighborId]));
					shortestDistance[neighborId] 
							= shortestDistance[cId] + localDistance;
					predecessor[neighborId] = cId;
					priorityQueue.add(new Distance(neighborId, shortestDistance[neighborId]));
				}
			}
		}
		
		if (shortestDistance[end] == Integer.MAX_VALUE)
			return result;
		else {
			result.add(0, end);
			int tmp = predecessor[end];
			while (tmp != beg) {
				result.add(0, tmp);
				tmp = predecessor[tmp];
			}
			result.add(0, tmp);
			return result;
		}
	}
	
	public static void main(String[] args) {
		int[][] neighbors = {{-1, 10, -1, 5, -1},
				{-1, -1, 1, 2, -1},
				{-1, -1, -1, -1, 4},
				{-1, 3, 9, -1, 2},
				{7, -1, 6, -1, -1}
		};
		int beg = 0;
		int end = 2;
		new Q10().findShortestPath(neighbors, beg, end);
	}
}
