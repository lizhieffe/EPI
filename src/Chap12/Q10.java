package Chap12;

public class Q10 {
	public int[] findMaxNMin(int[] array) {
		int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		if (array == null || array.length == 0)
			return result;
		if (array.length == 1) {
			result[0] = array[0];
			result[1] = array[0];
			return result;
		}
		if (array.length == 2) {
			result[0] = array[0] < array[1] ? array[0] : array[1];
			result[1] = array[0] < array[1] ? array[1] : array[0];
			return result;
		}
		
		result[0] = array[0] < array[1] ? array[0] : array[1];
		result[1] = array[0] < array[1] ? array[1] : array[0];
		
		int i = 2;
		while (i < array.length) {
			int tmp1 = array[i];
			int tmp2 = i + 1 < array.length ? array[i + 1] : tmp1;
			boolean tmp1IsSmaller = tmp1 < tmp2;
			if (!tmp1IsSmaller) {
				int tmp = tmp1;
				tmp1 = tmp2;
				tmp2 = tmp;
			}
				
			if (result[0] > tmp1)
				result[0] = tmp1;
			if (result[1] < tmp2)
				result[1] = tmp2;
			
			i += 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 4, 8, 9, 102};
		System.out.println(new Q10().findMaxNMin(array));
	}
}
