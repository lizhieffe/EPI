package Chap14;

import java.util.ArrayList;

public class Q06 {
	public ClosedInterval[] joint(ClosedInterval[] intervals, ClosedInterval join) {
		ArrayList<ClosedInterval> result = new ArrayList<ClosedInterval>();
		
		if (intervals == null || intervals.length == 0) {
			result.add(join);
			return (ClosedInterval[]) result.toArray();
		}
		
		ClosedInterval tmpJoin = new ClosedInterval(join.beg, join.end);
		boolean added = false;
		if (intervals[0].beg > join.end || intervals[intervals.length - 1].end < join.beg)
			added = true;
		
		for (int i = 0; i < intervals.length; i ++) {
			ClosedInterval tmp = intervals[i];
			
			if (tmp.end < join.beg)
				result.add(tmp);
			else if (tmp.beg > join.end) {
				if (!added) {
					result.add(tmpJoin);
					added = true;
				}

				result.add(tmp);
			}
			else {
				if (tmp.beg < tmpJoin.beg)
					tmpJoin.beg = tmp.beg;
				if (tmp.end > tmpJoin.end)
					tmpJoin.end = tmp.end;
			}
		}
		
		if (!added) {
			result.add(tmpJoin);
			added = true;
		}
		
		return (ClosedInterval[]) result.toArray();
	}
	
	public static void main(String[] args) {
		ClosedInterval i1 = new ClosedInterval(0, 1);
		ClosedInterval i2 = new ClosedInterval(2, 4);
		ClosedInterval i3 = new ClosedInterval(6, 8);
		ClosedInterval i4 = new ClosedInterval(10, 5);
		ClosedInterval i5 = new ClosedInterval(17, 24);
		ClosedInterval i6 = new ClosedInterval(29, 38);
		ClosedInterval[] intervals = {i1, i2, i3, i4, i5, i6};
		ClosedInterval join = new ClosedInterval(3, 39);
		
		System.out.println(new Q06().joint(intervals, join));
		
	}
}
