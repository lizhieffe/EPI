package Chap17;

public class Q18 {
	int[] memory;
	
	public int getNumOfWays(int n, int k) {
		if (n <= 0 || k <= 0)
			return 0;
		
		memory = new int[n + 1];
		
		return get(n, k);
	}
	
	private int get(int n, int k) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		
		if (memory[n] != 0)
			return memory[n];
		
		int result = 0;
		for (int i = 0; i < k; i ++)
			result = result + get(n - i - 1, k);
		memory[n] = result;
		
		return result;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(new Q18().getNumOfWays(n, k));
	}
}
