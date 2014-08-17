package Chap15;

import Utils.TreeNode;

public class Q01 {
	boolean isBST(TreeNode node) {
		if (node == null)
			return false;
		
		return max(node) != null ? true : false;
	}
	
	Integer max(TreeNode node) {
		if (node == null)
			return null;
		
		if (node.left == null && node.right == null)
			return node.val;
		
		Integer tmp = node.val;
		
		if (node.left != null) {
			Integer left = max(node.left);
			if (left == null || left > tmp)
				tmp = null;
		}
		
		if (node.right != null && tmp != null) {
			Integer right = max(node.right);
			if (right == null || right <= tmp)
				tmp = null;
			else
				tmp = right;
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);

		Q01 service = new Q01();
		System.out.println(service.isBST(root));
	}
}
