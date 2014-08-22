package Chap06;

public class Q22 {
	public void print(String[][] s) {
		if (s == null || s.length == 0 || s[0].length == 0)
			return;
		
		int direction = 0;
		int x = 0;
		int y = 0;
		
		while (true) {
			if (s[x][y] != null)
				System.out.println(s[x][y] + " ");
			s[x][y] = null;
			int[] nextPosition = findNextPosition(x, y, direction, s);
			if (nextPosition[0] == -1) {
				direction = findNextDirection(x, y, s);
				if (direction == -1)
					break;
			}
			else {
				x = nextPosition[0];
				y = nextPosition[1];
			}
		}
	}
	
	private int findNextDirection(int x, int y, String[][] s) {
		if (y < s[0].length - 1 && s[x][y + 1] != null)
			return 0;
		else if (x < s.length - 1 && s[x + 1][y] != null)
			return 1;
		else if (y > 0 && s[x][y - 1] != null)
			return 2;
		else if (x > 0 && s[x - 1][y] != null)
			return 3;
		else
			return -1;
	}
	
	private int[] findNextPosition(int x, int y, int direction, String[][] s) {
		int[] errorResult = {-1, -1};
		
		if (x < 0 || y < 0 || x >= s.length || y >= s[0].length)
			return errorResult;
			
		if (direction == 0) {
			if (y >= s[0].length - 1 || s[x][y + 1] == null)
				return errorResult;
			else {
				int[] result = {x, y + 1};
				return result;
			}
		}
		else if (direction == 1) {
			if (x >= s.length - 1 || s[x + 1][y] == null)
				return errorResult;
			else {
				int[] result = {x + 1, y};
				return result;
			}
		}
		else if (direction == 2) {
			if (y <= 0 || s[x][y - 1] == null)
				return errorResult;
			else {
				int[] result = {x, y - 1};
				return result;
			}
		}
		else {
			if (x <= 0 || s[x - 1][y] == null)
				return errorResult;
			else {
				int[] result = {x - 1, y};
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
		String[][] s = new String[3][4];
		for (int i = 0; i < s.length; i ++) {
			for (int j = 0; j < s[0].length; j ++)
				s[i][j] = i + "" + j;
		}
		
		new Q22().print(s);
	}
}
