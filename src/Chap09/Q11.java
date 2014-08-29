package Chap09;

public class Q11 {
	int[] queue;
	int size;
	int start, end;
	
	public Q11(int initialSize) {
		this.queue = new int[initialSize <= 0 ? 1 : initialSize];
		size = 0;
		start = -1;
		end = -1;
	}
	
	public void enqueue(int val) {
		if (size < queue.length) {
			if (size == 0)
				start = getNextIndex(start);
			end = getNextIndex(end);
			queue[end] = val;
			size ++;
		}
		else {
			int[] newQueue = new int[queue.length * 2];
			int cIndex = start;
			int i = 0;
			while (cIndex != end) {
				newQueue[i ++] = queue[cIndex];
				cIndex = getNextIndex(cIndex);
			}
			newQueue[i ++] = queue[cIndex];
			newQueue[i] = val;
			queue = newQueue;
			size ++;
			start = 0;
			end = size - 1;
		}
	}
	
	public int dequeue() {
		if (size == 0)
			return Integer.MAX_VALUE;
		
		int result = queue[start];
		start = getNextIndex(start);
		size --;
		
		if (size == 0) {
			start = -1;
			end = -1;
		}
		
		return result;
	}
	
	private int getNextIndex(int index) {
		if (index == -1)
			return 0;
		else if (index == queue.length - 1)
			return 0;
		else
			return index + 1;
	}
	
	public static void main(String[] args) {
		Q11 service = new Q11(2);
		service.enqueue(2);
		service.enqueue(3);
		System.out.println(service.dequeue());
		service.enqueue(1);
		service.enqueue(4);
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());
		service.enqueue(5);
		service.enqueue(6);
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());

	}
}
