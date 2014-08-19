package Chap12;

public class Q03 {
	int[] array;
	
	public int find(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		
		this.array = array;
		return find(0, array.length);
	}
	
	private int find(int start, int end) {
		if (start >= end || start >= array.length || end <= 0)
			return -1;
		
		if (end - start == 1)
			return array[start] == start ? start : -1;
		
		if (array[start] == start)
			return start;
		
		if (array[end - 1] == end - 1)
			return end - 1;
		
		int mid = start + (end - start) / 2;
		if (array[mid] == mid)
			return mid;
		else if (array[mid] < mid)
			return find(mid, end);
		else
			return find(start, mid);
	}
	
	public static void main(String[] args) {
		int[] array = {-1, 0, 1, 2, 4, 6, 8, 10};
		Q03 service = new Q03();
		System.out.print(service.find(array));
	}
}
