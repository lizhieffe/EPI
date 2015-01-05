package Chap21;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q02StringDistanceHelper {
	
	int[][] dp;
	
	public int calculateDistance(String dest, String s) {
		if (dest.equalsIgnoreCase(s))
			return 0;
		char[] cDest = dest.toCharArray();
		char[] cS = s.toCharArray();
		dp = new int[dest.length()][s.length()];
		for (int i = 0; i < dest.length(); i++)
			for (int j = 0; j < s.length(); j++)
				dp[i][j] = -1;
		return calculateDistance(cDest, cS, 0, 0);
	}
	
	private int calculateDistance(char[] dest, char[] c, int begDest, int begC) {
		if (begDest >= dest.length)
			return c.length - begC;
		if (begC >= c.length)
			return dest.length - begDest;
		if (dp[begDest][begC] != -1)
			return dp[begDest][begC];
		int result = -1;
		if (dest[begDest] == c[begC]) {
			result = calculateDistance(dest, c, begDest + 1, begC + 1);
		}
		else {
			int min = Integer.MAX_VALUE;
			min = Math.min(calculateDistance(dest, c, begDest + 1, begC) + 1, min);
			min = Math.min(calculateDistance(dest, c, begDest, begC + 1) + 1, min);
			min = Math.min(calculateDistance(dest, c, begDest + 1, begC + 1) + 1, min);
			result = min;
		}
		dp[begDest][begC] = result;
		return result;
	}
	
	@Test
	public void tc1() {
		String s1 = "abcd";
		String s2 = "aged";
		assertTrue(calculateDistance(s1, s2) == 2);
	}
}
