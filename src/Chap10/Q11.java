package Chap10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q11 {
	public TreeNode findSuccessor(TreeNode node) {
		if (node == null)
			return null;
		if (node.right != null)
			return findLeftMostLeaf(node.right);
		return findFirstRightParent(node);
	}
	
	private TreeNode findLeftMostLeaf(TreeNode node) {
		if (node.left != null)
			return findLeftMostLeaf(node.left);
		else
			return node;
	}
	
	private TreeNode findFirstRightParent(TreeNode node) {
		if (node.parent == null)
			return null;
		if (node.parent.left == node)
			return node.parent;
		else
			return findFirstRightParent(node.parent);
	}
	
	@Test
	public void testcase1() {
		TreeNode n00 = new TreeNode(0);
		TreeNode n10 = new TreeNode(1);
		TreeNode n11 = new TreeNode(2);
		TreeNode n20 = new TreeNode(3);
		TreeNode n21 = new TreeNode(4);
		TreeNode n22 = new TreeNode(5);
		TreeNode n23 = new TreeNode(6);
		n00.left = n10;
		n00.right = n11;
		n10.parent = n00;
		n10.left = n20;
		n10.right = n21;
		n11.parent = n00;
		n11.left = n22;
		n11.right = n23;
		n20.parent = n10;
		n21.parent = n10;
		n22.parent = n11;
		n23.parent = n11;
		
		Q11 testcase = new Q11();
		assertTrue(testcase.findSuccessor(n21) == n00);
		assertTrue(testcase.findSuccessor(n00) == n22);
		assertTrue(testcase.findSuccessor(n23) == null);
	}
}

class TreeNode {
	int val;
	TreeNode parent, left, right;
	TreeNode (int val) {
		this.val = val;
	}
}
