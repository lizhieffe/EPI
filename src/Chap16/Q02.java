package Chap16;

public class Q02 {

	char[] c1, c2;
	
	public boolean isESRE(String r, String s) {
		if (r == null || s == null)
			return false;
		if (r.length() == 0)
			return true;
		
		c1 = r.toCharArray();
		c2 = s.toCharArray();
		
		if (c1[0] == '^')
			return isESREStartingFromHere(1, 0);
		
		for (int i = 0; i < c2.length; i ++)
			if (isESREStartingFromHere(0, i))
				return true;
		
		return false;
	}
	
	private boolean isESREStartingFromHere(int index1, int index2) {
		if (index1 >= c1.length && index2 >= c2.length)
			return true;
		if (index1 >= c1.length)
			return true;
		if (index2 >= c2.length) {
			if (c1[index1] == '*' || c1[index1] == '$')
				return isESREStartingFromHere(index1 + 1, index2);
			else
				return false;
		}
		
		if (index1 == c1.length - 1) {
			if (c1[index1] == '$')
				return index2 == c2.length ? true : false;
			else
				return c1[index1] == c2[index2] || c1[index1] == '.' ? true : false;
		}
		else if (index1 - c1.length > 2 && c1[index1 + 1] == '*') {
			if (isESREStartingFromHere(index1 + 2, index2))
				return true;
			
			int i = 0;
			while (index2 + i < c2.length && (c1[index1] == '.' || c1[index1] == c2[index2 + i])) {
				if (isESREStartingFromHere(index1 + 2, index2 + i))
					return true;
				i ++;
			}
		}
		else if (c1[index1] == '.')
			return isESREStartingFromHere(++ index1, ++ index2);
		
		else if (c1[index1] == '*') {
			return false;
		}
		
		else if (c1[index1] == c2[index2])
			return isESREStartingFromHere(index1 + 1, index2 + 1);

		return false;
	}
	
	public static void main(String[] args) {
		String r = "^a*$";
		String s = "abcd";
		Q02 service = new Q02();
		System.out.println(service.isESRE(r, s));
	}
}
