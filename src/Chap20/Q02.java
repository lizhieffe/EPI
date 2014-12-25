package Chap20;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Q02 {
	public static void main(String[] args) {
		Timer1 timer = new Timer1();
		ExecutorService exec = Executors.newCachedThreadPool();		
		exec.execute(timer);
		timer.addTask("task 1", 500);
		timer.addTask("task 2", 1500);
		timer.addTask("task 3", 2500);
		timer.addTask("task 4", 3500);
		timer.addTask("task 5", 4500);
		timer.removeTask("task 2");

		try {
			TimeUnit.SECONDS.sleep(10);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
	}
}

class Timer1 implements Runnable {
	final private int capacity = 10;
	
	private Map<String, Task> tasks = new HashMap<String, Task>();
	private PriorityQueue<Task> pq = new PriorityQueue<Task>(capacity, new TaskComparator());
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized(this) {
					while (pq.size() == 0 || (pq.size() > 0 && pq.peek().getTimestamp() > TimeUtil.getUnixtime())) {
						long waitTime = 2000;
						if (pq.size() > 0)
							waitTime = pq.peek().getTimestamp() - TimeUtil.getUnixtime();
						wait(waitTime);
					}
					Task currTask = pq.poll();
					tasks.remove(currTask.getName());
					currTask.run();
				}
			}
		}
		catch (Exception e) {
			System.out.println("Timer is interrupted");
		}
	}
	
	public synchronized void addTask(String name, long ms) {
		if (ms < 0 || name == null || name.length() == 0)
			return;
		if (!tasks.containsKey(name)) {
			Task task = new Task(name, ms + TimeUtil.getUnixtime());
			tasks.put(name, task);
			pq.add(task);
		}
		else {
			Task task = tasks.remove(name);
			pq.remove(task);
			task.setTimestamp(ms + TimeUtil.getUnixtime());
			tasks.put(name, task);
			pq.add(task);
		}
		notifyAll();
	}
	
	public synchronized void removeTask(String name) {
		if (tasks.containsKey(name)) {
			pq.remove(tasks.remove(name));
			notifyAll();
		}
	}
}

class Task implements Runnable {
	private static int count = 0;
	private static Random rand = new Random(47);
	private final int id;
	private long timestamp;
	private final String name;
	
	public Task(String name, long timestamp) {
		id = getCount();
		increaseCount();
		this.name = name;
		this.timestamp = timestamp;
	}
	
	public synchronized static int getCount() {
		return count;
	}
	
	public synchronized static void increaseCount() {
		count++;
	}
	
	public synchronized void setTimestamp(long t) {
		this.timestamp = t;
	}
	
	public synchronized long getTimestamp() {
		return this.timestamp;
	}
	
	public synchronized String getName() {
		return this.name;
	}
	
	@Override
	public void run() {
		long currTime = TimeUtil.getUnixtime();
		System.out.println("Task " + name + "(" + id + ") is running!");
		System.out.println("current time = " + currTime + " , it is supposed to run at " + timestamp + ", diff = " + (currTime - timestamp));
		try {
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class TaskComparator implements Comparator <Task> {
	@Override
	public int compare(Task o1, Task o2) {
		if (o1.getTimestamp() < o2.getTimestamp())
			return -1;
		if (o1.getTimestamp() > o2.getTimestamp())
			return 1;
		return 0;
	}
}

class TimeUtil {
	public static long getUnixtime() {
		return System.currentTimeMillis();
	}
}