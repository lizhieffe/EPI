package Chap05;

public class Q02 {
	static long swapBits(long val, int i, int j) {
		if (((val >> i) & 1) != ((val >> j) & 1)) {
			val = val ^ ((1 << i) | (1 << j));
		}
		return val;
	}
	
	public static void main(String[] args) {
		long val = 123456789;
		int i = 1;
		int j = 0;
		long result = swapBits(val, i, j);
		System.out.println(Long.toBinaryString(val));
		System.out.println(Long.toBinaryString(result));
	}
}
