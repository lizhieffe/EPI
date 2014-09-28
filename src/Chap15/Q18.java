package Chap15;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;

public class Q18 {
	
	List<Integer> result = new ArrayList<Integer>();
	
	public List<Integer> rangeQuery(TreeNode root, int l, int u) {
		find(root, l, u);
		return result;
	}
	
	private void find(TreeNode cNode, int l, int u) {
		if (cNode == null)
			return;
		if (cNode.val >= l && cNode.val <= u) {
			result.add(cNode.val);
			find(cNode.left, l, u);
			find(cNode.right, l, u);
		}
		else if (cNode.val < l)
			find(cNode.right, l, u);
		else
			find(cNode.left, l, u);			
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(4);
		
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(30);
		root.right.right.right = new TreeNode(40);
		root.right.right.left = new TreeNode(35);
		
		int l = 4;
		int u = 35;
		new Q18().rangeQuery(root, l, u);
	}
}
