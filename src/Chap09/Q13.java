package Chap09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q13 {
	List<Integer> stack1 = new ArrayList<Integer>();
	List<Integer> stack2 = new ArrayList<Integer>();
	
	public void enqueue(int val) {
		stack1.add(val);
		if (stack2.size() == 0 || getMax() <= val)
			stack2.add(val);
	}
	
	public int dequeue() {
		if (stack1.size() == 0)
			return Integer.MIN_VALUE;
		int val = stack1.remove(stack1.size() - 1);
		if (val == getMax())
			stack2.remove(stack2.size() - 1);
		return val;
	}
	
	public int getMax() {
		if (stack2.size() == 0)
			return Integer.MIN_VALUE;
		return stack2.get(stack2.size() - 1);
	}
	
	@Test
	public void tc1() {
		Q13 tc = new Q13();
		tc.enqueue(1);
		tc.enqueue(2);
		assertTrue(tc.getMax() == 2);
		tc.enqueue(3);
		assertTrue(tc.dequeue() == 3);
		assertTrue(tc.getMax() == 2);
	}
}
