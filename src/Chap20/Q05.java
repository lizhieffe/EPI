package Chap20;

public class Q05 {
	public String execute(String s, int time) {
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException e) {
			return "execution was interrupted";
		}
		return "execution took " + time + " ms";
	}
	
	public void processResponse(String s) {
		System.out.println("reponse is processed");
	}
	
	public static void dispatch(final int executionTime, final int timeout) {
		Runnable task = new Runnable() {
			public void run() {
				final Q05 q = new Q05();
				Runnable innerTask = new Runnable() {
					public void run() {
						System.out.println(q.execute("", executionTime));
						q.processResponse("");
					}
				};
				
				try {
					Thread innerThread = new Thread(innerTask);
					innerThread.start();
					Thread.sleep(timeout);
					innerThread.interrupt();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(task).start();
	}
	
	public static void main(String[] args) {
		dispatch(50000, 200);
	}
}
