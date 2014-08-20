package Chap17;

public class Q02 {
	
	int[][] result;
	int length1, length2;
	String s1, s2;
	
	public int getDistance(String s1, String s2) {
		if (s1 == null || s2 == null)
			return -1;
		
		if (s1.length() == 0)
			return s2.length();
		
		if (s2.length() == 0)
			return s1.length();
		
		this.s1 = s1;
		this.s2 = s2;
		
		length1 = s1.length();
		length2 = s2.length();
		
		result = new int[length1][length2];
		for (int i = 0; i < length1; i ++)
			for (int j = 0; j < length2; j ++)
				result[i][j] = -1;
		
		return distance(0, 0);
	}
	
	private int distance(int start1, int start2) {
		if (start1 >= length1 && start2 >= length2)
			return 0;
		
		if (start1 >= length1)
			return length2 - start2;
		
		if (start2 >= length2)
			return length1 - start1;
		
		if (result[start1][start2] != -1)
			return result[start1][start2];
		
		int tmp;
		
		if (s1.charAt(start1) == s2.charAt(start2))
			tmp = distance(start1 + 1, start2 + 1);
		else {
			tmp = Math.min(distance(start1 + 1, start2), distance(start1, start2 + 1));
			tmp = Math.min(tmp, distance(start1 + 1, start2 + 1));
			tmp = tmp + 1;
		}
		result[start1][start2] = tmp;
		return tmp;
	}
	
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "abce";
		
		Q02 service = new Q02();
		System.out.println(service.getDistance(s1, s2));
		
	}
}
