package Chap15;

import Utils.TreeNode;

public class Q15 {
	public boolean isTotallyOrdered (TreeNode root, int m, int r, int s) {
		if (root == null)
			return false;
		
		return is(root, m, r, s, 0) == 1 ? true : false;
	}
	
	private int is (TreeNode cNode, int m, int r, int s, int parentVal) {
		if (cNode == null)
			return 0;
		
		if (cNode.val == m) {
			if (parentVal == 0)
				return 0;
			else if (is(cNode.left, m, r, s, 2) != 0)
				return is(cNode.left, m, r, s, 2);
			else
				return is(cNode.right, m, r, s, 2);
		}
		else if (cNode.val == r || cNode.val == s) {
			if (parentVal == 0) {
				if (is(cNode.left, m, r, s, -1) != 0)
					return is(cNode.left, m, r, s, -1);
				else
					return is(cNode.right, m, r, s, -1);
			}
			else if (parentVal == 2)
				return 1;
			else
				return 0;
		}
		else {
			if (is(cNode.left, m, r, s, parentVal) != 0)
				return is(cNode.left, m, r, s, parentVal);
			else
				return is(cNode.right, m, r, s, parentVal);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(4);
		
		root.right = new TreeNode(15);
		root.right.right = new TreeNode(20);
		root.right.right.right = new TreeNode(25);
		root.right.right.left = new TreeNode(17);
		
		int m = 3;
		int r = 10;
		int s = 15;
		
		boolean result = new Q15().isTotallyOrdered(root, m, r, s);
		System.out.println(result);
	}
}
