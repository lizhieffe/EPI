package Chap17;

public class Q11 {
	public Interval getMaxSum(int[] array) {
		if (null == array || array.length == 0)
			return new Interval(-1, -1);
		
		if (array.length == 1)
			return new Interval(0, 0);
		
		int max = Integer.MIN_VALUE;
		int tmpMax = array[0];
		int beg = 0;
		int end = 0;
		int tmpBeg = 0;
		int tmpEnd = 0;
		
		while (true) {
			if (beg == 0 && end == array.length - 1)
				break;
			
			if (array[findNextIndex(array, tmpEnd)] >= 0 && tmpMax >= 0) {
				tmpMax += array[findNextIndex(array, tmpEnd)];
				tmpEnd = findNextIndex(array, tmpEnd);
			}
			else {
				if (max < tmpMax) {
					max = tmpMax;
					beg = tmpBeg;
					end = tmpEnd;
				}
				
				if (tmpEnd < tmpBeg && array[findNextIndex(array, tmpEnd)] < 0)
					break;
				
				tmpBeg = findNextIndex(array, tmpEnd);
				tmpEnd = tmpBeg;
				tmpMax = array[tmpBeg];
				

			}
		}
		
		return new Interval(tmpBeg, tmpEnd);
	}
	
	private int findNextIndex(int[] array, int index) {
		if (index == array.length - 1)
			return 0;
		else
			return index + 1;
	}
	
	class Interval {
		int beg;
		int end;
		Interval(int beg, int end) {
			this.beg = beg;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, -1, 3, 1};
		System.out.println(new Q11().getMaxSum(array).beg + " " + new Q11().getMaxSum(array).end);
	}
}
