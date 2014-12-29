package Chap08;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.ListNode;

public class Q06 {
	public ListNode findFirstOverlappingNode(ListNode n1, ListNode n2) {
		if (n1 == null || n2 == null)
			return null;
		int diff = 0;
		int length1 = 0, length2 = 0;
		ListNode curr1 = n1, curr2 = n2;
		while (curr1 != null) {
			curr1 = curr1.next;
			length1++;
		}
		while (curr2 != null) {
			curr2 = curr2.next;
			length2++;
		}
		diff = Math.abs(length1 - length2);
		if (length1 < length2) {
			ListNode tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		curr1 = n1;
		curr2 = n2;
		for (int i = 0; i < diff; i++)
			curr1 = curr1.next;
		while (curr1 != null) {
			if (curr1 == curr2)
				return curr1;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return null;
	}
	
	@Test
	public void testcase1() {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		ListNode n2 = new ListNode(4);
		n2.next = n1.next.next;
		Q06 test = new Q06();
		assertTrue(test.findFirstOverlappingNode(n1, n2) == n2.next);
	}
}
