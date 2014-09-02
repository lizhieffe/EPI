package Chap16;

import java.util.ArrayList;
import java.util.List;

public class Q07 {
	
	ArrayList<String> result;
	
	List<String> enumerate(int k) {
		result = new ArrayList<String>();
		
		if (k <= 0)
			return result;
		
		enumerate("", k, k);
		
		return result;
	}
	
	private void enumerate(String solution, int numBeg, int numEnd) {
		if (numBeg == 0 && numEnd == 0)
			result.add(solution);
		
		if (numBeg > 0) {
			String tmp = solution + '(';
			enumerate(tmp, numBeg - 1, numEnd);
		}
		
		if (numBeg < numEnd) {
			String tmp = solution + ')';
			enumerate(tmp, numBeg, numEnd - 1);
		}
	}
	
	public static void main(String[] args) {
		int k = 3;
		System.out.println(new Q07().enumerate(k));
	}
}
