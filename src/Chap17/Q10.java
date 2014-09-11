package Chap17;

public class Q10 {
	int[][] table;
	int[] array;
	
	public int divide(int[] array) {
		int sum = 0;
		if (array == null || array.length <= 1)
			return 0;
		
		for (int i = 0; i < array.length; i ++)
			sum += array[i];
		
		int ave = sum / 2;
		table = new int[array.length][ave + 1];
		for (int i = 0; i < table.length; i ++)
			for (int j = 0; j < table[0].length; j ++)
				table[i][j] = -1;
		
		this.array = array;
		
		return max(0, ave);
	}
	
	private int max(int beg, int limit) {
		if (beg >= array.length || limit <= 0)
			return 0;
		
		if (table[beg][limit] != -1)
			return table[beg][limit];
		
		int max = 0;
		
		for (int i = beg; i < array.length; i ++) {
			if (array[i] == limit)
				return limit;
			else if (array[i] < limit) {
				int tmp = array[i] + max(i + 1, limit - array[i]);
				if (max < tmp)
					max = tmp;
			}
		}
		
		table[beg][limit] = max;
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9};
		System.out.println(new Q10().divide(array));
	}
}
