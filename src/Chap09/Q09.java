package Chap09;

import java.util.LinkedList;

import Utils.TreeNode;

public class Q09 {
	public void printInOrderOfIncreasingDepth(TreeNode root) {
		if (root == null)
			return;
		
		LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
		
		list1.add(root);
		
		while (list1.size() > 0 || list2.size() > 0) {
			while (list1.size() > 0) {
				TreeNode tmp = list1.removeFirst();
				System.out.print(tmp.val + " ");
				if (tmp.left != null)
					list2.add(tmp.left);
				if (tmp.right != null)
					list2.add(tmp.right);
			}
			if (list2.size() > 0) {
				list1 = new LinkedList<TreeNode>(list2);
				list2.clear();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		
		new Q09().printInOrderOfIncreasingDepth(root);
	}
}
