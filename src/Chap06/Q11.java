package Chap06;

public class Q11 {
	public int[] getLongestContiguousIncreasingSubstring(int[] array) {
		if (array == null || array.length < 2)
			return array;
		
		int beg = 0;
		int end = 1;
		int tmpBeg = 0;
		int tmpEnd = 1;
		int cValue = array[0];

		for (int i = 1; i < array.length; i ++) {
			if (cValue < array[i]) {
				cValue = array[i];
				tmpEnd ++;
			}
			else {
				if (tmpEnd - tmpBeg > end - beg) {
					end = tmpEnd;
					beg = tmpBeg;
				}
				tmpBeg = i;
				tmpEnd = i + 1;
				cValue = array[i];
			}
		}
		
		if (tmpEnd - tmpBeg > end - beg) {
			end = tmpEnd;
			beg = tmpBeg;
		}
		
		int[] result = new int[end - beg];
		for (int i = 0; i < end - beg; i ++)
			result[i] = array[i + beg];
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {2, 11, 3, 5, 13, 7, 19, 17, 23};
		System.out.println(new Q11().getLongestContiguousIncreasingSubstring(array));
	}
}
