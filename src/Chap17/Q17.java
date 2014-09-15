package Chap17;

public class Q17 {
	String s1;
	String s2;
	String t;
	
	public boolean isInterleaving(String s1, String s2, String t) {
		this.s1 = s1;
		this.s2 = s2;
		this.t = t;
		
		return isInterleaving(0, 0, 0);
	}
	
	private boolean isInterleaving(int beg1,int beg2, int begt) {
		if (s1.length() - beg1 + s2.length() - beg2 != t.length() - begt)
			return false;
		
		if (beg1 == s1.length())
			return s2.substring(beg2, s2.length()).equals(t.substring(begt, t.length()));
		
		if (beg2 == s2.length())
			return s1.substring(beg1, s1.length()).equals(t.substring(begt, t.length()));
		
		boolean result = false;
		if (s1.charAt(beg1) == t.charAt(begt))
			result = result || isInterleaving(beg1 + 1, beg2, begt + 1);
		
		if (result != true && s2.charAt(beg2) == t.charAt(begt))
			result = result || isInterleaving(beg1, beg2 + 1, begt + 1);

		return result;
	}
	
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "azcye";
		String t = "abaczdcyee";
		
		System.out.println(new Q17().isInterleaving(s1, s2, t));
	}
}
