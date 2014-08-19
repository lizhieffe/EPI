package Chap12;

public class Q04 {
	int[] array;
	public int findMin(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		
		this.array = array;
		return find(0, array.length);
	}
	
	private int find(int start, int end) {
		if (start >= end || start >= array.length || end <= 0)
			return -1;
		
		if (end - start == 1)
			return start;
		
		if (end - start == 2)
			return array[start] < array[end - 1] ? start : end - 1;
		
		int mid = start + (end - start) / 2;
		if (array[start] < array[mid] && array[mid] < array[end - 1])
			return start;
		else if (array[mid] < array[end - 1] && array[mid] < array[mid - 1])
			return mid;
		else if (array[mid] < array[end - 1])
			return find(start, mid);
		else
			return find(mid, end);
	}
	
	public static void main(String[] args) {
		int[] array = {12, 15, 18, 20, 24, 26, 29,30,32, -1, 0, 1, 2, 4, 6, 8, 10};
		Q04 service = new Q04();
		System.out.print(service.findMin(array));
		
		
	}
}
