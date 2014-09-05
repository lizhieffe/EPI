package Chap10;

import Utils.TreeNode;
import Utils.TreeNodeWithNext;

public class Q16 {
	public void findNext(TreeNodeWithNext root) {
		if (null == root || root.left == null)
			return;
		
		root.next = null;
		find(root);
	}
	
	private void find(TreeNodeWithNext cNode) {
		if (cNode == null || cNode.left == null)
			return;
		
		cNode.left.next = cNode.right;
		cNode.right.next = cNode.next != null ? cNode.next.left : null;
		
		find(cNode.left);
		find(cNode.right);
	}
	
	public static void main(String[] args) {
		TreeNodeWithNext root = new TreeNodeWithNext(0);
		
		root.left = new TreeNodeWithNext(1);
		root.left.left = new TreeNodeWithNext(3);
		root.left.right = new TreeNodeWithNext(4);
		
		root.right = new TreeNodeWithNext(2);
		root.right.left = new TreeNodeWithNext(5);
		root.right.right = new TreeNodeWithNext(6);
		
		new Q16().findNext(root);
		System.out.println();
	}
}
