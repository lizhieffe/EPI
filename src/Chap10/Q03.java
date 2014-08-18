package Chap10;

import Utils.TreeNode;

public class Q03 {
	public boolean isSymmetrical(TreeNode root) {
		if (root == null)
			return false;
		
		return isSymmetrical(root.left, root.right);
	}
	
	private boolean isSymmetrical(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		
		if (n1 == null || n2 == null)
			return false;
		
		return isSymmetrical(n1.left, n2.right) && isSymmetrical(n1.right, n2.left);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		
		Q03 service = new Q03();
		System.out.println(service.isSymmetrical(root));
	}
}
