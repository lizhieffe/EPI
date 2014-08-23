package Chap10;

import java.util.LinkedList;

import Utils.TreeNode;

public class Q14 {
	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	public LinkedList<TreeNode> formLinkedList(TreeNode root) {
		if (root == null)
			return list;
		
		form(root);
		return list;
	}
	
	private void form(TreeNode node) {
		if (node == null)
			return;
		
		if(node.left == null && node.right == null)
			add(node);
		else {
			form(node.left);
			form(node.right);
		}
	}
	
	private void add(TreeNode node) {
		list.add(node);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		
		System.out.println(new Q14().formLinkedList(root));
	}
}
