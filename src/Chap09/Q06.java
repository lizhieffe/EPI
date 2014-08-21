package Chap09;

import java.util.LinkedList;

import Utils.TreeNode;

public class Q06 {
	public void printInOrder(TreeNode root) {
		if (root == null)
			return;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		
		goThroughLeft(root, stack);
		while (stack.size() > 0) {
			TreeNode cNode = stack.removeLast();
			System.out.print(cNode.val + " ");
			goThroughLeft(cNode.right, stack);
		}
	}
	
	private void goThroughLeft(TreeNode cNode, LinkedList<TreeNode> stack) {
		if (cNode == null)
			return;
		stack.add(cNode);
		while (cNode.left != null) {
			cNode = cNode.left;
			stack.add(cNode);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		
		Q06 service = new Q06();
		service.printInOrder(root);
		
	}
}
