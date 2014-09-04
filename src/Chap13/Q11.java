package Chap13;

import java.util.HashMap;

public class Q11 {
	public int findLongestNoneDuplicate(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int longest = 0;
		int tmp = 0;
		
		for (int i = 0; i < array.length; i ++) {
			if (i == array.length - 1 && hash.containsKey(array[i]))
				longest = Math.max(longest, tmp);
			else if (i == array.length - 1)
				longest = Math.max(longest, tmp + 1);
			else {
				if (!hash.containsKey(array[i])) {
					hash.put(array[i], i);
					tmp ++;
				}
				else {
					longest = Math.max(longest, tmp);
					tmp = i - hash.get(array[i]);
					int beg = hash.get(array[i]) + 1;
					hash.clear();
					for (int j = beg; j <= i; j ++)
						hash.put(array[j], j);
				}
			}
		}
		
		return longest;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 1, 3};
		System.out.println(new Q11().findLongestNoneDuplicate(array));
		
	}
}
