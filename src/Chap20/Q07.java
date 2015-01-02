package Chap20;

import org.junit.Test;

public class Q07 {
	Object writeLock = new Object();
	Object readLock = new Object();
	int readCount = 0;
	
	public void read(int time) {
		synchronized(readLock) {
			readCount++;
		}
		try {
			System.out.println("Reading...");
			Thread.sleep(time);
			System.out.println("Read Finished");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		synchronized(readLock) {
			readCount--;
			readLock.notifyAll();
		}
	}
	
	synchronized public void write(int time) {
		synchronized(readLock) {
			try {
				while (readCount > 0)
					readLock.wait();
				System.out.println("Writing...");
				Thread.sleep(time);
				System.out.println("Write Finished");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readInNewThread(final Q07 q, final int time) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				q.read(time);
			}
		};
		new Thread(task).start();
	}
	
	public static void writeInNewThread(final Q07 q, final int time) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				q.write(time);
			}
		};
		new Thread(task).start();
	}
	
	@Test
	public void tc1() {
		Q07 tc = new Q07();
		writeInNewThread(tc, 1000);
		readInNewThread(tc, 1000);
		readInNewThread(tc, 1000);
		readInNewThread(tc, 1000);
		writeInNewThread(tc, 1000);
		writeInNewThread(tc, 1000);

		try {
			Thread.sleep(100000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
