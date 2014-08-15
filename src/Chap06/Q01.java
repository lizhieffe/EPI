package Chap06;

public class Q01 {

	public void sort(int[] array, int i) {
		if (array == null || array.length <= 1 || i < 0 || i >= array.length)
			return;
		
		int numSame = 1;
		int boundary = 0;
		int standard = array[i];
		
		swap(array, i, array.length - 1);
		for (int j = 0; j < array.length - numSame; j ++) {
			if (array[j] < standard)
				swap(array, j, boundary ++);
			else if (array[j] == standard)
				swap(array, j --, array.length - 1 - numSame ++);
		}
		
		for (int j = 0; j < numSame; j ++)
			swap(array, array.length - 1 - j, boundary + j);
	}
	
	private void swap(int[] array, int i, int j) {
		if (array == null || array.length <= 1 || i < 0 || i >= array.length
				|| j < 0 || j >= array.length || i == j)
			return;
		
		int val = array[i];
		array[i] = array[j];
		array[j] = val;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		int i = 5;
		
		Q01 service = new Q01();
		service.sort(array, i);
		System.out.println(array);
	}
}
