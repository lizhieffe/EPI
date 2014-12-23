package Chap09;

import java.util.HashSet;
import java.util.Set;

import Utils.PostingNode;

public class Q07 {
	public void searchPostingListRecursively(PostingNode beg) {
		if (beg == null)
			return;
		Set<PostingNode> visited = new HashSet<PostingNode>();
		searchPostingListRecursively(beg, visited);
	}
	
	private void searchPostingListRecursively(PostingNode beg, Set<PostingNode> visited) {
		if (beg == null)
			return;
		if (!visited.contains(beg)) {
			System.out.print("->" + beg.val);
			visited.add(beg);
		}
		if (!visited.contains(beg.jump))
			searchPostingListRecursively(beg.jump, visited);
		searchPostingListRecursively(beg.next, visited);
	}
	
	public void searchPostingListIteratively(PostingNode beg) {
		if (beg == null)
			return;
		Set<PostingNode> visited = new HashSet<PostingNode>();
		PostingNode curr = beg;
		while (curr != null) {
			if (!visited.contains(curr)) {
				System.out.print("->" + curr.val);
				visited.add(curr);
			}
			if (!visited.contains(curr.jump))
				curr = curr.jump;
			else
				curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		PostingNode n1 = new PostingNode(1);
		PostingNode n2 = new PostingNode(2);
		PostingNode n3 = new PostingNode(3);
		PostingNode n4 = new PostingNode(4);
		PostingNode n5 = new PostingNode(5);
		PostingNode n6 = new PostingNode(6);
		PostingNode n7 = new PostingNode(7);
		PostingNode n8 = new PostingNode(8);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		n1.jump = n4;
		n4.jump = n8;
		n8.jump = n2;
		n2.jump = n6;
		n6.jump = n7;
		n7.jump = n3;
		n3.jump = n5;
		n5.jump = n1;
		
		new Q07().searchPostingListIteratively(n1);
	}
}
