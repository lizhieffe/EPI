package Chap10;

import Utils.TreeNode;

/*
 * here we assume that the ancestor cannot be n1 or n2, it can only be one of the parent of them
 * In the book solution, the ancestor can be n1 or n2
 */
public class Q04 {
	public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || n1 == null || n2 == null || root == n1 || root == n2)
			return null;
		
		return find(root, n1, n2);
	}
	
	private TreeNode find(TreeNode parent, TreeNode n1, TreeNode n2) {
		TreeNode tmp1 = null;
		TreeNode tmp2 = null;
		if (parent.left != null) {
			if (parent.left == n1 || parent.left == n2)
				return parent;
			else
				tmp1 = find(parent.left, n1, n2);
		}
		
		if (parent.right != null) {
			if (parent.right == n1 || parent.left == n2)
				return parent;
			else
				tmp2 = find(parent.right, n1, n2);
		}
		
		if (tmp1 != null && tmp2 != null)
			return parent;
		
		return tmp1 != null ? tmp1 : tmp2;
	}
}
