package Chap17;

public class Q05 {

	int[][] fishes;
	int[][] table;

	public int maxFish(int[][] fishes) {
		
		if (fishes == null || fishes.length == 0 || fishes[0].length == 0)
			return 0;
		
		this.fishes = fishes;
		table = new int[fishes.length][fishes[0].length];
		for (int i = 0; i < fishes.length; i ++)
			for (int j = 0; j < fishes[0].length; j ++)
				table[i][j] = -1;
		
		return max(0, 0);
	}
	
	private int max(int m, int n) {
		if (m >= fishes.length || n >= fishes[0].length)
			return 0;
		
		if (table[m][n] != -1)
			return table[m][n];
		
		int result = fishes[m][n] + Math.max(max(m + 1, n), max(m, n + 1));
		table[m][n] = result;
		return result;
	}
	
	public static void main(String[] args) {
		int[][] fishes = {{1, 3, 5}, {0, 2, 6}, {1, 1, 4}};

		System.out.println(new Q05().maxFish(fishes));
	}
}
