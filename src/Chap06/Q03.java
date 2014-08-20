package Chap06;

public class Q03 {

	/**
	 * Can only plus two positive integers
	 * @param a
	 * @param b
	 * @return
	 */
	public String plus(String a, String b) {
		if (a == null || a.length() == 0 || b == null || b.length() == 0)
			return "";
		
		StringBuilder result = new StringBuilder();
		int modifier = 0;
		for (int i = 0; i < Math.max(a.length(), b.length()); i ++) {
			int indexA = a.length() - i - 1;
			int indexB = b.length() - i - 1;
			int tmpA = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
			int tmpB = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
			result.insert(0, (tmpA + tmpB + modifier) % 10);
			modifier = (tmpA + tmpB + modifier) / 10;
		}
		
		if (modifier == 1)
			result.insert(0, modifier);

		return result.toString();
	}
	
	public String multiply(String a, String b) {
		if (a == null || a.length() == 0 || b == null || b.length() == 0)
			return "";
		
		String result = "0";

		for (int i = 0; i < a.length(); i ++) {
			int indexA = a.length() - i - 1;
			if (a.charAt(indexA) == '-')
				break;
			
			String tmp = "0";
			for (int j = 0; j < b.length(); j ++) {
				int indexB = b.length() - j - 1;
				if (b.charAt(indexB) == '-')
					break;

				StringBuilder stepResult_1 
						= new StringBuilder();
				stepResult_1.append((a.charAt(indexA) - '0') * (b.charAt(indexB) - '0'));
				for (int k = 0; k < j; k ++)
					stepResult_1.append('0');
				
				tmp = plus(tmp, stepResult_1.toString());
			}
			
			StringBuilder stepResult = new StringBuilder(tmp);
			for (int k = 0; k < i; k ++)
				stepResult.append('0');
			result = plus(result, stepResult.toString());
		}
		
		if (a.charAt(0) == '-' && b.charAt(0) == '-')
			return result;
		else if (a.charAt(0) == '-' || b.charAt(0) == '-')
			return "-" + result;
		else
			return result;
	}
	
//	private String plus(char a, char b) {
//		if (a < '0' || a > '9' || b < '0' || b > '9')
//			return "";
//		
//		return new StringBuilder((a - '0') + (b - '0')).toString();
//	}
//	
//	private String subtract(char a, char b) {
//		if (a < '0' || a > '9' || b < '0' || b > '9')
//			return "";
//		
//		return new StringBuilder((a - '0') - (b - '0')).toString();
//	}
//	
//	private String multiply(char a, char b) {
//		if (a < '0' || a > '9' || b < '0' || b > '9')
//			return "";
//		
//		return new StringBuilder((a - '0') * (b - '0')).toString();
//	}
	
	public static void main(String[] args) {
		String a = "-55";
		String b = "-33";
		
		Q03 service = new Q03();
//		System.out.println(service.plus(a, b));
		System.out.println(service.multiply(a, b));
	}
}
