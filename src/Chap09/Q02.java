package Chap09;

import java.util.LinkedList;

public class Q02 {
	
	Integer calculate(String[] input) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < input.length; i ++) {
			if (isOperator(input[i]) && stack.size() < 2)
				return null;
			
			if (isOperator(input[i])) {
				int x = stack.removeLast();
				int y = stack.removeLast();
				stack.addLast(doCalculation(x, y, input[i]));
			}
			else {
				try {
					Integer x = Integer.parseInt(input[i]);
					stack.addLast(x);
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		
		if (stack.size() != 1)
			return null;
		
		return stack.removeLast();
	}
	
	private boolean isOperator(String str) {
		if (str.equals("+") || str.equals("-") 
				|| str.equals("*") || str.equals("/"))
			return true;
		else
			return false;
	}
	
	private int doCalculation(int x, int y, String operator) {
		if (operator == "+")
			return x + y;
		else if (operator == "-")
			return x - y;
		else if (operator == "*")
			return x * y;
		else
			return x / y;
	}
	
	public static void main(String[] args) {
		String[] input = {
				"2", "3", "*", "1", "5", "+", "+"
		};
		
		Q02 service = new Q02();
		System.out.println(service.calculate(input));
	}
}
