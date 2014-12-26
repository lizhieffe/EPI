package Chap11;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q07 {
	public int[] getMinBonus(int[] lines) {
		if (lines == null || lines.length == 0)
			return new int[0];
		int[] result = new int[lines.length];
		result[0] = 1;
		result[result.length - 1] = 1;
		for (int i = 1; i < result.length; i ++)
			if (lines[i] > lines[i - 1])
				result[i] = result[i - 1] + 1;
		for (int i = result.length - 2; i >= 0; i --)
			if (lines[i] > lines[i + 1] && result[i] <= result[i + 1])
				result[i] = result[i + 1] + 1;
		return result;
	}
	
	@Test
	public void testcase1() {
		int[] lines = {1, 2, 5, 4, 3, 2, 1};
		int[] result = new Q07().getMinBonus(lines);
		assertTrue(result[0] == 1);
		assertTrue(result[2] == 5);
		assertTrue(result[1] == 2);
	}
}
