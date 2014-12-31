package Chap17;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

public class Q12 {
	public boolean canBeSeperated(String s, Set<String> set) {
		if (s == null || set == null || set.size() == 0)
			return false;
		Set<String> dict = new HashSet<String>(set);
		if (s == "")
			return dict.contains("");
		int[] dp = new int[s.length()];
		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;
		int maxStringLength = getMaxLength(dict);
		boolean result = canFind(s, dict, dp, 0, maxStringLength);
		return result;
	}
	
	private boolean canFind(String s, Set<String> dict, int[] dp, int beg, int maxStringLength) {
		if (beg >= s.length())
			return true;
		if (dp[beg] != -1)
			return dp[beg] == 0 ? false : true;
		boolean result = false;
		for (int i = 1; i <= maxStringLength && i + beg <= s.length(); i++) {
			if (canFind(s, dict, dp, beg + i, maxStringLength) && dict.contains(s.substring(beg, beg + i))) {
				result = true;
				break;
			}
		}
		dp[beg] = (result == true) ? 1 : 0;
		return result;
	}
	
	private int getMaxLength(Set<String> dict) {
		int result = 0;
		if (dict == null || dict.size() == 0)
			return 0;
		Iterator<String> it = dict.iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			if (tmp.length() > result)
				result = tmp.length();
		}
		return result;
	}
	
	@Test
	public void tc1() {
		String s = "ab";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		Q12 tc = new Q12();
		boolean result = tc.canBeSeperated(s, set);
		assertTrue(result == true);
	}
	
	@Test
	public void tc2() {
		String s = "abc";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("bc");
		Q12 tc = new Q12();
		boolean result = tc.canBeSeperated(s, set);
		assertTrue(result == true);
	}
	
	@Test
	public void tc3() {
		String s = "abcdefghijklmn";
		Set<String> set = new HashSet<String>();
		set.add("abcd");
		set.add("efgh");
		set.add("ijklmn");
		Q12 tc = new Q12();
		boolean result = tc.canBeSeperated(s, set);
		assertTrue(result == true);
	}
}
