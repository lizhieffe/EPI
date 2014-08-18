package Chap12;

public class Q02 {
	int[] array;
	
	public int findFirstGreater(int[] array, int val) {
		if (array == null || array.length == 0 || val > array[array.length - 1])
			return -1;
		
		this.array = array;
		return find(0, array.length, val);
	}
	
	private int find(int start, int end, int val) {
		if (start >= end || start >= array.length 
				|| end <= 0 || val > array[end - 1])
			return -1;
		
		if (end - start == 1)
			return array[start] > val ? start : -1;
			
		if (end - start == 2) {
			if (array[start] > val)
				return start;
			else if (array[start + 1] > val)
				return start + 1;
			else
				return -1;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] > val)
			return find(start, mid + 1, val);
		else
			return find(mid + 1, end, val);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 15, 25, 35, 45, 55};
		int val = 444;
		
		Q02 service = new Q02();
		System.out.println(service.findFirstGreater(array, val));
	}
}
