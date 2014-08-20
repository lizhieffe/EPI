package Chap06;

public class Q04 {
	public boolean canAdvanceToEnd(int[] move) {
		if (move == null || move.length == 0)
			return true;
		
		int preMove = 0;
		for (int i = 0; i < move.length; i ++) {
			if (i == move.length - 1)
				return true;
			
			if (Math.max(preMove, move[i]) <= 0)
				break;
			else {
				preMove = Math.max(preMove, move[i]) - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] move = {3, 0, 0, 1, 0, 2, 0, 1};
		Q04 service = new Q04();
		System.out.println(service.canAdvanceToEnd(move));
	}
}
