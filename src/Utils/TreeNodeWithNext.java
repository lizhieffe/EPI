package Utils;

public class TreeNodeWithNext {

	public int val;
	public TreeNodeWithNext left;
	public TreeNodeWithNext right;
	public TreeNodeWithNext next;
	public TreeNodeWithNext(int x) { val = x; }
	
	public int getNumNodes() {
		int result = 1;
		if (this.left != null)
			result += this.left.getNumNodes();
		if (this.right != null)
			result += this.right.getNumNodes();
		return result;
	}
}
