package Chap15;

import java.util.Arrays;

public class Q07 {
	public int findMin(int[] a1, int[] a2, int[] a3) {
		if (a1 == null || a2 == null || a3 == null | a1.length == 0 || a2.length == 0 || a3.length == 0)
			return -1;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		int result = Integer.MAX_VALUE;
		
		while (true) {
			
			if (a1[i] == a2[j] && a2[j] == a3[k])
				return 0;
			
			int tmp = maxDistance(a1[i], a2[j], a3[k]);
			if (result > tmp)
				result = tmp;
					
			if (a1[i] <= Math.min(a2[j], a3[k]) && i < a1.length - 1)
				i ++;
			else if (a2[j] <= Math.min(a1[i], a3[k]) && j < a2.length - 1)
				j ++;
			else if (a3[k] <= Math.min(a1[i], a2[j]) && k < a3.length - 1)
				k ++;
			else
				break;
		}
		
		return result;
	}
	
	private int maxDistance(int a, int b, int c) {
		int[] array = {a, b, c};
		Arrays.sort(array);
		return Math.abs(array[0] - array[2]);
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 4, 5, 8};
		int[] a2 = {2, 3, 4, 5};
		int[] a3 = {0, 2, 7, 9};
		
		System.out.println(new Q07().findMin(a1, a2, a3));
		
	}
}
