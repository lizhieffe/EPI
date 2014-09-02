package Chap10;

import Utils.TreeNode;

public class Q06 {
	int result = 0;
	
	public int calculateSum(TreeNode root) {
		calculate(root, 0);
		return result;
	}
	
	private void calculate(TreeNode node, int solution) {
		if (node == null)
			return;
		
		int tmpSolution = (solution << 1) + node.val;
		if (node.left == null && node.right == null)
			result += tmpSolution;
		
		calculate(node.left, tmpSolution);
		calculate(node.right, tmpSolution);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(1);
		
		root.right = new TreeNode(0);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(1);
		
		System.out.println(new Q06().calculateSum(root));
	}
}
