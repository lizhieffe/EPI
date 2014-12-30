package Chap17;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q21 {
	public int findLongestNondecreasingSubsequence(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int[] dp = new int[array.length];
		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			int val = find(array, dp, i);
			if (val > result)
				result = val;
		}
		return result;
	}
	
	private int find(int[] array, int[] dp, int beg) {
		if (beg >= array.length)
			return 0;
		if (beg == array.length - 1)
			return 1;
		if (dp[beg] != -1)
			return dp[beg];
		int result = 0;
		for (int i = beg; i < array.length; i++) {
			if (array[i] > array[beg]) {
				int val = 1 + find(array, dp, i);
				if (val > result)
					result = val;
			}
		}
		dp[beg] = result;
		return result;
	}
	
	@Test
	public void tc1() {
		int[] array = {0,8,4,12,2,10,6,14,1,9};
		assertTrue(new Q21().findLongestNondecreasingSubsequence(array) == 4);
		
	}
}
