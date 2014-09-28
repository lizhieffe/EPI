package Chap05;

import java.util.LinkedList;

public class Q11 {
	public static boolean isPalindrome(int val) {
		int tmp = val;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (tmp != 0) {
			stack.add(tmp % 10);
			tmp = tmp / 10;
		}
		for (int i = 0; i < stack.size() / 2; i ++) {
			if (stack.removeFirst() != stack.removeLast())
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int val = 123121321;
		System.out.println(isPalindrome(val));
	}
}
