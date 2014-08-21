package Chap08;

import Utils.ListNode;

public class Q08 {
	public void deleta(ListNode node) {
		if (node == null || node.next == null)
			return;
		
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
