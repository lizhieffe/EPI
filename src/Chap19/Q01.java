package Chap19;

import java.util.LinkedList;
import java.util.List;

public class Q01 {
	int[][] colors;
	
	public List<Coord> findPath(int[][] maze, Coord beg, Coord end) {
		LinkedList<Coord> path = new LinkedList<Coord>();
		
		if (null == maze || maze.length == 0 || maze[0].length == 0)
			return path;
		
		colors = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i ++)
			for (int j = 0; j < maze[0].length; j ++)
				colors[i][j] = maze[i][j] == 0 ? 0 : 2;
		
		path.add(beg);
		setColor(beg, 1);
		
		while (path.size() > 0) {
			Coord cPoint = path.getLast();
			if (cPoint.x == end.x && cPoint.y == end.y)
				return path;
			
			if (cPoint.x > 0 && colors[cPoint.x - 1][cPoint.y] == 0) {
				Coord newPoint = new Coord(cPoint.x - 1, cPoint.y);
				setColor(newPoint, 1);
				path.add(newPoint);
			}
			else if (cPoint.x < maze.length - 1 
					&& colors[cPoint.x + 1][cPoint.y] == 0) {
				Coord newPoint = new Coord(cPoint.x + 1, cPoint.y);
				setColor(newPoint, 1);
				path.add(newPoint);
			}
			else if (cPoint.y > 0 && colors[cPoint.x][cPoint.y - 1] == 0) {
				Coord newPoint = new Coord(cPoint.x, cPoint.y - 1);
				setColor(newPoint, 1);
				path.add(newPoint);
			}
			else if (cPoint.y < maze[0].length - 1 
					&& colors[cPoint.x][cPoint.y + 1] == 0) {
				Coord newPoint = new Coord(cPoint.x, cPoint.y + 1);
				setColor(newPoint, 1);
				path.add(newPoint);
			}
			else {
				setColor(cPoint, 2);
				path.removeLast();
			}
		}
			
		return path;
	}
	
	private void setColor(Coord point, int color) {
		colors[point.x][point.y] = color;
	}
	
	
	public static void main(String[] args) {
		int[][] maze = new int[4][4];
		maze[1][0] = 1;
		maze[1][1] = 1;
		maze[1][2] = 1;
		maze[2][0] = 1;
		maze[2][1] = 1;
		maze[3][3] = 1;
		
		Coord beg = new Coord(0, 0);
		Coord end = new Coord(3, 0);
		
		System.out.println(new Q01().findPath(maze, beg, end));
	}
}
