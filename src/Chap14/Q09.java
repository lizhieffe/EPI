package Chap14;

import java.util.Arrays;

public class Q09 {
	public int getOptimal(int[] array) {
		if (array == null || array.length % 2 != 0)
			return -1;
		Arrays.sort(array);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int val = array[i] + array[array.length - 1 - i];
			if (max < val)
				max = val;
		}
		return max;
	}
}
