package Chap08;

import Utils.ListNode;

public class Q19 {
	public ListNode add(ListNode beg1, ListNode beg2) {
		if (beg1 == null)
			return beg2;
		
		if (beg2 == null)
			return beg1;
		
		ListNode cNode = new ListNode((beg1.val + beg2.val) % 10);
		ListNode beg = cNode;
		ListNode cNode1 = beg1.next;
		ListNode cNode2 = beg2.next;
		int modifier = (beg1.val + beg2.val) / 10;
		
		while (cNode1 != null && cNode2 != null) {
			cNode.next = new ListNode((cNode1.val + cNode2.val + modifier) % 10);
			cNode = cNode.next;
			modifier = (cNode1.val + cNode2.val + modifier) / 10;
			cNode1 = cNode1.next;
			cNode2 = cNode2.next;
		}
		

		if (cNode1 != null || cNode2 != null) {
			cNode1 = cNode1 == null ? cNode2 : cNode1;
			while (cNode1 != null) {
				cNode.next = new ListNode((cNode1.val + modifier) % 10);
				cNode = cNode.next;
				modifier = (cNode1.val + modifier) / 10;
				cNode1 = cNode1.next;
			}
		}
		
		if (modifier == 1)
			cNode.next = new ListNode(1);
		
		return beg;
	}
	
	public static void main(String[] args) {
		ListNode beg1 = new ListNode(0);
		beg1.next = new ListNode(1);
		beg1.next.next = new ListNode(2);
		beg1.next.next.next = new ListNode(3);
		beg1.next.next.next.next = new ListNode(4);
		beg1.next.next.next.next.next = new ListNode(5);
		beg1.next.next.next.next.next.next = new ListNode(6);
		
		ListNode beg2 = new ListNode(0);
		beg2.next = new ListNode(1);
		beg2.next.next = new ListNode(2);
		beg2.next.next.next = new ListNode(3);
		beg2.next.next.next.next = new ListNode(4);
		beg2.next.next.next.next.next = new ListNode(5);
		beg2.next.next.next.next.next.next = new ListNode(6);
		
		new Q19().add(beg1, beg2).printList();;
	}
}
