// A priority queue implemented as a Min Heap
public class PriorityQueue {
	private HeapNode head;
	
	public PriorityQueue(HeapNode node) {
		this.head = node;
	}

	public int peek() {
		return this.head.getVal();
	}
	
	public int dequeue() {
		// TODO remove head and re-balance heap then return popped value
		int val = this.peek();
		return val;
	}
	
	public void enqueue(int value) {
		// TODO insert new node with value and balance tree if necessary
	}
	
	private void swapNodes(HeapNode firstNode, HeapNode secondNode) {
		int temp = firstNode.getVal();
		firstNode.setVal(secondNode.getVal());
		secondNode.setVal(temp);
	}
}
