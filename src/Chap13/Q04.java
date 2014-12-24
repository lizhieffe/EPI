package Chap13;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class Q04 {
/*
 * LRU cache
 */
	static final int capacity = 5;
	Map<String, DoubleLinkedListNode> map = new HashMap<String, DoubleLinkedListNode>();
	DoubleLinkedListNode dummy = new DoubleLinkedListNode("", -1);
	DoubleLinkedListNode last = dummy;
	int size = 0;
	Random rand = new Random(47);
	
	public int getKey(String key) {
		if (!map.containsKey(key)) {
			int val = getValueFromDisk(key);
			addLast(key, val);
			map.put(key, last);
			if (size == capacity) {
				map.remove(dummy.next.key);
				dummy.next = dummy.next.next;
				size--;
			}
			size++;
			return val;
		}
		else {
			DoubleLinkedListNode old = map.get(key);
			old.prev.next = old.next;
			addLast(key, old.val);
			map.put(key, last);
			return old.val;
		}
		
	}
	
	private void addLast(String key, int val) {
		DoubleLinkedListNode newLast = new DoubleLinkedListNode(key, val);
		last.next = newLast;
		newLast.prev = last;
		last = last.next;
	}
	
	private int getValueFromDisk(String key) {
		
		return rand.nextInt();
	}
	
	@Test
	public void testcase1() {
		Q04 testcase = new Q04();
		testcase.getKey("a");
		int val = testcase.getKey("b");
		testcase.getKey("c");
		testcase.getKey("d");
		testcase.getKey("e");
		assertEquals("test 1", val, testcase.getKey("b"));
		testcase.getKey("f");
		assertEquals("test 1", val, testcase.getKey("b"));
		testcase.getKey("g");
		testcase.getKey("h");
		testcase.getKey("i");
		testcase.getKey("j");
		testcase.getKey("k");
		testcase.getKey("l");
		testcase.getKey("m");
		assertFalse(val == testcase.getKey("b"));
	}
}

class DoubleLinkedListNode {
	String key;
	int val;
	DoubleLinkedListNode next;
	DoubleLinkedListNode prev;
	DoubleLinkedListNode (String key, int val) {
		this.key = key;
		this.val = val;
	}
}
