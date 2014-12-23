package Chap12;

import java.util.Random;

public class Q11 {
	public int findKthLargest(int[] array, int k) {
		if (array == null || k > array.length)
			return -1;
		return findKthLargest(array, k, 0, array.length - 1);
	}
	private int findKthLargest(int[] array, int k, int beg, int end) {
		if (k == 1) {
			int min = Integer.MAX_VALUE;
			for (int i = beg; i <= end; i++)
				if (array[i] < min)
					min = array[i];
			return min;
		}
		Random rand = new Random(47);
		int tmpRand = rand.nextInt(end - beg);
		swap(array, end, beg + tmpRand);
		int pivot = array[end];
		int mid = beg;
		for (int i = beg; i < end; i++) {
			if (array[i] > pivot)
				continue;
			else {
				int tmp = array[i];
				array[i] = array[mid];
				array[mid] = tmp;
				mid++;
			}
		}
		swap(array, end, mid);
		if (k == mid - beg + 1)
			return array[mid];
		if (k > mid - beg + 1)
			return findKthLargest(array, k - (mid - beg + 1), mid + 1, end);
		else
			return findKthLargest(array, k, beg, mid - 1);
	}
	private void swap(int[] array, int i, int j) {
		if (i != j) {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,2,4,6,8,10};
		System.out.println(new Q11().findKthLargest(array, 7));
	}
}
