package Chap17;

import java.util.ArrayList;
import java.util.List;

public class Q06 {
	public boolean searchForSequence(int[][] array, int[] s) {
		if (array == null || array.length == 0 || array[0].length == 0 || s == null || s.length == 0)
			return false;
		boolean[][] visited = new boolean[array.length][array[0].length];
		List<Point> stack = new ArrayList<Point>();
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[0].length; j++) {
				if(array[i][j] == s[0] && search(array, i, j, visited, stack, s, 0))
					return true;
			}
		return false;
	}
	
	private boolean search(int[][] array, int i, int j, boolean[][] visited, List<Point> stack, int[] s, int last) {
		if (last == s.length - 1) {
			stack.add(new Point(i, j));
			for (int k = 0; k < stack.size(); k++)
				System.out.println(stack.get(k).x + " " + stack.get(k).y);
			return true;
		}
		visited[i][j] = true;
		stack.add(new Point(i, j));
		if (i > 0 && visited[i - 1][j] == false && array[i - 1][j] == s[last + 1] && search(array, i - 1, j, visited, stack, s, last + 1))
			return true;
		if (i < array.length - 1 && visited[i + 1][j] == false && array[i + 1][j] == s[last + 1] && search(array, i + 1, j, visited, stack, s, last + 1))
			return true;
		if (j > 0 && visited[i][j - 1] == false && array[i][j - 1] == s[last + 1] && search(array, i, j - 1, visited, stack, s, last + 1))
			return true;
		if (j < array[0].length - 1 && visited[i][j + 1] == false && array[i][j + 1] == s[last + 1] && search(array, i, j + 1, visited, stack, s, last + 1))
			return true;
		
		visited[i][j] = false;
		stack.remove(stack.size() - 1);
		return false;
	}
	
	public static void main(String[] args) {
		int[][] array = {{1, 2, 77}, {4, 3, 99}, {123, 1, 2}};
		int[] s = {1, 2, 3, 4};
		new Q06().searchForSequence(array, s);
	}
}

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
