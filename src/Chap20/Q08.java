package Chap20;

import org.junit.Test;

public class Q08 {
	Object writeLock = new Object();
	Object writeRequestLock = new Object();
	Object readLock = new Object();
	int readCount = 0;
	int writeRequestCount = 0;
	
	public void read(int time) {
		try {
			synchronized(readLock) {
				while (writeRequestCount > 0) {
					readLock.wait();
				}
				readCount++;
			}
			System.out.println("Reading...");
			Thread.sleep(time);
			System.out.println("Read Finished");
			synchronized(readLock) {
				readCount--;
				readLock.notifyAll();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(int time) {
		synchronized(writeRequestLock) {
			writeRequestCount++;
		}
		synchronized(writeLock) {
			synchronized(readLock) {
				try {
					while (readCount > 0)
						readLock.wait();
					synchronized(writeRequestLock) {
						writeRequestCount--;
					}
					System.out.println("Writing...");
					Thread.sleep(time);
					System.out.println("Write Finished");
					readLock.notifyAll();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readInNewThread(final Q08 q, final int time) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				q.read(time);
			}
		};
		new Thread(task).start();
	}
	
	public static void writeInNewThread(final Q08 q, final int time) {
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
		Q08 tc = new Q08();
		writeInNewThread(tc, 2000);
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
