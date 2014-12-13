package Chap15;

import Utils.TreeNode;
import Utils.TreeNodeUtil;

public class Q14 {
	TreeNode root;
	public Q14(TreeNode root) {
		this.root = root;
	}
	public boolean contains(int val) {
		return contains(val, root);
	}
	private boolean contains(int val, TreeNode node) {
		return (getNode(val, node)) == null ? false : true;
	}
	public TreeNode getNode(int val) {
		return getNode(val, root);
	}
	private TreeNode getNode(int val, TreeNode node) {
		if (node == null)
			return null;
		if (node.val == val)
			return node;
		if (node.val > val)
			return getNode(val, node.left);
		else
			return getNode(val, node.right);
	}
	public void insert(int val) {
		if (root == null) {
			root = new TreeNode(val);
			return;
		}
		TreeNode curr = root;
		while (true) {
			if (curr.val == val)
				return;
			if (curr.val > val) {
				if (curr.left == null) {
					curr.left = new TreeNode(val);
					return;
				}
				else
					curr = curr.left;
			}
			else {
				if (curr.right == null) {
					curr.right = new TreeNode(val);
					return;
				}
				else
					curr = curr.right;
			}
		}
	}
	public void delete(int val) {
		if (root == null)
			return;
		TreeNode dummy = new TreeNode(-1);
		dummy.left = root;
		TreeNode par = dummy;
		TreeNode curr = root;
		while (curr.val != val) {
			if (curr.val > val && curr.left != null) {
				par = curr;
				curr = curr.left;
				continue;
			}
			else if (curr.val < val && curr.right != null) {
				par = curr;
				curr = curr.right;
				continue;
			}
			return;
		}
		// the right child is null (including the condition that it is a leaf)
		if (curr.right == null) {
			replaceChild(par, curr, curr.left);
			return;
		}
		TreeNode rPar = curr;
		TreeNode rCurr = curr.right;
		while (rCurr.left != null) {
			rPar = rCurr;
			rCurr = rCurr.left;
		}
		if (rCurr == curr.right) {
			rCurr.left = curr.left;
			replaceChild(par, curr, rCurr);
			return;
		}
		rPar.left = rCurr.right;
		replaceChild(par, curr, rCurr);
		rCurr.left = curr.left;
		rCurr.right = curr.right;
	}
	private void replaceChild(TreeNode par, TreeNode oldChild, TreeNode newChild) {
		if (par == null)
			return;
		if (par.left == oldChild) {
			par.left = newChild;
			return;
		}
		if (par.right == oldChild) {
			par.right = newChild;
			return;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		Q14 service = new Q14(root);
		service.insert(-1);
		service.delete(2);
		TreeNodeUtil.print(root);
	}
}
