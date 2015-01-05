package Chap21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q09FakeMasterNode {

	final private int slavesNum;
	private List<Q09FakeSlaveNode> slaves;
	private PriorityQueue<Q09Job> pq;
	private Map<Integer, Q09Job> jobList;
	
	/*
	 * use different thread to mimic the slave nodes
	 */
	ExecutorService executor;
	
	public Q09FakeMasterNode(int slavesNum) {
		this.slavesNum = slavesNum;
		slaves = new ArrayList<Q09FakeSlaveNode>();
		for (int i = 0; i < this.slavesNum; i++)
			slaves.add(new Q09FakeSlaveNode());
		this.executor = Executors.newFixedThreadPool(slavesNum);
		this.pq = new PriorityQueue<Q09Job>(slavesNum);
		this.jobList = new HashMap<Integer, Q09Job>();
	}
	
	public void startServer() {
		for (Q09FakeSlaveNode slave : slaves) {
			slave.setMasterNode(this);
			slave.startServer();
		}
		this.await();
	}
	
	private void await() {
		while (true) {
			System.out.println("Please specify action: add(a), delete(d), or get most important job (g);");
			Scanner sc = new Scanner(System.in);
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("a")) {
				System.out.println("Please input Job Id and Priority:");
				command = sc.nextLine();
				String[] s = command.split(" ");
				if (s.length < 2) {
					System.out.println("Incorrect Job Id or Priority format");
					continue;
				}
				try {
					int jobId = Integer.parseInt(s[0]);
					int priority = Integer.parseInt(s[1]);
					this.addJob(new Q09Job(jobId, priority));
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Incorrect Job Id or Priority format");
					continue;
				}
			}
			else if (command.equalsIgnoreCase("d")) {
				System.out.println("Please input Job Id:");
				command = sc.nextLine();
				try {
					int jobId = Integer.parseInt(command);
					this.deleteJob(jobId);
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Incorrect Job Id or Priority format");
					continue;
				}
			}
			else if (command.equalsIgnoreCase("g")) {
				this.getMostImportantJob();
			}
			else {
				System.out.println("Incorrect command");
			}
		}
	}
	
	public boolean addJob(final Q09Job job) {
		final Q09FakeSlaveNode slave = getSlaveNode(job.getJobId());
		
		if (slave == null) {
			System.out.println("Invalid Job Id: " + job.getJobId());
			return false;
		}
		
		Callable<Boolean> task = new Callable<Boolean>() {
			public Boolean call() {
				return slave.addJob(job);
			}
		};
		Future<Boolean> result = executor.submit(task);
		try {
			if (result.get() == true) {
				System.out.println("Job [id = " + job.getJobId() + "] is added in " + this.toString());
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Job [id = " + job.getJobId() + "] is NOT added in " + this.toString());
		return false;
	}
	
	public boolean deleteJob(final int jobId) {	
		final Q09FakeSlaveNode slave = getSlaveNode(jobId);
		
		if (slave == null) {
			System.out.println("Invalid Job Id: " + jobId);
			return false;
		}
		
		Callable<Boolean> task = new Callable<Boolean>() {
			public Boolean call() {
				return slave.deleteJob(jobId);
			}
		};
		Future<Boolean> result = executor.submit(task);
		try {
			if (result.get() == true) {
				System.out.println("Job [id = " + jobId + "] is deleted in " + this.toString());
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Job [id = " + jobId + "] is NOT deleted in " + this.toString());
		return false;
	}
	
	public Q09Job getMostImportantJob() {
		if (pq.size() == 0)
			return null;
		else
			return pq.peek();
	}
	
	/*
	 * these methods are called by slave nodes
	 */
	public void insertJobIntoPriorityQueue(Q09Job job) {
		this.pq.add(job);
		this.jobList.put(job.getJobId(), job);
	}
	
	public void deleteJobFromPriorityQueue(Q09Job job) {
		if (job == null)
			return;
		this.pq.remove(job);
		this.jobList.remove(job.getJobId());
	}
	
	/* ******************** */
	
	public String toString() {
		return "Master Node";
	}
	
	/*
	 * use hash code to distribute the job id to different server
	 */
	private Q09FakeSlaveNode getSlaveNode(int jobId) {
		if (jobId < 0)
			return null;
		int i = jobId % slavesNum;
		return slaves.get(i);
	}
}
