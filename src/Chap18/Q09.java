package Chap18;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q09 {
	public int findMostAppearanceElement(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		int val = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				val = array[i];
				count++;
			}
			else {
				if (val == array[i])
					count++;
				else
					count--;
			}
		}
		return val;
	}
	
	@Test
	public void tc1() {
		int[] array = {1,2,3,4,1,2,5,6,7,1,3,1,1,1,1,1,1};
		assertTrue(new Q09().findMostAppearanceElement(array) == 1);
	}
}
