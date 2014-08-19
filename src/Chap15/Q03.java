package Chap15;

import Utils.TreeNode;

public class Q03 {
	TreeNode findFirstLarger(TreeNode root, int val) {
		if (root == null)
			return null;
		
		if (root.val <= val)
			return findFirstLarger(root.right, val);
		else {
			TreeNode tmp = findFirstLarger(root.left, val);
			return tmp == null ? root : tmp;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		
		int val = 7;
		
		Q03 service = new Q03();
		TreeNode result = service.findFirstLarger(root, val);
		System.out.println(result);
	}
}
