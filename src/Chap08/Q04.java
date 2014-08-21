package Chap08;

public class Q04 {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		
		if (s.length() <= 1)
			return true;
		
		int head = -1;
		int tail = s.length();
		
		while (true) {
			head = findNextHead(s, head);
			tail = findNextTail(s, tail);
			
			if (head >= tail)
				break;
			
			if (s.charAt(head) != s.charAt(tail))
				return false;
		}
		
		return true;
	}
	
	private int findNextHead(String s, int oldHead) {
		char[] c = s.toCharArray();
		for (int i = oldHead < 0 ? 0 : oldHead + 1; i < s.length(); i ++) {
			if ((c[i] >= 'A' && c[i] <= 'Z') || (c[i] >= 'a' && c[i] <= 'z'))
				return i;
		}
		return s.length();
	}
	
	private int findNextTail(String s, int oldTail) {
		char[] c = s.toCharArray();
		for (int i = oldTail >= s.length()? s.length() - 1 : oldTail - 1;
				i >= 0; i --) {
			if ((c[i] >= 'A' && c[i] <= 'Z') || (c[i] >= 'a' && c[i] <= 'z'))
				return i;
		}
		return s.length();
	}
	
	public static void main(String[] args) {
		String s = "abcd dacba";
		
		Q04 service = new Q04();
		System.out.println(service.isPalindrome(s));
		
	}
}
