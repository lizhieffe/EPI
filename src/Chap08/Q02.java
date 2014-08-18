package Chap08;

import Utils.ListNode;

public class Q02 {
	public ListNode reverse(ListNode root) {
		if (root == null || root.next == null)
			return root;
		
		ListNode newRoot = root;
		while (newRoot.next != null)
			newRoot = newRoot.next;
		
		ListNode oldStart = root;
		
		while(oldStart != newRoot) {
			ListNode tmp = newRoot.next;
			newRoot.next = oldStart;
			oldStart = oldStart.next;
			newRoot.next.next = tmp;
		}
		
		return newRoot;
	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		root.next.next.next.next = new ListNode(4);

		Q02 service = new Q02();
		ListNode newRoot = service.reverse(root);
		System.out.println(newRoot);
	}
}
