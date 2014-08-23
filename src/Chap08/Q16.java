package Chap08;

import Utils.ListNode;

public class Q16 {
	public double findMedian(ListNode node) {
		if (node == null)
			return Integer.MAX_VALUE;
		
		if (node.next == null)
			return node.val;
		
		ListNode start = null;
		ListNode end = null;
		
		start = node.next;
		end = node;
		
		while (end.val <= start.val) {
			start = start.next;
			end = end.next;
			
			/*
			 * in case all the nodes have the same value
			 */
			if (start == node && start.val == end.val)
				return node.val;
		}
		
		int num = 1;
		ListNode n1 = start;
		ListNode n2 = end;
		
		while (n1 != end) {
			n1 = n1.next;
			num ++;
			if (num % 2 == 0)
				n2 = n2.next;
		}
		
		if (num % 2 == 0)
			return ((double)(n2.val + n2.next.val)) / 2;
		else
			return n2.next.val;
	}
	
	public static void main(String[] args) {
		ListNode start = new ListNode(1);
		start.next = new ListNode(2);
		start.next.next = new ListNode(3);
		start.next.next.next = new ListNode(4);
		start.next.next.next.next = new ListNode(5);
		start.next.next.next.next.next = new ListNode(6);
		start.next.next.next.next.next.next = new ListNode(7);
//		start.next.next.next.next.next.next.next = new ListNode(8);
		start.next.next.next.next.next.next.next = start;
		
		System.out.println(new Q16().findMedian(start));
	}
}
