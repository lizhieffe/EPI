package Chap18;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q14 {
	public static int findMaxAreaRetangle(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int result = Integer.MIN_VALUE;
		List<Integer> height = new ArrayList<Integer>();
		List<Integer> position = new ArrayList<Integer>();
		height.add(0);
		position.add(-1);
		for (int i = 0; i < array.length + 1; i++) {
			int pos = i;
			int h = 0;
			if (i != array.length)
				h = array[i];
			while (height.get(height.size() - 1) > h) {
				int tmp = (i - position.remove(position.size() - 1))
						* height.remove(height.size() - 1);
				if (tmp > result)
					result = tmp;
			}
			height.add(h);
			position.add(pos);
		}
		return result;
	}
	
	@Test
	public void testcase1() {
		int[] array = {1,2,3,1,0,5,7,9,8,4};
		assertTrue(findMaxAreaRetangle(array) == 21);
	}
}
