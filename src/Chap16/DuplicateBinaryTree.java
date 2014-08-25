package Chap16;

import Utils.TreeNode;

public class DuplicateBinaryTree {
	public TreeNode duplicate(TreeNode root) {
		if (root == null)
			return null;
		
		TreeNode newRoot = new TreeNode(root.val);
		duplicateNode(root, newRoot);
		return newRoot;
	}
	
	public static TreeNode findCorrespondingNode(TreeNode oldRoot, TreeNode node, TreeNode newRoot) {
		if (oldRoot == null || newRoot == null)
			return null;
		
		if (oldRoot == node)
			return newRoot;
		else {
			TreeNode result = null;
			if (oldRoot.left != null) {
				 TreeNode tmp = findCorrespondingNode(oldRoot.left, node, newRoot.left);
				 if (tmp != null)
					 result = tmp;
			}
			if (oldRoot.right != null) {
				 TreeNode tmp = findCorrespondingNode(oldRoot.right, node, newRoot.right);
				 if (tmp != null)
					 result = tmp;
			}
			return result;
		}
	}
	
	private void duplicateNode(TreeNode oldNode, TreeNode newNode) {
		if (oldNode == null || newNode == null)
			return;
		
		if (oldNode.left != null) {
			TreeNode newLeft = new TreeNode(oldNode.left.val);
			newNode.left = newLeft;
			duplicateNode(oldNode.left, newLeft);
		}
		
		if (oldNode.right != null) {
			TreeNode newRight = new TreeNode(oldNode.right.val);
			newNode.right = newRight;
			duplicateNode(oldNode.left, newRight);
		}
	}
}
