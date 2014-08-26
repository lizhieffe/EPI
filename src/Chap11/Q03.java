package Chap11;

import java.util.PriorityQueue;

public class Q03 {
	public void sort(int[] array, int k) {
		if (array == null || array.length <= 1)
			return;
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for (int i = 0; i < Math.min(k, array.length); i ++)
			heap.add(array[i]);
		
		int j = 0;
		if (array.length > k) {
			for (int i = 0; i < array.length - k; i ++) {
				array[i] = heap.poll();
				heap.add(array[k + i]);
				j ++;
			}
		}
		
		for (int i = 0; i < Math.min(k, array.length); i ++)
			array[i + j] = heap.poll();
	}
	
	public static void main(String[] args) {
		int[] array = {3, 1, 4, 2, 6, 5, 8, 7};
		int k = 3;
		new Q03().sort(array, k);
		System.out.println();
	}
}
