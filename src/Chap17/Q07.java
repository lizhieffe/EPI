package Chap17;

import java.util.ArrayList;
import java.util.Arrays;

public class Q07 {
	
	ArrayList<Clock> clocks;
	int[][] results;
	
	public int getMaxValue (int weightLimit, ArrayList<Clock> clocks) {
		if (clocks == null || clocks.size() == 0 || weightLimit == 0)
			return 0;
		
		this.clocks = clocks;
		results = new int[clocks.size()][weightLimit + 1];
		for (int i = 0; i < clocks.size(); i ++)
			for (int j = 0; j < weightLimit + 1; j ++)
				results[i][j] = -1;
		
		return max(0, weightLimit, 0);
	}
	
	private int max (int start, int weightLimit, int cValue) {
		if (start >= clocks.size() || weightLimit <= 0)
			return cValue;
					
		if (results[start][weightLimit] != -1)
			return results[start][weightLimit];
		
		int result;
		if (weightLimit >= clocks.get(start).weight)
			result = Math.max(max(start + 1, weightLimit, cValue)
					, max(start + 1, weightLimit - clocks.get(start).weight
					, cValue + clocks.get(start).value));
		else
			result = max(start + 1, weightLimit, cValue);
		
		
		results[start][weightLimit] = result;
		return result;
	}
	
	public static void main(String[] args) {
		Clock c1 = new Clock(8, 7);
		Clock c2 = new Clock(7, 5);
		Clock c3 = new Clock(3, 10);
		Clock[] c = {c1, c2, c3};
		ArrayList<Clock> clocks = new ArrayList<Clock>(Arrays.asList(c));
		Q07 service = new Q07();
		
		System.out.println(service.getMaxValue(11, clocks));
	}
}
