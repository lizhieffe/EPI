package Chap09;

import java.util.LinkedList;

public class Q12 {
	
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	LinkedList<Integer> l2 = new LinkedList<Integer>();
	
	public void enqueue(int i) {
		l1.add(i);
	}
	
	public int dequeue() {
		if (l1.size() == 0 && l2.size() == 0)
			return Integer.MAX_VALUE;
		if (l2.size() == 0)
			while (l1.size() > 0)
				l2.add(l1.remove());
		return l2.remove();
	}
	
	public static void main(String[] args) {
		Q12 service = new Q12();
		service.enqueue(2);
		service.enqueue(3);
		service.enqueue(4);
		System.out.println(service.dequeue());
		service.enqueue(5);
		service.enqueue(6);
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());
		System.out.println(service.dequeue());

	}
}
