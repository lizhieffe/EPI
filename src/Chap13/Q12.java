package Chap13;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Q12 {

	public int findMaxConsequtiveLength(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		Set<Integer> record = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++)
			record.add(array[i]);
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (!record.remove(array[i]))
				continue;
			int tmp = 1;
			int val = array[i] + 1;
			while (record.remove(val++))
				tmp++;
			val = array[i] - 1;
			while (record.remove(val--))
				tmp++;
			if (tmp > result)
				result = tmp;
		}
		return result;
	}
	
	@Test
	public void testcase1() {
		int[] array = {3, -2, 7, 9, 8, 1, 2, 0};
		Q12 testcase = new Q12();
		assertTrue(testcase.findMaxConsequtiveLength(array) == 4);
	}
}
