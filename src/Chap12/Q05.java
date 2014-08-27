package Chap12;

public class Q05 {
	int findIndexOfValue(int[] array, int val) {
		if (array == null)
			return -1;
		
		int i = 0;
		while (true) {
			try {
				int tmpIndex = (1 << i) - 1;
				int tmp = array[tmpIndex];
				if (tmp == val)
					return tmpIndex;
				else if (tmp > val)
					break;
				i ++;
			} catch (Exception e) {
				break;
			}
		}
		
		if (i == 0)
			return -1;
		
		int start = (1 << (i - 1)) - 1;
		int end = (1 << i);
		int mid = 0;
		while (start < end) {
			try {
				mid = (end - start) / 2 + start;
				if (array[mid] == val)
					return mid;
				else if (array[start] == val)
					return start;
					
				if (array[mid] > val)
					end = mid;
				else
					start = mid;
			}
			catch (Exception e) {
				end = mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 6, 8, 10};
		int val = 10;
		
		System.out.println(new Q05().findIndexOfValue(array, val));
	}
}
