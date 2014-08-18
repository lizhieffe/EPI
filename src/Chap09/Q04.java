package Chap09;

public class Q04 {
	public String findSubstringWithMaxValidParenLength(String input) {
		if (input == null || input.length() <= 1)
			return "";
		
		String result = "";
		
		int first = 0;
		int second = 0;
		char[] chars = input.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < chars.length; i ++) {
			if (chars[i] == '(') {
				builder.append('(');
				first ++;
			}
			else if (chars[i] == ')') {
				if (first > second) {
					builder.append(')');
				
					if (refineResult(builder.toString()).length() > result.length())
						result = refineResult(builder.toString());
					
					second ++;
				}
				else {
					builder.delete(0, builder.length());
					first = 0;
					second = 0;
				}
			}
		}
		
		return result;
	}
	
	private String refineResult(String result) {
		char[] chars = result.toCharArray();
		int first = 0;
		int second = 0;
		StringBuilder builder = new StringBuilder();
		
		for (int i = chars.length - 1; i >= 0; i --) {
			if (chars[i] == ')') {
				builder.insert(0,')');
				second ++;
			}
			else if (chars[i] == '(') {
				if (first == second)
					break;
				else {
					builder.insert(0,'(');
					first ++;
				}		
			}
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String input = "((((()())()))()";
		Q04 service = new Q04();
		System.out.println(service.findSubstringWithMaxValidParenLength(input));
	}
}
