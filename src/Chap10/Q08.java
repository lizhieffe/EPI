package Chap10;

import Utils.TreeNodeWithSize;

public class Q08 {
	public TreeNodeWithSize findKthNode(TreeNodeWithSize root, int k) {
		if (root == null || k < 0 || k > root.size)
			return null;
		
		if (root.left != null) {
			if (k < root.left.size + 1)
				return findKthNode(root.left, k);
			if (k == root.left.size + 1)
				return root;
			else
				return findKthNode(root.right, k - root.left.size - 2);
		}
		else {
			if (k == 0)
				return root;
			else
				return findKthNode(root.right, k - 1);
		}
	}
	
	public static void main(String[] args) {
		TreeNodeWithSize root = new TreeNodeWithSize(1, 8);
		
		root.left = new TreeNodeWithSize(2, 3);
		root.left.left = new TreeNodeWithSize(3, 2);
		root.left.left.left = new TreeNodeWithSize(4, 0);
		root.left.left.right = new TreeNodeWithSize(5, 0);
		
		root.right = new TreeNodeWithSize(6, 3);
		root.right.right = new TreeNodeWithSize(7, 2);
		root.right.right.right = new TreeNodeWithSize(8, 0);
		root.right.right.left = new TreeNodeWithSize(9, 0);
		
		int k = 1;
		
		Q08 service = new Q08();
		System.out.println(service.findKthNode(root, k).val);
	}
}
