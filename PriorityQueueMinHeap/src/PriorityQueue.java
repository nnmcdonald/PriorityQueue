import java.util.*;
import java.lang.Integer;

// A priority queue implemented as a min heap with an ArrayList
public class PriorityQueue {
	private ArrayList<Integer> heap;
	private int heapSize;
	
	public PriorityQueue(int headValue) {
		this.heap = new ArrayList<Integer>();
		this.heap.add(headValue);
		this.heapSize = 1;
	}

	public int peek() {
		return this.heap.get(0);
	}
	
	public int dequeue() {
		// TODO remove head and re-balance heap then return popped value
		int val = this.peek();
		return val;
	}
	
	// Adds value to PriorityQueue
	public void enqueue(int value) {
		//  Add value to end of heap
		heap.add(value);
		
		// Swap the inserted value with its parent if it is < parent
		// repeat until value percolates to correct position in heap
		int i = this.heapSize;
		while(i > 0) {
			int parentIndex = ((i-1)/2);
			if(heap.get(i) < heap.get(parentIndex)) {
				swap(i, parentIndex);
				i = parentIndex;
			}
			else {
				break;
			}
		}
		heapSize++;
	}
	
	private void swap(int firstIndex, int secondIndex) {
		int temp = this.heap.get(firstIndex);
		this.heap.set(firstIndex, this.heap.get(secondIndex));
		this.heap.set(secondIndex, temp);
	}
}
