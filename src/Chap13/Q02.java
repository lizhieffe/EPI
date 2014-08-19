package Chap13;

import java.util.HashSet;

public class Q02 {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		
		if (s.length() <= 1)
			return true;
		
		char[] chars = s.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < chars.length; i ++) {
			if (set.contains(chars[i]))
				set.remove(chars[i]);
			else
				set.add(chars[i]);
		}
		
		return set.size() <= 1 ? true : false;
	}
	
	public static void main(String[] args) {
		String s = "abcdeabcdd";
		Q02 service = new Q02();
		System.out.println(service.isPalindrome(s));
	}
}
