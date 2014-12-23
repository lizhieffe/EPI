package Chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q07 {
	public List<Interval> unify(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return result;
		Collections.sort(intervals);
		Interval curr = null;
		for (int i = 0; i < intervals.size(); i++) {
			Interval tmp = intervals.get(i);
			if (curr == null)
				curr = new Interval(tmp.left, tmp.right);
			else {
				if (curr.right.val < tmp.left.val 
						|| (curr.right.val == tmp.left.val && curr.right.isClose == false && tmp.left.isClose == false)) {
					result.add(curr);
					curr = new Interval(tmp.left, tmp.right);
				}
				else if (curr.right.val == tmp.left.val && curr.right.isClose == false && tmp.left.isClose == true)
					curr.right = tmp.right;
			}
		}
		result.add(curr);
		return result;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(new EndPoint(0, false), new EndPoint(3, false));
		Interval i2 = new Interval(new EndPoint(5, true), new EndPoint(7, false));
		Interval i3 = new Interval(new EndPoint(9, false), new EndPoint(11, true));
		Interval i4 = new Interval(new EndPoint(12, true), new EndPoint(14, true));
		Interval i5 = new Interval(new EndPoint(1, true), new EndPoint(1, true));
		Interval i6 = new Interval(new EndPoint(3, true), new EndPoint(4, false));
		Interval i7 = new Interval(new EndPoint(7, true), new EndPoint(8, false));
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		intervals.add(i6);
		intervals.add(i7);
		new Q07().unify(intervals);
	}
}

class Interval implements Comparable <Interval> {
	EndPoint left, right;
	Interval(EndPoint left, EndPoint right) {
		this.left = left;
		this.right = right;
	}
	@Override
	public int compareTo(Interval interval) {
		return this.left.compareTo(interval.left);
	}
}

class EndPoint implements Comparable<EndPoint> {
	int val;
	boolean isClose;
	EndPoint(int val, boolean isOpen) {
		this.val = val;
		this.isClose = isOpen;
	}
	
	@Override
	public int compareTo(EndPoint ep) {
		if (this.val < ep.val)
			return -1;
		if (this.val > ep.val)
			return 1;
		if (this.isClose && !ep.isClose)
			return -1;
		if (!this.isClose && ep.isClose)
			return 1;
		return 0;
	}
}