package Chap16;

import java.util.ArrayList;

public class Q08 {
	String s;
	ArrayList<ArrayList<String>> result;
	int length;
	
	public ArrayList<ArrayList<String>> getAllPalindromicDecompositions(String s) {
		result = new ArrayList<ArrayList<String>>();
		
		if (s == null || s.length() == 0)
			return result;
		
		this.s = s;
		length = s.length();
		getAll(0, new ArrayList<String>());
		return result;
	}
	
	private void getAll(int beg, ArrayList<String> solution) {
		if (beg == length)
			result.add(solution);
		
		for (int i = beg + 1; i <= length; i ++) {
			String tmp = s.substring(beg, i);
			if (isPalindrome(tmp)) {
				ArrayList<String> tmpSolution = new ArrayList<String>(solution);
				tmpSolution.add(tmp);
				getAll(i, tmpSolution);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return false;
		
		char[] c = s.toCharArray();
		int i = 0;
		int j = c.length - 1;
		while (i < j) {
			if (c[i++] != c[j--])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "0204451881";
//		String s = "010";
		System.out.println(new Q08().getAllPalindromicDecompositions(s));
	}
}
