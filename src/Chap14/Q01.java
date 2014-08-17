package Chap14;

import java.util.ArrayList;

public class Q01 {
	int[] findSame(int[] a, int[] b) {
		if (a == null || a.length == 0 || b == null || b.length == 0)
			return new int[0];
		else if (a.length / b.length > 10 || b.length / a.length > 10)
			return notSimilarLength(a, b);
		else
			return similarLength(a, b);
	}
	
	private int[] notSimilarLength(int[] a, int[] b) {
		if (a.length < b.length) {
			int[] tmp = a;
			a = b;
			b = tmp;
		}
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		BinarySearch bs = new BinarySearch(a);
		
		for (int i = 0; i < b.length; i ++) {
			int tmp = bs.find(b[i]);
			if (tmp != -1)
				resultList.add(a[tmp]);
		}
		
		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i ++)
			result[i] = resultList.get(i);
		
		return result;
	}
	
	private int[] similarLength(int[] a, int[] b) {
		int lengthA = a.length;
		int lengthB = b.length;
		
		int i = 0; 
		int j = 0;
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();

		while (i < lengthA && j < lengthB) {
			if (a[i] ==  b[j]) {
				resultList.add(a[i]);
				i ++;
				j ++;
			}
			else if (a[i] < b[j])
				i ++;
			else
				j ++;
		}
		
		int[] result = new int[resultList.size()];
		for (i = 0; i < resultList.size(); i ++)
			result[i] = resultList.get(i);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 5, 11, 15, 21, 25, 31, 35, 41, 45, 51, 55, 61, 65, 71, 75};
//		int[] b = {-1, 3, 11, 13, 64, 72, 75};
		int[] b = {11};
		
		Q01 service = new Q01();
		int[] same = service.findSame(a, b);
		System.out.println(same);
	}
}
