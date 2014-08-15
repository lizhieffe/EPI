package Chap08;

import Utils.ListNode;

public class Q01 {
	ListNode merge(ListNode n1, ListNode n2) {
		if (n1 == null)
			return n2;
		
		if (n2 == null)
			return n1;
		
		ListNode cNode1 = n1;
		ListNode cNode2 = n2;
		ListNode head, last;

		if (cNode1.val < cNode2.val) {
			head = cNode1;
			last = cNode1;
			
			cNode1 = cNode1.next;
		}
		else {
			ListNode tmp = cNode2.next;
			
			head = cNode2;
			last = cNode2;
			
			cNode2.next = cNode1;
			cNode2 = tmp;			
		}
		
		while (cNode1 != null && cNode2 != null) {
			if (cNode1.val < cNode2.val) {
				last = cNode1;
				
				cNode1 = cNode1.next;
			}
			else {
				ListNode tmp = cNode2.next;
				
				last.next = cNode2;
				last = last.next;
				cNode2.next = cNode1;
				cNode2 = tmp;
			}
		}
		
		if (cNode1 == null)
			last.next = cNode2;
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(3);
		n1.next.next = new ListNode(5);
		n1.next.next.next = new ListNode(7);
		n1.next.next.next.next = new ListNode(9);

		ListNode n2 = new ListNode(2);
		n2.next = new ListNode(4);
		n2.next.next = new ListNode(8);
		n2.next.next.next = new ListNode(10);
		n2.next.next.next.next = new ListNode(12);
		
		Q01 service = new Q01();
		ListNode newList = service.merge(n1, n2);
		newList.printList();
	}
}
