package Chap17;

import java.util.ArrayList;

public class Q14 {
	
	int[][] memory;
	ArrayList<int[]> input;
	
	public int findMaxWeightPath(ArrayList<int[]> input) {
		if (input == null || input.size() == 0)
			return 0;
		
		this.memory = new int[input.size()][input.size()];
		this.input = input;
		
		int max = 0;
		for (int i = 0; i < input.size(); i ++)
			max = Math.max(max, find(input.size() - 1, i));
		
		return max;
	}
	
	private int find(int m, int n) {
		if (m == 0 && n == 0)
			return input.get(m)[m];
		
		if (memory[m][n] != 0)
			return memory[m][n];
		
		int result = 0;
		if (n == 0)
			result = find(m - 1, n) + input.get(m)[n];
		else if (n == m)
			result = find(m - 1, n - 1) + input.get(m)[n];
		else
			result = Math.max(find(m - 1, n - 1), find(m - 1, n)) + input.get(m)[n];
		memory[m][n] = result;
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a0 = {1};
		int[] a1 = {4, 5};
		int[] a2 = {6, 7, 8};
		int[] a3 = {10, 9, 3, 5};
		ArrayList<int[]> input = new ArrayList<int[]>();
		input.add(a0);
		input.add(a1);
		input.add(a2);
		input.add(a3);
		
		System.out.println(new Q14().findMaxWeightPath(input));
		
	}
}
