package Chap21;

public class Q09 {
	
	private static int SLAVE_NUMBER = 5;
	private Q09FakeMasterNode master = new Q09FakeMasterNode(SLAVE_NUMBER);
	
	private void startMasterNode() {
		master.startServer();
	}
	
	public static void main(String[] args) {
		Q09 service = new Q09();
		service.startMasterNode();
	}
}
