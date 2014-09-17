package Chap10;

import java.util.LinkedList;

import Utils.TreeNode;

public class Q10 {
	
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	LinkedList<Type> typeStack = new LinkedList<Type>();
	
	public void preorder(TreeNode root) {
		goAllWayDownLeftForPreorder(root);
		
		while (stack.size() > 0) {
			TreeNode cNode = stack.removeLast();
			goAllWayDownLeftForPreorder(cNode.right);
		}
	}
	
	private void goAllWayDownLeftForPreorder(TreeNode cNode) {
		while (cNode != null) {
			System.out.println(cNode.val);
			stack.add(cNode);
			cNode = cNode.left;
		}
	}
	
	public void postorder(TreeNode root) {
		goAllWayDownLeftForPostorder(root);
		
		while (typeStack.size() > 0) {
			if (typeStack.getLast().type == 0) {
				typeStack.getLast().type = 1;
				goAllWayDownLeftForPostorder(typeStack.getLast().node.right);
			}
			else {
				Type tmp = typeStack.removeLast();
				System.out.println(tmp.node.val);
			}
		}
	}
	
	private void goAllWayDownLeftForPostorder(TreeNode cNode) {
		while (cNode != null) {
			typeStack.add(new Type(cNode, 0));
			cNode = cNode.left;
		}
	}
	
	private class Type {
		TreeNode node;
		int type;
		Type(TreeNode node, int type) {
			this.node = node;
			this.type = type;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		
		new Q10().postorder(root);
	}
}
