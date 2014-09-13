package Chap16;

import Utils.TreeNode;

public class Q14 {
	int max = Integer.MIN_VALUE;
	
	public int calculateTreeDiameter(TreeNode root) {
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null)
			return 0;
		
		findMaxPathToLeaf(root);
		return max;
	}
	
	private int findMaxPathToLeaf(TreeNode cNode) {
		if (cNode == null)
			return 0;
		
		if (cNode.left == null && cNode.right == null)
			return 0;
		
		int tmpLeft = 0;
		int tmpRight = 0;
		
		if (cNode.left != null) 
			tmpLeft = cNode.left.val + findMaxPathToLeaf(cNode.left);

		if (cNode.right != null)
			tmpRight = cNode.right.val + findMaxPathToLeaf(cNode.right);
		
		if (this.max < tmpLeft + tmpRight)
			this.max = tmpLeft + tmpRight;
		
		return tmpLeft > tmpRight ? tmpLeft : tmpRight;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(314);
		
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(271);
		root.left.left.left = new TreeNode(28);
		root.left.left.right = new TreeNode(0);
		root.left.right = new TreeNode(561);
		root.left.right.right = new TreeNode(3);
		root.left.right.right.left = new TreeNode(17);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(2);
		root.right.left.right = new TreeNode(1);
		root.right.left.right.left = new TreeNode(401);
		root.right.left.right.left.right = new TreeNode(641);
		root.right.left.right.right = new TreeNode(257);
		root.right.right = new TreeNode(271);
		root.right.right.right = new TreeNode(28);
		
		System.out.println(new Q14().calculateTreeDiameter(root));
	}
}
