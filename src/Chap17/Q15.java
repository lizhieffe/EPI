package Chap17;

public class Q15 {
	
	int[] coins;
	int[][] table;
	int[][] sumTable;
	
	int getMaxProfit(int[] coins) {
		
		if (coins == null || coins.length == 0 || coins.length % 2 == 1)
			return -1;
		this.coins = coins;
		this.table = new int[coins.length][coins.length + 1];
		this.sumTable = new int[coins.length][coins.length + 1];

		return get(0, coins.length);
	}
	
	private int get(int beg, int end) {
		if (beg == end - 1)
			return coins[beg];
		if (beg == end - 2)
			return Math.max(coins[beg], coins[end - 1]);
		
		if (table[beg][end] != 0)
			return table[beg][end];
		
		int result = Math.max(sum(beg, end) - get(beg + 1, end), sum(beg, end) - get(beg, end - 1));
		table[beg][end] = result;
		return result;
	}
	
	private int sum(int beg, int end) {
		if (beg == end)
			return 0;
		
		if (sumTable[beg][end] != 0)
			return sumTable[beg][end];
		
		int result = 0;
		result = sum(beg, end - 1) + coins[end - 1];
		sumTable[beg][end] = result;
		return result;
	}
	
	public static void main(String[] args) {
		int[] coins = {25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10};
		System.out.println(new Q15().getMaxProfit(coins));
	}
}
