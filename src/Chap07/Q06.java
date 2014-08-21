package Chap07;

public class Q06 {
	public String lookAndSee(int n) {
		if (n < 0)
			return "";
		if (n == 0)
			return "1";
		
		String tmp = "1";
		for (int i = 0; i < n; i ++) {
			char c = ' ';
			int count = 0;
			StringBuilder builder = new StringBuilder();
			
			for (int j = 0; j < tmp.length(); j ++) {
				if (j == 0) {
					c = tmp.charAt(j);
					count ++;
				}
				else if (c == tmp.charAt(j)) {
					count ++;
				}
				else {
					builder.append(count);
					builder.append(c);
					c = tmp.charAt(j);
					count = 1;
				}
			}
			
			builder.append(count);
			builder.append(c);
			tmp = builder.toString();
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		int n = 5;
		Q06 service = new Q06();
		System.out.println(service.lookAndSee(n));
	}
}
