package Chap14;

import java.util.ArrayList;
import java.util.Arrays;

public class Q04 {
	public String[] removeDup(String[] s) {
		if (s == null || s.length <= 1)
			return s;
		
		Arrays.sort(s);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(s[0]);
		for (int i = 1; i < s.length; i ++) {
			if (!s[i].equals(list.get(list.size() - 1)))
				list.add(s[i]);
		}
		
		String[] result = new String[list.size()];
		for (int i = 0; i < result.length; i ++)
			result[i] = list.get(i);
		
		return result;
	}
}
