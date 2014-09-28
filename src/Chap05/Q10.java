package Chap05;

public class Q10 {
	public static int revert(int val) {
		int tmp = Math.abs(val);
		int result = 0;
		while (tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		return val >= 0 ? result : (-1) * result;
	}
	
	public static void main(String[] args) {
		int val = -456;
		System.out.println(revert(val));
	}
}
