package Chap06;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q07 {
	public static int findFristMissingPositive(int[] array) {
		if (array == null || array.length == 0)
			return 1;
		for (int i = 0; i < array.length; i++) {
			while (array[i] != i + 1 && array[i] >= 1 && array[i] <= array.length && array[array[i] - 1] != array[i] - 1) {
				int tmp = array[i];
				array[i] = array[tmp - 1];
				array[tmp - 1] = tmp;
			}
		}
		for (int i = 0; i < array.length; i++)
			if (array[i] != i + 1)
				return i + 1;
		return array.length + 1;
	}
	
	@Test
	public void tc1() {
		int[] array = {3, 7, 1, 0, 2, 5, 10};
		assertTrue(findFristMissingPositive(array) == 4);
	}
}
