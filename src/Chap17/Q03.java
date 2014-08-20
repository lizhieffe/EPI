package Chap17;

public class Q03 {
	int[] table;
	
	public int calculateBinomialCoefficients(int m, int n) {
		if (m <= 0 || n <= 0 || m < n)
			return -1;
		
		if (m == n)
			return 1;
		
		table = new int[n];
		for (int i = 0; i < m; i ++) {
			for (int j = Math.min(i + 1, n) - 1; j >= Math.max(0, i - m + n); j --) {
//			for (int j = Math.max(0, i - m + n); j < Math.min(i + 1, n); j ++) {
				if (j == i)
					table[j] = 1;
				else if (j == 0)
					table[j] = i + 1;
				else
					table[j] = table[j - 1] + table[j];
			}
		}
		
		return table[n - 1];
	}
	
	public static void main(String[] args) {
		int m = 6;
		int n = 3;
		Q03 service = new Q03();
		System.out.println(service.calculateBinomialCoefficients(m, n));
	}
}
