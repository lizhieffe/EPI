package Chap05;

public class Q08 {
	public static String baseConvert(int b1, String str, int b2) {
		int tmp = 0;
		for (int i = 0; i < str.length(); i ++) {
			char tmpChar = str.charAt(i);
			tmp = tmp * b1 + ((tmpChar >= '0' && tmpChar <= '9') ? tmpChar - '0' : tmpChar - 'A' + 10);
		}
		StringBuilder builder = new StringBuilder();
		do {
			builder.insert(0, tmp % b2 >= 10 ? 'A' + tmp % b2 - 10 : tmp % b2);
			tmp = tmp / b2;
		} while (tmp > 0);
		return builder.toString();
	}
	
	public static void main(String[] args) {
		int b1 = 5;
		int b2 = 6;
		String str = "23";
		System.out.println(baseConvert(b1, str, b2));
	}
}
