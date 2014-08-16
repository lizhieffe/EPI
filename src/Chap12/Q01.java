package Chap12;

public class Q01 {
	int[] array;
	int findIndex(int[] array, int val) {
		if (array == null || array.length <= 0)
			return -1;
		
		this.array = array;
		return find(0, array.length, val);
	}
	
	private int find(int start, int end, int val) {
		if (start > end)
			return -1;
		if (start == end - 1)
			return array[start] == val ? start : -1;
		
		int mid = (end - start) / 2 + start;
		if (val == array[start])
			return start;
		else if (val == array[end - 1])
			return end - 1;
		else {
			int tmp = find(start, mid, val);
			if (tmp != -1)
				return tmp;
			
			tmp = find(mid, end, val);
			if (tmp != -1)
				return tmp;
			
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 158, 222};
		int val = 158;
		
		Q01 service = new Q01();
		System.out.println(service.findIndex(array, val));
	}
}
