package Chap14;

import java.util.Arrays;

public class Q03 {
	public void print(String s) {
		if (s == null || s.length() == 1)
			return;
		
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		
		char c = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i ++) {
			if (chars[i] == c)
				count ++;
			else {
				System.out.print("(" + c + ", " + count + "), ");
				c = chars[i];
				count = 1;
			}
		}
		System.out.print("(" + c + ", " + count + ")");
	}
	
	public static void main(String[] args) {
		String s = "abcdefgabcd";
		Q03 service = new Q03();
		service.print(s);
		
	}
}
