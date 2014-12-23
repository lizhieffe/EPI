package Chap19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q06 {
	public void devide(List<Line> lines, Set<Point> left, Set<Point> right) {
		if (lines == null || lines.size() == 0)
			return;
		for (int i = 0; i < lines.size(); i++) {
			Point p1 = lines.get(i).p1;
			Point p2 = lines.get(i).p2;
			if (left.contains(p1)) {
				if (left.contains(p2)) {
					left.clear();
					right.clear();
					return;
				}
				if (right.contains(p2))
					continue;
				right.add(p2);
			}
			else if (right.contains(p1)) {
				if (right.contains(p2)) {
					left.clear();
					right.clear();
					return;
				}
				if (left.contains(p2))
					continue;
				left.add(p2);
			}
			else if (left.contains(p2))
				right.add(p1);
			else if (right.contains(p2))
				left.add(p1);
			else {
				left.add(p1);
				right.add(p2);
			}
		}
	}
	
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		Point p4 = new Point();
		Point p5 = new Point();
		Point p6 = new Point();
		List<Line> lines = new ArrayList<Line>();
		lines.add(new Line(p1, p2));
		lines.add(new Line(p2, p3));
		lines.add(new Line(p4, p3));
		lines.add(new Line(p4, p5));
		lines.add(new Line(p5, p1));
		Set<Point> left = new HashSet<Point>();
		Set<Point> right = new HashSet<Point>();
		new Q06().devide(lines, left, right);
		System.out.println();
	}
}

class Point {
	
}

class Line {
	Point p1, p2;
	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}
