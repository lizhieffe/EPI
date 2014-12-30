package Chap18;

import static org.junit.Assert.*;
import java.util.PriorityQueue;
import org.junit.Test;

public class Q01 {
	public static TreeNode hoffmanCoding(int[] array) {
		if (array == null || array.length == 0)
			return new TreeNode(-1);
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>();
		for (int i = 0; i < array.length; i++)
			pq.add(new TreeNode(array[i]));
		while (true) {
			TreeNode n1 = pq.poll();
			if (pq.size() == 0)
				return n1;
			TreeNode n2 = pq.poll();
			TreeNode newNode = new TreeNode(n1.val + n2.val);
			newNode.left = n1;
			newNode.right = n2;
			pq.add(newNode);
		}
	}
	
	@Test
	public void tc1() {
		int[] array = {1, 2, 3, 4, 5, 6};
		TreeNode result = hoffmanCoding(array);
		assertTrue(result.val == 21);
	}
}

class TreeNode implements Comparable <TreeNode> {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode (int val) { this.val = val; }
	public int compareTo(TreeNode n2) {
		if (val < n2.val)
			return -1;
		if (val > n2.val)
			return 1;
		return 0;
	}
}
