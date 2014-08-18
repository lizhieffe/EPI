package Chap15;

import Utils.TreeNode;

public class Q02 {
	public TreeNode findFirst(TreeNode root, int val) {
		if (root == null)
			return null;
		
		if (root.val == val)
			return root;
		
		if (root.left != null) {
			TreeNode tmp = findFirst(root.left, val);
			if (tmp != null)
				return tmp;
		}
		
		if (root.right != null) {
			TreeNode tmp = findFirst(root.right, val);
			if (tmp != null)
				return tmp;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		
		Q02 service = new Q02();
		TreeNode result = service.findFirst(root, 8);
		
		System.out.println(result.val);
	}
}
