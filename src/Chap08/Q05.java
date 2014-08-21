package Chap08;

import Utils.ListNode;

public class Q05 {
	public ListNode isCyclic(ListNode node) {
		if (node == null)
			return node;
		
		ListNode n1 = node;
		ListNode n2 = node;
		
		while (true) {
			if (n1.next == null || n2.next == null || n2.next.next == null)
				return null;
			else {
				n1 = n1.next;
				n2 = n2.next.next;
				if (n1 == n2)
					break;
			}
		}
		
		n1 = node;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n1;
	}
	
	public static void main(String[] args) {
		ListNode start = new ListNode(1);
		start.next = new ListNode(2);
		start.next.next = new ListNode(3);
		start.next.next.next = new ListNode(4);
		start.next.next.next.next = new ListNode(2);
		start.next.next.next.next.next = new ListNode(2);
		start.next.next.next.next.next.next = new ListNode(2);
		start.next.next.next.next.next.next.next = new ListNode(2);
		start.next.next.next.next.next.next.next.next = start.next.next.next;
		
		Q05 service = new Q05();
		System.out.println(service.isCyclic(start));

	}
}
