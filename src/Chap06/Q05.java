package Chap06;

public class Q05 {
	public int[] deleteKey(int[] array, int key) {
		if (array == null || array.length == 0)
			return array;
		
		int j = 0;
		for (int i = 0; i < array.length; i ++) {
			if (array[i] != key) {
				if (i != j)
					array[j] = array[i];
				j ++;
			}
		}
		
		for (int i = j; i < array.length; i ++)
			array[i] = 0;
		
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 4, 7, 3, 8, 12, 3, 53, 3};
		int key = 3;
		Q05 service = new Q05();
		System.out.println(service.deleteKey(array, key));
	}
}
