package Chap14;

import java.util.Arrays;

public class Q14 {
	public double findThreshold(double[] salary, double aim) {
		if (salary == null || salary.length == 0 || aim < 0)
			return -1;
		
		Arrays.sort(salary);
		if (salary[0] * salary.length >= aim)
			return aim / salary.length;
		
		double[] preSum = new double[salary.length];
		preSum[0] = 0;
		for (int i = 1; i < salary.length; i ++)
			preSum[i] = preSum[i - 1] + salary[i - 1];
		
		if (preSum[salary.length - 1] + salary[salary.length - 1] < aim)
			return salary[salary.length - 1];
		
		int start = 0;
		int end = salary.length;
		while (true) {
			if (start == end - 1)
				return (aim - preSum[start] -  salary[start]) / (salary.length - start - 1);
			
			int mid = start + (end - start) / 2;
			double tmp = preSum[mid] + (salary.length - mid) * salary[mid];
			if (tmp == aim)
				return salary[mid];
			else if (tmp < aim)
				start = mid;
			else
				end = mid;
		}
	}
	
	public static void main(String[] args) {
		double[] salary = {20, 40, 60, 80};
		double aim = 160;
		System.out.println(new Q14().findThreshold(salary, aim));
		
	}
}
