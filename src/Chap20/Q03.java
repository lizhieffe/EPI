package Chap20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q03 {
	
	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(new PrintOddRunnable());
		ex.execute(new PrintEvenRunnable());
		
	}
}

class PrintOddRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 50; i ++) {
			while (!Helper.shouldBeOdd()) {
				Thread.yield();
			}
			
			System.out.println(i * 2 + 1);
			Helper.changeStatus();
		}	
	}
}

class PrintEvenRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 50; i ++) {
			while (Helper.shouldBeOdd()) {
				Thread.yield();
			}
			
			System.out.println(i * 2 + 2);			
			Helper.changeStatus();
		}	
	}
}

class Helper {
	private volatile static boolean shouldBeOdd = true;
	public static void changeStatus() {
		shouldBeOdd = !shouldBeOdd;
	}
	public static boolean shouldBeOdd() {
		return shouldBeOdd;
	}
}