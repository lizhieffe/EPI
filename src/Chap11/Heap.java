package Chap11;

public class Heap {
	int[] array;
	int size;
	HeapType type;
	
	enum HeapType {
		MAX_HEAP,
		MIN_HEAP;
	}
	
	public Heap(int[] array, HeapType type) {
		this.array = new int[array.length];
		System.arraycopy(array, 0, this.array, 0, array.length);
		this.size = array.length;
		this.type = type;
	}
	
	public void buildHeap() {
		for (int i = parent(size - 1); i >= 0; i --)
			heapify(i);
	}
	
	public int peek() {
		return array[0];
	}
	
	public int pop() {
		swap(0, size - 1);
		size --;
		heapify(0);
		return array[size];
	}
	
	public void insert(int val) {
		if (size == array.length)
			expand();
		size ++;
		array[size - 1] = type == HeapType.MAX_HEAP ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		changeKey(size - 1, val);
	}
	
	private void changeKey(int key, int val) {
		if (key < 0 || key >= size)
			return;
		
		if (type == HeapType.MAX_HEAP) {
			if (array[key] < val) {
				array[key] = val;
				while (parent(key) >= 0 && array[parent(key)] < array[key]) {
					swap(parent(key), key);
					key = parent(key);
				}
			}
			else if (array[key] > val) {
				array[key] = val;
				heapify(key);
			}	
		}
		else {
			if (array[key] > val) {
				array[key] = val;
				while (parent(key) >= 0 && array[parent(key)] > array[key]) {
					swap(parent(key), key);
					key = parent(key);
				}
			}
			else if (array[key] < val) {
				array[key] = val;
				heapify(key);
			}
		}
	}
	
	private void heapify(int i) {
		if (i >= size || i < 0)
			return;
		int cNode = i;
		int left = left(cNode);
		int right = right(cNode);
		
		int extreme = cNode;
		if (left < size && ((array[extreme] > array[left] && type == HeapType.MIN_HEAP) 
				|| (array[extreme] < array[left] && type == HeapType.MAX_HEAP)))
			extreme = left;
		if (right < size && ((array[extreme] > array[right] && type == HeapType.MIN_HEAP) 
				|| (array[extreme] < array[right] && type == HeapType.MAX_HEAP)))
			extreme = right;
		
		if (extreme != cNode) {
			swap(extreme, cNode);
			heapify(extreme);
		}
	}
	
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private int left(int i) {
		return i * 2 + 1;
	}
	
	private int right(int i) {
		return i * 2 + 2;
	}
	
	private void swap(int i, int j) {
		if (i < 0 || j < 0 || i >= size || j >= size || i == j)
			return;
		else {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}
	
	private void expand() {
		int[] tmp = new int[array.length * 2];
		System.arraycopy(array, 0, tmp, 0, array.length);
		this.array = tmp;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2, 0};
//		int[] array = {1, 3, 5};
		
		Heap maxHeap = new Heap(array, HeapType.MAX_HEAP);
		Heap minHeap = new Heap(array, HeapType.MIN_HEAP);
		
		maxHeap.buildHeap();
		minHeap.buildHeap();
		
		maxHeap.insert(15);
		maxHeap.insert(12);
		maxHeap.pop();
		maxHeap.pop();
		maxHeap.insert(15);
		maxHeap.insert(12);

		System.out.println(maxHeap);
		System.out.println(minHeap);
	}
}
