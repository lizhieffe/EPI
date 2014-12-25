package Chap20;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q06 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.add(new CalendarRunnable("a"));
		timer.add(new CalendarRunnable("b"));
		timer.add(new CalendarRunnable("c"));
		timer.remove("b");
		timer.run("a");
		timer.run("b");
		timer.run("c");
	}
}

class Timer {
	Map<String, CalendarRunnable> tasks = new HashMap<String, CalendarRunnable>();
	ExecutorService ex = Executors.newCachedThreadPool();
	
	public void add(CalendarRunnable runnable) {
		tasks.put(runnable.getName(), runnable);
	}
	
	public void run(String name) {
		if (tasks.containsKey(name))
			ex.execute(tasks.remove(name));
	}
	
	public void remove(String name) {
		if (tasks.containsKey(name))
			tasks.remove(name);
	}
}

class CalendarRunnable implements Runnable {

	CalendarRunnable(String name) {
		this.name = name;
	}
	
	final private String name;
	
	@Override
	public void run() {
		System.out.println(name + " is running");
	}
	
	public String getName() { return name; }
}
