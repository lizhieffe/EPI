package Chap12;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q09 {
	public static boolean search2DSortedMatrix(int val, int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int i = matrix.length - 1;
		int j = 0;
		while (true) {
			if (matrix[i][j] == val)
				return true;
			else if (matrix[i][j] < val && j < matrix[0].length - 1)
				j++;
			else if (matrix[i][j] > val && i > 0)
				i--;
			else
				return false;
		}
	}
	
	@Test
	public void testcase1() {
		int[][] matrix = {{1,2,3},{2,3,5},{4,6,9}};
		assertTrue(search2DSortedMatrix(3, matrix) == true);
		assertTrue(search2DSortedMatrix(7, matrix) == false);
	}
}
