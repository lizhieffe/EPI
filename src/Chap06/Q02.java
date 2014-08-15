package Chap06;

public class Q02 {
	public int[] increase(int[] array) {
		if (array == null || array.length == 0)
			return array;
		
		array[array.length - 1] ++;
		
		for (int i = array.length - 2; i >= 0 && array[i + 1] == 10; i --) {
			array[i + 1] = 0;
			array[i] ++;
		}
		
		if (array[0] == 10) {
			array[0] = 0;
			
			int[] newArray = new int[array.length + 1];
			newArray[0] = 1;
			for (int i = 0; i < array.length; i ++)
				newArray[1 + i] = array[i];
			array = newArray;
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {9, 8, 9};
		
		Q02 service = new Q02();
		array = service.increase(array);
		System.out.println(array);
	}
}
