package Chap21;

public class Q09Job implements Comparable<Q09Job> {

	private int jobId;
	private int priority;
	
	public Q09Job(int jobId, int priority) {
		this.jobId = jobId;
		this.priority = priority;
	}
	
	public int getJobId() {
		return this.jobId;
	}
	
	public int getPriority() {
		return priority;
	}
	
	@Override
	public int compareTo(Q09Job job) {
		/*
		 * the job with higher priority will rank lower
		 */
		if (this.priority < job.getPriority())
			return 1;
		if (this.priority > job.getPriority())
			return -1;
		return 0;
	}
}
