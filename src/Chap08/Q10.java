package Chap08;

import Utils.ListNode;

public class Q10 {
	public ListNode removeDuplicateFromSortedList(ListNode beg) {
		if (beg == null)
			return beg;
		
		ListNode lastNode = beg;
		ListNode cNode = beg.next;
		
		while (cNode != null) {
			if (cNode.val != lastNode.val) {
				lastNode.next = cNode;
				lastNode = cNode;
				cNode = cNode.next;
			}
			else
				cNode = cNode.next;
		}
		
		lastNode.next = null;
		
		return beg;
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		root.next = new ListNode(0);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(3);
		
		new Q10().removeDuplicateFromSortedList(root);
	}
}
