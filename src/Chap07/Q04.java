package Chap07;

public class Q04 {
	public String revertAllWords(String s) {
		if (s == null || s.length() == 1)
			return null;
		
		char[] c = s.toCharArray();
		revert(c, 0, c.length);
		
		int i = -1;
		for (int j = 0; j < c.length; j ++) {
			if (c[j] != ' ' && i == -1 && j != c.length - 1)
				i = j;
			else if (c[j] != ' ' && i == -1)
				continue;
			else if (c[j] != ' ' && j == c.length - 1)
				revert(c, i, j + 1);
			else if (c[j] == ' ' && i != -1) {
				revert(c, i, j);
				i = -1;
			}
		}
		
		return new String(c);
	}
	
	private void revert(char[] c, int start, int end) {
		while (start < end - 1) {
			char tmp = c[start];
			c[start] = c[end - 1];
			c[end - 1] = tmp;
			start ++;
			end --;
		}
	}
	
	public static void main(String[] args) {
		String s = "e abc def ghi d";
		Q04 service = new Q04();
		
		System.out.println(service.revertAllWords(s));
	}
}
