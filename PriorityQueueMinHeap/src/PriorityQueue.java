import java.util.*;
import java.lang.Integer;

// A priority queue implemented as a min heap with an ArrayList
public class PriorityQueue {
	private ArrayList<Integer> heap;
	
	// Constructor for empty Queue
	public PriorityQueue() {
		this.heap = new ArrayList<Integer>();
	}

	public int peek() {
		if(heap.size() < 1) {
			return -1;
		}
		return heap.get(0);
	}
	
	public int dequeue() {
		// Make sure Queue is non-empty
		if(heap.size() < 1) {
			return -1;
		}
		
		// Head value
		int val = this.peek();
		
		// If there is only one item in Queue,
		// remove it and return the value
		if(heap.size() == 1) {
			heap.remove(0);
			return val;
		}
		
		// Set head value to last value in heap
		// then remove last value
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		// Balance heap by moving root value into appropriate position
		int current = 0;
		while(current < heap.size()) {
			// Position of current's left child
			int left = 2 * current + 1;
			
			// Stop if current is a leaf node
			// or if current is <= its children
			
			// Check if current has left child only,
			// and if so check their order
			if(left < heap.size() && left+1 >= heap.size()
					&& (heap.get(left) < heap.get(current))) {
				swap(current, left);
				current = heap.size();
			}
			else if(left >= heap.size() || left+1 >= heap.size() || 
					(heap.get(current) <= heap.get(left) && 
					heap.get(current) <= heap.get(left+1))) {
				current = heap.size();
			}
			// Current value is > one of its child values
			// and must be swapped with smaller child
			else {
				// Check if current has right child and if its smaller 
				// than the left child
				if(left+1 < heap.size() && heap.get(left+1) < heap.get(left)) {
					swap(current, left+1);
					current = left+1;
				}
				else {
					swap(current, left);
					current = left;
				}
			}
		}
		return val;
	}
	
	// Adds value to PriorityQueue
	public void enqueue(int value) {
		//  Add value to end of heap
		heap.add(value);
		
		// Swap the inserted value with its parent if it is < parent
		// repeat until value percolates to correct position in heap
		int i = heap.size()-1;
		while(i > 0) {
			int parentIndex = ((i-1)/2);
			if(heap.get(i) < heap.get(parentIndex)) {
				swap(i, parentIndex);
				i = parentIndex;
			}
			else {
				i = 0;
			}
		}
	}
	
	public int size() {
		return heap.size();
	}
	
	// Swaps elements in heap
	private void swap(int firstIndex, int secondIndex) {
		int temp = this.heap.get(firstIndex);
		this.heap.set(firstIndex, this.heap.get(secondIndex));
		this.heap.set(secondIndex, temp);
	}
	
	// Used to see contents of heap in priorityQueueDemo()
	private void printHeap() {
		System.out.println(this.heap);
	}
	
	// Used in main to demonstrate PriorityQueue
	private static void priorityQueueDemo(int[] values) {
		PriorityQueue q = new PriorityQueue();
		for(int i = 0; i < values.length; i++) {
			q.enqueue(values[i]);
		}
		int stop = q.size();
		for(int i = 0; i < stop; i++) {
			q.printHeap();
			System.out.println(q.dequeue());
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1,3,5,3,2,9};
		priorityQueueDemo(a);
		System.out.println();
		
		a = new int[] {1,2,3,4,5};
		priorityQueueDemo(a);
		System.out.println();
		
		a = new int[] {9,7,5,3,2,1};
		priorityQueueDemo(a);
		System.out.println();
		
		a = new int[] {1,3,5,3,2,9};
		priorityQueueDemo(a);
		System.out.println();
		
		a = new int[] {5,20,10,30,4,3,9,29,2};
		priorityQueueDemo(a);
	}
}
