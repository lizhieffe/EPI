package Chap09;

import java.util.LinkedList;

public class Q03 {
	public boolean isPBBMatch(String input) {
		if (input == null || input.length() % 2 == 1)
			return false;
		
		if (input.length() == 0)
			return true;
		
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i ++) {
			char tmp = input.charAt(i);
			if (tmp == '(' || tmp == '[' || tmp == '{')
				stack.add(tmp);
			else if (tmp == ')') {
				if (stack.size() == 0 || stack.getLast() != '(')
					return false;
				else
					stack.removeLast();
			}
			else if (tmp == ']') {
				if (stack.size() == 0 || stack.getLast() != '[')
					return false;
				else
					stack.removeLast();
			}
			else if (tmp == '}') {
				if (stack.size() == 0 || stack.getLast() != '{')
					return false;
				else
					stack.removeLast();
			}
		}
		
		return stack.size() == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		String input = "()[{}]()";
		Q03 service = new Q03();
		System.out.println(service.isPBBMatch(input));
	}
}
