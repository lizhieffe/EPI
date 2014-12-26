package Chap10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q12 {
	public TreeNode recoverBinaryTreeFromInorderAndPreorder(int[] inorder, int[] preorder) {
		if (inorder == null || preorder == null || inorder.length == 0 || inorder.length != preorder.length)
			return null;
		return recoverBinaryTreeFromInorderAndPreorder(inorder, 0, inorder.length - 1, preorder, 0, inorder.length - 1);
	}
	
	private TreeNode recoverBinaryTreeFromInorderAndPreorder(int[] inorder, int inBeg, int inEnd, int[] preorder, int preBeg, int preEnd) {
		if (inBeg > inEnd)
			return null;
		if (inBeg == inEnd)
			return new TreeNode(inorder[inBeg]);
		int rootVal = preorder[preBeg];
		int inRootIndex = -1;
		for (int i = inBeg; i <= inEnd; i++)
			if (inorder[i] == rootVal)
				inRootIndex = i;
		int leftLength = inRootIndex - inBeg;
//		int rightLength = inEnd - inRootIndex;
		TreeNode root = new TreeNode(rootVal);
		root.left = recoverBinaryTreeFromInorderAndPreorder(inorder, inBeg, inRootIndex - 1, preorder, preBeg + 1, preBeg + leftLength);
		root.right = recoverBinaryTreeFromInorderAndPreorder(inorder, inRootIndex + 1, inEnd, preorder, preBeg + leftLength + 1, preEnd);
		return root;
	}
	
	@Test
	public void test1() {
		int[] inorder = {5, 1, 0, 4, 7, 2, 3, 8, 6};
		int[] preorder = {7, 1, 5, 4, 0, 2, 3, 6, 8};
		Q12 testcase = new Q12();
		TreeNode result = testcase.recoverBinaryTreeFromInorderAndPreorder(inorder, preorder);
		assertTrue(result.val == 7);
		assertTrue(result.left.val == 1);
		assertTrue(result.right.val == 2);
	}
}
