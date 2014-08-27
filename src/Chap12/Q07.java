package Chap12;

public class Q07 {
	int squareRoot(int val) {
		if (val == 0 || val == 1)
			return val;
		
		int max = (int)Math.sqrt(Integer.MAX_VALUE);
		int upperBound = val / 2 > max ? max : val / 2;
		int lowerBound = 1;
		while (upperBound - lowerBound > 1) {
			int tmp = (int) Math.pow(((upperBound - lowerBound) / 2 + lowerBound), 2);
			if (tmp == val)
				return (upperBound - lowerBound) / 2 + lowerBound;
			else if (tmp > val)
				upperBound = (upperBound - lowerBound) / 2 + lowerBound;
			else
				lowerBound = (upperBound - lowerBound) / 2 + lowerBound;
		}
		
		return lowerBound;
	}
	
	public static void main(String[] args) {
		int val = 261;
		System.out.println(new Q07().squareRoot(val));
	}
}
