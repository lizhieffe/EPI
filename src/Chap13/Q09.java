package Chap13;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class Q09 {
	
	public int findMinLength(String[] a, String[] q) {
		if (q == null || q.length == 0 || a == null || a.length < q.length)
			return 0;
		PriorityQueue<Text> pq = new PriorityQueue<Text>();
		Map<String, Integer> appeared = new HashMap<String, Integer>();
		for (int i = 0; i < q.length; i++)
			appeared.put(q[i], -1);
		int left = q.length;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			String s = a[i];
			if (appeared.containsKey(s) && appeared.get(s) == -1) {
				appeared.put(s, i);
				pq.add(new Text(s, i));
				left--;
				if (left == 0) {
					Text first = pq.poll();
					appeared.put(first.s, -1);
					left++;
					if (result > i - first.pos + 1)
						result = i - first.pos + 1;
				}
			}
			else if (appeared.containsKey(s)){
				int oldPos = appeared.get(s);
				pq.remove(new Text(s, oldPos));
				appeared.put(s, i);
				pq.add(new Text(s, i));
			}
		}
		return result;
	}
	
	@Test
	public void testCase1() {
		String[] a = {"ab", "cd", "00", "ef", "gh", "00", "00", "00", "00", "ab", "ij"};
		String[] q = {"ab", "ef", "gh"};
		Q09 testcase = new Q09();
		int result = testcase.findMinLength(a, q);
		assertEquals("result should =  5", result, 5);
	}
	
	@Test
	public void testCase2() {
		String[] a = {"ab", "cd", "00", "ef", "gh", "ab", "ij"};
		String[] q = {"ab", "ef", "gh"};
		Q09 testcase = new Q09();
		int result = testcase.findMinLength(a, q);
		assertEquals("result should =  3", result, 3);
	}
}

class Text implements Comparable <Text> {
	String s;
	int pos;
	Text(String s, int pos) {
		this.s = s;
		this.pos = pos;
	}
	
	@Override
	public int compareTo(Text t) {
		if (pos < t.pos)
			return -1;
		if (pos > t.pos)
			return 1;
		return 0;
	}
}
