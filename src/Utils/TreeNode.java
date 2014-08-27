package Utils;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	public int getNumNodes() {
		int result = 1;
		if (this.left != null)
			result += this.left.getNumNodes();
		if (this.right != null)
			result += this.right.getNumNodes();
		return result;
	}
}
