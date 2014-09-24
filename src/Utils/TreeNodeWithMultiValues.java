package Utils;

public class TreeNodeWithMultiValues {

	public int val0;
	public int val1;
	public TreeNodeWithMultiValues left;
	public TreeNodeWithMultiValues right;
	public TreeNodeWithMultiValues next;
	
	public TreeNodeWithMultiValues(int v0, int v1) {
		this.val0 = v0;
		this.val1 = v1;
	}
	
	public int getNumNodes() {
		int result = 1;
		if (this.left != null)
			result += this.left.getNumNodes();
		if (this.right != null)
			result += this.right.getNumNodes();
		return result;
	}
}
