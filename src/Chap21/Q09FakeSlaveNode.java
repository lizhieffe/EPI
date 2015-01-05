package Chap21;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * this class is to mimic a slave server. It runs on the different thread as the master node
 */

public class Q09FakeSlaveNode {
	
	private static int count = 0;
	private int id;
	private PriorityQueue<Q09Job> pq;
	private Map<Integer, Q09Job> jobList;
	private Q09FakeMasterNode master;
	
	public Q09FakeSlaveNode() {
		this.id = count++;
		pq = new PriorityQueue<Q09Job>();
		this.jobList = new HashMap<Integer, Q09Job>();
	}
	
	public void setMasterNode(Q09FakeMasterNode master) {
		this.master = master;
	}
	
	public void startServer() {
		System.out.println(this.toString() + " is started");
	}	
	
	public boolean addJob(Q09Job job) {
		if (job == null || job.getJobId() < 0 || jobList.containsKey(job.getJobId())) {
			System.out.println("Job [id = " + job.getJobId() + "] is NOT added in " + this.toString());
			return false;
		}
		else {
			Q09Job prevMostImportant = pq.peek();
			pq.add(job);
			jobList.put(job.getJobId(), job);
			Q09Job currMostImportant = pq.peek();
			if (prevMostImportant != currMostImportant) {
				master.deleteJobFromPriorityQueue(prevMostImportant);
				master.insertJobIntoPriorityQueue(currMostImportant);
			}
			System.out.println("Job [id = " + job.getJobId() + "] is added in " + this.toString());
			return true;
		}
	}
	
	public boolean deleteJob(int jobId) {
		if (jobId < 0 || !jobList.containsKey(jobId)) {
			System.out.println("Job [id = " + jobId + "] doesn't exist in " + this.toString());
			return false;
		}
		else {
			Q09Job prevMostImportant = pq.peek();
			pq.remove(jobList.remove(jobId));
			Q09Job currMostImportant = pq.peek();
			if (prevMostImportant != currMostImportant) {
				master.deleteJobFromPriorityQueue(prevMostImportant);
			}
			System.out.println("Job [id = " + jobId + "] is deleted in " + this.toString());
			return true;
		}
	}
	
	public Q09Job getMostImportantJob() {
		System.out.println("Get most important job in " + this.toString());
		return this.pq.peek();
	}
	
	public String toString() {
		return "Slave Node [" + id + "]";
	}
}
