package Chap10;

import Utils.TreeNode;

public class Q01 {
	boolean isBalanced(TreeNode node) {
		if (height(node) != -1)
			return true;
		else
			return false;
	}
	
	int height(TreeNode node) {
		if (node == null)
			return 0;
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if (leftHeight == -1 || rightHeight == -1)
			return -1;
		else if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(1);

		Q01 service = new Q01();
		System.out.println(service.isBalanced(root));
	}
}