package Chap05;

public class Q04 {
	static long findCloset(long val) {
		int i;
		int prev = -1;
		int cur = -1;
		for (i = 0; i < 64; i ++) {
			cur = (int)((val >> i) & 1);
			if ((prev == 0 && cur == 1) || (prev == 1 && cur == 0))
				break;
			prev = cur;
		}
		return Q02.swapBits(val, i, i - 1);
	}
	
	public static void main(String[] args) {
		long val = 11;
		System.out.println(findCloset(val));
	}
}
