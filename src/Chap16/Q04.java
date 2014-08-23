package Chap16;

import java.util.ArrayList;
import java.util.Arrays;

public class Q04 {
	ArrayList<char[]> result = new ArrayList<char[]>();
	
	public ArrayList<char[]> getAllPermutations(char[] chars) {
		if (chars == null || chars.length == 0)
			return result;
		
		Arrays.sort(chars);
		
		getAll(new char[0], chars);
		return result;
	}
	
	private void getAll(char[] c, char[] pending) {
		if (pending.length == 0) {
			result.add(c);
			return;
		}
		
		for (int i = 0; i < pending.length; i ++) {
			char[] cNew = new char[c.length + 1];
			char[] pendingNew = new char[pending.length - 1];
			
			for (int j = 0; j < c.length; j ++)
				cNew[j] = c[j];
			cNew[cNew.length - 1] = pending[i];

			int k = 0;
			for (int j = 0; j < pending.length; j ++) {
				if (j != i)
					pendingNew[k ++] = pending[j];
			}
			
			getAll(cNew, pendingNew);
		}
	}
	
	public static void main(String[] args) {
		char[] chars = {'a', 'd', 't', 'y'};
		System.out.println(new Q04().getAllPermutations(chars));
	}
}
