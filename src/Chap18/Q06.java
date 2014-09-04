package Chap18;

import java.util.Arrays;

public class Q06 {
	public boolean threeSum(int[] array, int val) {
		if (array == null || array.length <= 2)
			return false;
		
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i ++) {
			if (twoSum(array, val - array[i], i + 1))
				return true;
		}
		
		return false;
	}
	
	private boolean twoSum(int[] array, int val, int beg) {
		int end = array.length - 1;
		while (beg < end) {
			int tmp = array[beg] + array[end];
			if (tmp == val)
				return true;
			else if (tmp > val)
				end --;
			else
				beg ++;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 0, -1, -4, 4};
		int val = 15;
		System.out.println(new Q06().threeSum(array, val));
	}
}
