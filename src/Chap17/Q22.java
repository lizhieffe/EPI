package Chap17;

import Utils.TreeNodeWithMultiValues;

public class Q22 {
	public int getMinCost(TreeNodeWithMultiValues root) {
		if (root == null)
			return 0;
		else
			return Math.min(get(root, 0), get(root, 1));
	}
	
	private int get(TreeNodeWithMultiValues cNode, int type) {
		/*
		 * type == 0 -> cNode use low voltage
		 * type == 1 -> cNode use high voltage
		 */
		
		if (type == 0) {
			if (cNode.val0 != -1)
				return cNode.val0;
			else {
				int tmp = 1;
				if (cNode.left != null)
					tmp += 1 + get(cNode.left, 1);
				if (cNode.right != null)
					tmp += 1 + get(cNode.right, 1);
				cNode.val0 = tmp;
				return tmp;
			}
		} else {
			if (cNode.val1 != -1)
				return cNode.val1;
			else {
				int tmp = 2;
				if (cNode.left != null)
					tmp += 2 + Math.min(get(cNode.left, 0), get(cNode.left, 1));
				if (cNode.right != null)
					tmp += 2 + Math.min(get(cNode.right, 0), get(cNode.right, 1));
				
				cNode.val1 = tmp;
				return tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNodeWithMultiValues root = new TreeNodeWithMultiValues(-1, -1);
		root.left = new TreeNodeWithMultiValues(-1, -1);
		root.left.left = new TreeNodeWithMultiValues(-1, -1);
		root.left.right = new TreeNodeWithMultiValues(-1, -1);
		root.right = new TreeNodeWithMultiValues(-1, -1);
		
		System.out.println(new Q22().getMinCost(root));
	}
}
