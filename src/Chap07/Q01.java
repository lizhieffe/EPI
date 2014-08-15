package Chap07;

public class Q01 {
	int str2Int(String str) {
		boolean positive = true;
		int result = 0;
		
		for (int i = 0; i < str.length(); i ++) {
			if (i == 0 && str.charAt(i) == '-')
				positive = false;
			else
				result = result * 10 + (str.charAt(i) - '0');
		}
		
		return positive ? result : (-1) * result;
	}
	
	String int2Str(int x) {
		if (x == 0)
			return "0";
		
		boolean positive = x >= 0;
		x = Math.abs(x);
		StringBuilder builder = new StringBuilder();
		
		while (x > 0) {
			builder = builder.insert(0, (x % 10));
			x = x / 10;
		}
		
		if (!positive)
			builder = builder.insert(0, '-');
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		int x = -987;
		String str = "-678";
		
		Q01 service = new Q01();
		System.out.println(service.str2Int(str));
		System.out.println(service.int2Str(x));
	}
}
