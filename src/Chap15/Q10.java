package Chap15;

import Utils.TreeNode;

public class Q10 {
	
	int[] array;
	
	public TreeNode buildTree(int[] array) {
		if (array == null || array.length == 0)
			return null;
		
		if (array.length == 1)
			return new TreeNode(array[0]);
		
		this.array = array;		
		TreeNode root = build(0, array.length);
		
		return root;
	}
	
	private TreeNode build(int beg, int end) {
		if (beg >= end || beg >= array.length || end <= 0)
			return null;
		
		int mid = beg + (end - beg) / 2;
		TreeNode cNode = new TreeNode(array[mid]);
		if (end - beg > 1) {
			cNode.left = build(beg, mid);
			cNode.right = build(mid + 1, end);
		}
		
		return cNode;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		TreeNode root = new Q10().buildTree(array);
		System.out.println(root);
	}
}
