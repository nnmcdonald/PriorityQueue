// Each node has an integer value and at most 2 children nodes
public class HeapNode {
	private HeapNode left;
	private HeapNode right;
	private int value;
	
	// Constructor for a new node
	public HeapNode(int val) {
		this.value = val;
		this.left = null;
		this.right = null;
	}
	
	public int getVal() {
		return this.value;
	}
	
	public void setVal(int value) {
		this.value = value;
	}
	
	public HeapNode getLeft() {
		return this.left;
	}
	
	public HeapNode getRight() {
		return this.right;
	}
	
	public void setRight(HeapNode node) {
		this.right = node;
	}
	
	public void setLeft(HeapNode node) {
		this.left = node;
	}

}
