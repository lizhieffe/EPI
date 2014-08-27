package Chap15;

import Utils.TreeNode;

public class Q12 {
	public TreeNode toList(TreeNode root) {
		if (root == null)
			return null;
		
		return getBegNEnd(root)[0];
	}
	
	private TreeNode[] getBegNEnd(TreeNode cNode) {
		if (cNode == null)
			return null;
		
		TreeNode[] result = new TreeNode[2];
		
		if (cNode.left == null)
			result[0] = cNode;
		else {
			TreeNode[] tmp = getBegNEnd(cNode.left);
			result[0] = tmp[0];
			tmp[1].right = cNode;
			cNode.left = tmp[1];
		}
		
		if (cNode.right == null)
			result[1] = cNode;
		else {
			TreeNode[] tmp = getBegNEnd(cNode.right);
			result[1] = tmp[1];
			tmp[0].left = cNode;
			cNode.right = tmp[0];
		}
		
		return result;
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
		
		TreeNode result = new Q12().toList(root);
		System.out.println(result);
	}
}
