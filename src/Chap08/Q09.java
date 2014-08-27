package Chap08;

import Utils.ListNode;

public class Q09 {
	public ListNode deleteLastKNodes(ListNode beg, int k) {
		if (beg == null || k <= 0)
			return beg;
		
		int n = 0;
		ListNode n1 = beg;
		while (n < k) {
			if (n1 == null)
				return null;
			
			n1 = n1.next;
			n ++;
		}
		
		ListNode n2 = beg;
		while (n1.next != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		
		n2.next = null;
		return beg;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(3);
//		n1.next.next = new ListNode(5);
//		n1.next.next.next = new ListNode(7);
//		n1.next.next.next.next = new ListNode(9);
		
		int k = 2;
		
		n1 = new Q09().deleteLastKNodes(n1, k);
		n1.printList();
	}
}
