package Chap05;

public class Q05 {
	public static long multiply(int x, int y) {
		long result = 0;
		for (int i = 0; i < 32; i ++) {
			int tmpY = (y >> i) & 1;
			if (tmpY == 1)
				result = sum(result, x << i);
		}
		return result;
	}
	
	public static long sum(long x, long y) {
		int mod = 0;
		long result = 0;
		for (int i = 0; i < 32; i ++) {
			int tmpX = (int)((x >> i) & 1);
			int tmpY = (int)((y >> i) & 1);
			int tmp = (int)(tmpX | tmpY | mod);
			if ((tmpX == 1 && tmpY == 1) || (tmpX == 1 && mod == 1) || (mod == 1 && tmpY == 1))
				mod = 1;
			else
				mod = 0;
			result = result | tmp << i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int x = 2;
		int y = 4;
		System.out.println(sum(x, y));
		System.out.println(multiply(x, y));
	}
}
