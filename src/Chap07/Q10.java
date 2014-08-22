package Chap07;

public class Q10 {
	public String encode(String s) {
		if (s == null || s.length() == 0)
			return "";

		StringBuilder builder = new StringBuilder();

		char last = s.charAt(0);
		int length = 1;
		
		for (int i = 1; i < s.length(); i ++) {
			if (s.charAt(i) == last)
				length ++;
			else {
				builder.append(length);
				builder.append(last);
				last = s.charAt(i);
				length = 1;
			}
		}
		builder.append(length);
		builder.append(last);
		
		return builder.toString();
	}
	
	public String decode(String s) {
		if (s == null || s.length() <= 1)
			return "";
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < s.length();) {
			StringBuilder tmp = new StringBuilder();
			while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				tmp.append(s.charAt(i));
				i ++;
			}
			char c = s.charAt(i ++);
			for (int j = 0; j < Integer.parseInt(tmp.toString()); j ++) {
				builder.append(c);
			}
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String s = "aabdfaerewqw";
		System.out.println(new Q10().decode(new Q10().encode(s)));
	}
}
