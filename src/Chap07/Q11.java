package Chap07;

import java.util.ArrayList;

public class Q11 {
	public String encode(int[] array) {
		if (array == null || array.length == 0)
			return "";
		
		StringBuilder builder = new StringBuilder();
		for (int i = array.length - 1; i >= 0; i --) {
			int n = Integer.toBinaryString(array[i]).length() - 1;
			builder.insert(0, Integer.toBinaryString(array[i]));
			for (int j = 0; j < n; j ++)
				builder.insert(0, '0');
		}
		
		return builder.toString();
	}
	
	public int[] decode(String code) {
		if (code == null || code.length() == 0)
			return new int[0];
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		char[] c = code.toCharArray();
		int i = 0;
		while (i < c.length) {
			int j = 0;
			while (c[i + j] == '0')
				j ++;
			StringBuilder builder = new StringBuilder();
			for (int k = 0; k < j + 1; k ++)
				builder.append(c[i + j + k]);
			result.add(Integer.parseInt(builder.toString(), 2));
			i = i + j + j + 1;
		}
		
		int[] output = new int[result.size()];
		for (i = 0; i < output.length; i ++)
			output[i] = result.get(i);
		
		return output;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 10};
		String s = new Q11().encode(array);
		
		System.out.println(new Q11().encode(array));
		System.out.println(new Q11().decode(s));
	}
}
