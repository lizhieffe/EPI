package Chap09;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Utils.TreeNode;

public class Q06R2 {
	public void printInorder(TreeNode root) {
		List<TreeNode> stack = new ArrayList<TreeNode>();
		goThroughLeftChildren(root, stack);
		while (stack.size() > 0) {
			TreeNode node = stack.remove(stack.size() - 1);
			System.out.println(node.val);
			goThroughLeftChildren(node.right, stack);
		}
	}
	
	private void goThroughLeftChildren(TreeNode node, List<TreeNode> stack) {
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
	}
	
	@Test
	public void testcase1() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		Q06R2 test = new Q06R2();
		test.printInorder(root);
	}
}
