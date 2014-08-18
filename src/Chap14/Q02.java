package Chap14;

public class Q02 {
	public int[] sort2Arrays(int[] a1, int length1, int[] a2, int length2) {
		if (a1 == null || a2 == null)
			return null;
		
		int i = 0;
		int j = 0;
		while (i < length1 && j < length2) {
			if (a2[length2 - j - 1] > a1[length1 - i - 1]) {
				a1[length1 + length2 - i - j - 1] = a2[length2 - j - 1];
				j ++;
			}
			else {
				a1[length1 + length2 - i - j - 1] = a1[length1 - i - 1];
				i ++;
			}
		}
		
		if (j < length2) {
			for (int k = 0; k < length2 - j; k ++) {
				a1[length2 - k - j - 1] = a2[length2 - k - j - 1];
			}
		}
		
		return a1;
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
		int[] a2 = {-2, 0, 6, 8, 10};
		
		Q02 service = new Q02();
		service.sort2Arrays(a1, 5, a2, 5);
		System.out.println(a1);
	}
}
