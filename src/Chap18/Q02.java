package Chap18;

import java.util.Arrays;

public class Q02 {

	public int minWaitingTime(int[] time) {
		if (time == null)
			return -1;
		
		if (time.length <= 1)
			return 0;
		
		Arrays.sort(time);
		int totalTime = 0;
		for (int i = 0; i < time.length - 1; i ++)
			totalTime = totalTime + time[i] * (time.length - 1);
		return totalTime;
	}
}
