package Chap20;

import org.junit.Test;

public class Q10 {
	private static int SIZE = 2;
	int[] array = new int[SIZE];
	private int count = 0;
	synchronized public void add(int val) {
		try {
			while (count >= SIZE) {
				wait();
			}
			array[count++] = val;
			notifyAll();
			System.out.println("add successfully. count = " + count);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized public void remove() {
		try {
			while (count == 0) {
				wait();
			}
			array[--count] = -1;
			notifyAll();
			System.out.println("remove successfully. count = " + count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void tc1() {
//		Q10 tc = new Q10();
//		tc.add(1);
//		tc.add(2);
//		tc.add(3);
//	}
	
	@Test
	public void tc2() {
		final Q10 tc = new Q10();
		Runnable addTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					tc.add(i);
				}
			}
		};
		Runnable substractTask = new Runnable() {
			public void run() {
				try {
//					Thread.sleep(100);
					for (int i = 0; i < 10; i++) {
						tc.remove();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(addTask).start();
		new Thread(substractTask).start();
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			
		}
	}
}
