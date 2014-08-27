package Chap16;

import java.util.ArrayList;

import Utils.TreeNode;

public class Q09 {
	
	ArrayList<TreeNode> result;
	int n;
	
	public ArrayList<TreeNode> getAllBinaryTree(int n) {
		if (n == 0)
			return result;
		
		result = new ArrayList<TreeNode>();
		this.n = n;
		
		TreeNode root = new TreeNode(0);
		getAll(root, root, n - 1);
		
		return result;
	}
	
	private void getAll(TreeNode root, TreeNode cNode, int n) {
		if (this.n == root.getNumNodes()) {
			result.add(root);
			return;
		}
		
		if (n <= 0)
			return;
		
		for (int i = 0; i <= n; i ++) {
			DuplicateBinaryTree duplicate = new DuplicateBinaryTree();
			TreeNode newRoot = duplicate.duplicate(root);
			TreeNode newCNode = DuplicateBinaryTree.findCorrespondingNode(root, cNode, newRoot);
			
			if (i != 0) {
				newCNode.left = new TreeNode(0);
				getAll(newRoot, newCNode.left, i - 1);
			}
			
			if (i != n) {
				newCNode.right = new TreeNode(0);
				getAll(newRoot, newCNode.right, n - i - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		Q09 service = new Q09();
		service.getAllBinaryTree(n);
	}
}
