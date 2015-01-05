package Chap21;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class Q02StringUtil {
	public static String replace(String s, int[] pos, char[] c) {
		if (pos == null || c == null || pos.length == 0 || c.length != pos.length)
			return s;
		char[] chars = s.toCharArray();
		for (int i = 0; i < c.length; i++)
			chars[pos[i]] = c[i];
		return String.valueOf(chars);
	}
	
	public static String delete(String s, int[] pos) {
		if (pos == null || pos.length == 0)
			return s;
		char[] chars = s.toCharArray();
		for (int i = 0; i < pos.length; i++)
			chars[pos[i]] = '\u0000';
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < chars.length; i++)
			if (chars[i] != '\u0000')
				builder.append(chars[i]);
		return builder.toString();
	}
	
	public static String insert(String s, int[] pos, char[] c) {
		if (pos == null || c == null || pos.length == 0 || c.length != pos.length)
			return s;
		char[] chars = s.toCharArray();
		for (int i = 0; i < c.length; i++)
			chars[pos[i]] = c[i];
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < pos.length; i++)
			builder.insert(i + pos[i], c[i]);
		return builder.toString();
	}
	
	public static Set<String> generateStringsWithinDistance(String s, int distance) {
		Set<String> result = new HashSet<String>();
		if (distance < 0)
			return result;
		Set<String> base = new HashSet<String>();
		Set<String> neighbors = new HashSet<String>();
		for (int i = 0; i <= distance; i++) {
			if (i == 0) {
				result.add(s);
				base.add(s);
				continue;
			}
			Iterator<String> it = base.iterator();
			while (it.hasNext()) {
				String tmp = it.next();
				neighbors.addAll(generateNeighboringStrings(tmp));
			}
			result.addAll(neighbors);
			base = neighbors;
			neighbors = new HashSet<String>();
		}
		return result;
	}
	
	public static Set<String> generateNeighboringStrings(String s) {
		Set<String> result = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				int[] pos = {i};
				char[] c = new char[1];
				c[0] = (char)('a' + j);
				result.add(replace(s, pos, c));
				result.add(delete(s, pos));
				result.add(insert(s, pos, c));
			}
		}
		return result;
	}
	
	@Test
	public void tc1() {
		String s = "a";
		generateStringsWithinDistance(s, 1);
	}
}
