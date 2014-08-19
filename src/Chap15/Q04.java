package Chap15;

import Utils.TreeNode;

public class Q04 {
	int k;
	
	public void printKLargest(TreeNode node, int k) {
		this.k = k;
		print(node);
	}
	
	private void print(TreeNode node) {
		if (node == null || k <= 0)
			return;
		
		print(node.right);
		
		if (k > 0) {
			System.out.println(node.val + ", ");
			k --;
		}

		print(node.left);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		
		int k = 2;
		
		Q04 service = new Q04();
		service.printKLargest(root, k);
	}
}
