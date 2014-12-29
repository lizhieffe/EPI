package Chap10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q04R2 {
	public static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		if (root == n1 || root == n2)
			return root;
		TreeNode r1 = findLCA(root.left, n1, n2);
		TreeNode r2 = findLCA(root.right, n1, n2);
		if (r1 == null && r2 == null)
			return null;
		if (r1 != null && r2 != null)
			return root;
		return (r1 != null) ? r1 : r2;
	}
	
	@Test
	public void tc1() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		assertTrue(findLCA(root, root.left.left, root.left.right).val == 1);
	}
}
