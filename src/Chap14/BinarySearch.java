package Chap14;

public class BinarySearch {
	int[] array;
	
	public BinarySearch(int[] sortedArray) {
		this.array = sortedArray;
	}
	
	public int find(int val) {
		if (array == null || array.length == 0)
			return -1;
				
		return find(0, this.array.length, val);
	}
	
	private int find(int start, int end, int val) {
		if (start >= end || start >= end || end < 0) 
			return -1;
		
		if (array[start] > val || array[end - 1] < val)
			return -1;
		
		int mid = (end - start) / 2 + start;
		if (array[start] == val)
			return start;
		else if (array[end - 1] == val)
			return end - 1;
		else if (array[mid] == val)
			return mid;
		else if (array[mid] < val)
			return find(mid, end, val);
		else
			return find(start, mid, val);
	}
}
