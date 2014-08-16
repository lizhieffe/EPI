package Chap16;

public class Q01 {

	public void move(int n, int from, int to) {
		if (n <= 0 || from < 0 || from > 2 || to < 0 || to > 2 || from == to)
			return;
		else {
			if (n == 1)
				System.out.println("move top 1 from deck " + from + " to deck " + to);
			else {
				move(n - 1, from, 3 - from - to);
				move(1, from, to);
				move(n - 1, 3 - from - to, to);
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int from = 0;
		int to = 1;
		
		Q01 service = new Q01();
		service.move(n, from, to);
	}
}