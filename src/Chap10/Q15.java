package Chap10;

import java.util.ArrayList;

import Utils.TreeNode;

public class Q15 {
	
	ArrayList<Integer> left;
	ArrayList<Integer> bottom;
	ArrayList<Integer> right;
	
	public void printExterior(TreeNode root) {
		if (root == null)
			return;
		
		left = new ArrayList<Integer>();
		bottom = new ArrayList<Integer>();
		right = new ArrayList<Integer>();

		findLeft(root);
		findBottom(root);
		findRight(root);
		
		for (int i = 0; i < left.size(); i ++)
			System.out.print(left.get(i) + " ");
		
		for (int i = 1; i < bottom.size() - 1; i ++)
			System.out.print(bottom.get(i) + " ");

		for (int i = 0; i < right.size() - 1; i ++)
			System.out.print(right.get(right.size() - i - 1) + " ");
	}
	
	private void findLeft(TreeNode cNode) {
		if (cNode == null)
			return;
		
		left.add(cNode.val);
		
		if (cNode.left != null)
			findLeft(cNode.left);
		else if (cNode.right != null)
			findLeft(cNode.right);
	}
	
	private void findRight(TreeNode cNode) {
		if (cNode == null)
			return;
		
		right.add(cNode.val);
		
		if (cNode.right != null)
			findRight(cNode.right);
		else if (cNode.left != null)
			findRight(cNode.left);
	}
	
	private void findBottom(TreeNode cNode) {
		if (cNode == null)
			return;
		
		if (cNode.left == null && cNode.right == null)
			bottom.add(cNode.val);
		else {
			findBottom(cNode.left);
			findBottom(cNode.right);
		}
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
		
		new Q15().printExterior(root);
	}
}
