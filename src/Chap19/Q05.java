package Chap19;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Q05 {
	public int getDistance(String beg, String end, Set<String> dict) {
		if (beg == null || end == null || beg.length() != end.length())
			return -1;
		if (beg.equals(end))
			return 0;
		
		List<char[]> curr = new ArrayList<char[]>();
		List<char[]> next = new ArrayList<char[]>();
		curr.add(beg.toCharArray());
		
		int result = 0;
		while (curr.size() > 0) {
			while (curr.size() > 0) {
				char[] chars = curr.remove(0);
				if (String.valueOf(chars).equals(end))
					return result - 1;
				for (int i = 0; i < chars.length; i++) {
					for (int j = 0; j < 26; j++) {
						char[] tmp = new char[chars.length];
						System.arraycopy(chars, 0, tmp, 0, chars.length);
						tmp[i] = (char)('a' + j);
						String s = String.valueOf(tmp);
						if (dict.contains(s)) {
							dict.remove(s);
							next.add(tmp);
						}
					}
				}
			}
			result++;
			curr = next;
			next = new ArrayList<char[]>();
		}
		
		return -1;
	}
	
	@Test
	public void testcase1() {
		String beg = "aaa";
		String end = "acd";
		String d1 = "baa";
		String d2 = "bca";
		String d3 = "bcd";
		Set<String> dict = new HashSet<String>();
		dict.add(d1);
		dict.add(d2);
		dict.add(d3);
		dict.add(end);
		int result = new Q05().getDistance(beg, end, dict);
		assertTrue(result == 3);
	}
	
	@Test
	public void testcase2() {
		String beg = "aaa";
		String end = "acd";
		String d1 = "baa";
		String d2 = "bca";
		String d3 = "bcd";
		String d4 = "aca";
		Set<String> dict = new HashSet<String>();
		dict.add(d1);
		dict.add(d2);
		dict.add(d3);
		dict.add(d4);
		dict.add(end);
		int result = new Q05().getDistance(beg, end, dict);
		assertTrue(result == 1);
	}
}
