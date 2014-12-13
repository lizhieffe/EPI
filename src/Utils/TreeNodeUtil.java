package Utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtil {
	public static void print(TreeNode node) {
		if (node == null)
			return;
		List<TreeNode> curr = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();
		boolean noNext = false;
		curr.add(node);
		while (curr.size() != 0 && noNext == false) {
			noNext = true;
			for (int i = 0; i < curr.size(); i++) {
				TreeNode c = curr.get(i);
				if (c instanceof NullTreeNode) {
					System.out.print("# ");
					next.add(new NullTreeNode(-1));
					next.add(new NullTreeNode(-1));
				}
				else {
					System.out.print(c.val + " ");
					if (c.left != null || c.right != null)
						noNext = false;
					next.add(c.left == null ? new NullTreeNode(-1) : c.left);
					next.add(c.right == null ? new NullTreeNode(-1) : c.right);
				}
			}
			curr = next;
			next = new ArrayList<TreeNode>();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = null;
		root.left.right = new TreeNode(4);
		print(root);
	}
}

class NullTreeNode extends TreeNode {
	public NullTreeNode(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
}