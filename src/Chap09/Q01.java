package Chap09;

import java.util.LinkedList;

public class Q01 {
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<MaxTimes> max = new LinkedList<MaxTimes>();
	
	void push(int x) {
		stack.add(x);
		
		if (max.size() == 0)
			max.add(new MaxTimes(x));
		else {
			if (x == max.getFirst().val)
				max.getLast().times ++;
			else if (x > max.getLast().val)
				max.add(new MaxTimes(x));
		}
	}
	
	Integer pop() {
		if (stack.size() == 0)
			return null;
		else {
			if (stack.getLast() == max.getLast().val) {
				if (max.getLast().times == 1)
					max.removeLast();
				else
					max.getLast().times --;
			}
			return stack.removeLast();
		}
	}
	
	Integer getMax() {
		if (stack.size() == 0)
			return null;
		else
			return max.getLast().val;
	}
	
	class MaxTimes {
		int val;
		int times;
		
		MaxTimes(int val) {
			this.val = val;
			this.times = 1;
		}
	}
	
	public static void main(String[] args) {
		Q01 service = new Q01();
		
		service.push(1);
		System.out.println(service.getMax());
		
		service.push(1);
		System.out.println(service.getMax());
		
		service.push(2);
		System.out.println(service.getMax());
		
		service.pop();
		System.out.println(service.getMax());
		
		service.push(3);
		System.out.println(service.getMax());
	}
}
