package Chap16;

import java.util.ArrayList;

public class Q03 {
	ArrayList<String> result = new ArrayList<String>();
	int n;
	
	public ArrayList<String> findAllPlacement(int n) {
		if (n <= 0)
			return result;
		
		this.n = n;
		
		String solution = "";
		find(solution);
		
		return result;
	}
	
	private void find(String solution) {
		if (solution.length() == n * n)
			result.add(solution);
		else {
			for (int i = 0; i < n; i ++) {
				if (isFeasible(solution, i)) {
					StringBuilder tmp = new StringBuilder(solution);
					for (int j = 0; j < i; j ++)
						tmp.append('.');
					tmp.append('Q');
					for (int j = i + 1; j < n; j ++)
						tmp.append('.');
					find(tmp.toString());
				}
			}
		}
	}
	
	private boolean isFeasible(String s, int position) {
		if (position >= n)
			return false;
		
		if (s.length() == 0)
			return true;
		
		int[] x = new int[s.length() / n];
		
		for (int i = 0; i < s.length(); i ++)
			if (s.charAt(i) == 'Q')
				x[i / n] = i % n;
		
		for (int i = 0; i < x.length; i ++) {
			if (x[i] == position || Math.abs(position - x[i]) == Math.abs(s.length() / n - i))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int n = 4;
		
		Q03 service = new Q03();
		service.findAllPlacement(n);
	}
}
