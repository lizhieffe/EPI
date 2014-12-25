package Chap19;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class Q08 {
	int[][] dpCanTakePhoto;
	
	public int maxNum(int[][] height) {
		if (height == null || height.length == 0 || height[0].length == 0)
			return 0;
		Arrays.sort(height, new Comparator<int[]>() {
			public int compare(int[] array1, int[] array2) {
				if (array1[0] > array2[0])
					return -1;
				if (array1[0] < array2[0])
					return 1;
				return 0;
			}
		});
		int result = 0;
		int[] dp = new int[height.length];
		for (int i = 0; i < height.length; i++)
			dp[i] = -1;
		dpCanTakePhoto = new int[height.length][height.length];
		for (int i = 0; i < height.length; i++)
			for (int j = 0; j < height.length; j++)
				dpCanTakePhoto[i][j] = -1;
		for (int i = 0; i < height.length; i++) {
			int tmp = maxNumWhenStartFrom(height, i, dp);
			if (result < tmp)
				result = tmp;
		}
		return result;
	}
	
	private int maxNumWhenStartFrom(int[][] height, int beg, int[] dp) {
		if (beg == height.length - 1)
			return 1;
		if (dp[beg] != -1)
			return dp[beg];
		int result = 1;
		for (int i = beg + 1; i < height.length; i++)
			if (canTakePhoto(height, beg, i)) {
				int tmp = maxNumWhenStartFrom(height, i, dp) + 1;
				if (result < tmp)
					result = tmp;
			}
		dp[beg] = result;
		return result;
	}
	
	private boolean canTakePhoto(int[][] height, int first, int second) {
		if (first == second)
			return false;
		if (dpCanTakePhoto[first][second] != -1)
			return dpCanTakePhoto[first][second] == 0 ? false : true;
		if (height[first][0] == height[second][0]) {
			dpCanTakePhoto[first][second] = 0;
			return false;
		}
		if (height[first][0] > height[second][0]) {
			int tmp = first;
			first = second;
			second = tmp;
		}
		for (int i = 0; i < height[0].length; i++)
			if (height[first][i] >= height[second][i]) {
				dpCanTakePhoto[first][second] = 0;
				return false;
			}
		dpCanTakePhoto[first][second] = 1;
		return true;
	}
	
	@Test
	public void testcase1() {
		int[][] height = new int[5][2];
		height[0][0] = 0;
		height[0][1] = 0;
		height[1][0] = 0;
		height[1][1] = 0;
		height[2][0] = 0;
		height[2][1] = 0;
		height[3][0] = 0;
		height[3][1] = 0;
		height[4][0] = 0;
		height[4][1] = 0;
		Q08 testcase = new Q08();
		int result = testcase.maxNum(height);
		assertTrue(result == 1);
	}
	
	@Test
	public void testcase2() {
		int[][] height = new int[5][2];
		height[0][0] = 0;
		height[0][1] = 0;
		height[1][0] = 1;
		height[1][1] = 1;
		height[2][0] = 2;
		height[2][1] = 2;
		height[3][0] = 3;
		height[3][1] = 3;
		height[4][0] = 4;
		height[4][1] = 4;
		Q08 testcase = new Q08();
		int result = testcase.maxNum(height);
		assertTrue(result == 5);
	}
	
	@Test
	public void testcase3() {
		int[][] height = new int[5][2];
		height[0][0] = 0;
		height[0][1] = 0;
		height[1][0] = 1;
		height[1][1] = 0;
		height[2][0] = 0;
		height[2][1] = 2;
		height[3][0] = 3;
		height[3][1] = 0;
		height[4][0] = 4;
		height[4][1] = 4;
		Q08 testcase = new Q08();
		int result = testcase.maxNum(height);
		assertTrue(result == 2);
	}
	
	@Test
	public void testcase4() {
		int[][] height = new int[3][2];
		height[0][0] = 1;
		height[0][1] = 0;
		height[1][0] = 4;
		height[1][1] = 4;
		height[2][0] = 3;
		height[2][1] = 0;
		
		Q08 testcase = new Q08();
		int result = testcase.maxNum(height);
		assertTrue(result == 2);
	}
}
