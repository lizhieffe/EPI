package Chap08;

import Utils.ListNode;

public class Q03 {
	public ListNode revertK(ListNode root, int k) {
		if (root == null || root.next == null || k <= 1)
			return root;
		
		ListNode newRoot = root;
		ListNode tail = root;
		ListNode head = findHead(tail, k);
		ListNode oldHead = null;
		
		int n = 0;
		while (head != null) {
			if (n == 0)
				newRoot = head;
			
			ListNode cNode = tail;
			while (cNode != head) {
				if (n != 0)
					oldHead.next = cNode.next;
				ListNode tmp = head.next;
				head.next = cNode;
				cNode = cNode.next;
				head.next.next = tmp;
			}
			
			oldHead = tail;
			tail = oldHead.next;
			head = findHead(tail, k);
			n ++;
		}
		
		return newRoot;
	}
	
	private ListNode findHead(ListNode tail, int k) {
		if (tail == null)
			return null;
		
		ListNode cNode = tail;
		
		for (int i = 0; i < k - 1; i ++) {
			if (cNode.next == null)
				return null;
			else
				cNode = cNode.next;
		}
		return cNode;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(3);
		n1.next.next = new ListNode(5);
		n1.next.next.next = new ListNode(7);
		n1.next.next.next.next = new ListNode(9);
		n1.next.next.next.next.next = new ListNode(11);
		n1.next.next.next.next.next.next = new ListNode(13);
		n1.next.next.next.next.next.next.next = new ListNode(15);
		n1.next.next.next.next.next.next.next.next = new ListNode(17);

		int k = 3;
		
		Q03 service = new Q03();
		ListNode result = service.revertK(n1, k);
		result.printList();
	}
}
