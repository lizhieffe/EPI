package Chap08;

import Utils.ListNode;

public class Q13 {
	public ListNode zip(ListNode beg) {
		if (beg == null || beg.next == null || beg.next.next == null)
			return beg;
		
		ListNode tmp1 = beg;
		ListNode tmp2 = beg.next;
		
		while (tmp2.next != null) {
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
			if (tmp2.next == null)
				break;
			else
				tmp2 = tmp2.next;
		}
		
		ListNode beg2 = tmp1.next;
		tmp1.next = null;
		
		beg2 = reverse(beg2);
		
		ListNode cNode1 = beg;
		ListNode cNode2 = beg2;
		
		while (cNode2 != null) {
			tmp1 = cNode1.next;
			tmp2 = cNode2.next;

			cNode1.next = cNode2;
			cNode2.next = tmp1;
			cNode1 = tmp1;
			cNode2 = tmp2;
		}
		
		return beg;
	}
	
	private ListNode reverse(ListNode beg) {
		if (beg == null || beg.next == null)
			return beg;
		
		ListNode cNode = beg.next;
		ListNode newBeg = beg;
		newBeg.next = null;
		
		while (cNode != null) {
			ListNode tmp = newBeg;
			newBeg = cNode;
			cNode = cNode.next;
			newBeg.next = tmp;
		}
		
		return newBeg;
	}
	
	public static void main(String[] args) {
		ListNode beg = new ListNode(0);
		beg.next = new ListNode(1);
		beg.next.next = new ListNode(2);
		beg.next.next.next = new ListNode(3);
		beg.next.next.next.next = new ListNode(4);
		beg.next.next.next.next.next = new ListNode(5);
		beg.next.next.next.next.next.next = new ListNode(6);

		new Q13().zip(beg);
		beg.printList();
	}
}
