package Chap05;

public class Q09 {
	public static int convert(String str) {
		int result = 0;
		final int base = 26;
		for (int i = 0; i < str.length(); i ++) {
			char tmp = str.charAt(i);
			result = result * base + tmp - 'A' + 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "AZ";
		System.out.println(convert(str));
	}
}
