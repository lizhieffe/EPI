package Chap10;

import Utils.TreeNode;

public class Q02 {
	TreeNode wrongNode = null;
	
	public TreeNode isKBalanced(TreeNode root, int k) {
		if (k < 0)
			k = 0;
		
		if (height(root, k) == -1)
			return wrongNode;
		else
			return null;
	}
	
	private int height(TreeNode cNode, int k) {
		if (cNode == null)
			return 0;
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (cNode.left != null)
			leftHeight = height(cNode.left, k);
		
		if (leftHeight != -1 && cNode.right != null)
			rightHeight = height(cNode.right, k);
		
		if (leftHeight == -1 || rightHeight == -1)
			return -1;
		else if (Math.abs(leftHeight - rightHeight) > k) {
			wrongNode = cNode;
			return -1;
		} else
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);

		int k = 2;
		
		Q02 service = new Q02();
		System.out.println(service.isKBalanced(root, k));
		System.out.println();
	}
}
