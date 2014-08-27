package Chap17;

public class Q20 {
	long[] table;
	
	public long getMinMessiness(String[] words, int L) {
		if (words == null || words.length == 0 || L <= 0)
			return -1;
		
		for (int i = 0; i < words.length; i ++) 
			if (words[i].length() > L)
				return -1;
		
		table = new long[words.length];
		for (int i = 0; i < words.length; i ++)
			table[i] = -1;
		
		getMin(words, L, 0);
		return table[0];
	}
	
	private long getMin(String[] words, int L, int beg) {
		if (beg >= words.length)
			return 0;
		
		if (table[beg] != -1)
			return table[beg];
		
		int i = 0;
		int tmpLength = words[beg].length();
		long min = Integer.MAX_VALUE;
		
		while (tmpLength <= L) {
		
			long tmp = L - tmpLength > 31 ? Integer.MAX_VALUE : (long)Math.pow(2, L - tmpLength);
			
			if (min > tmp + getMin(words, L, beg + i + 1))
				min = tmp + getMin(words, L, beg + i + 1);
			
			if (beg + i + 1 >= words.length)
				break;
			
			tmpLength = tmpLength + words[beg + i + 1].length() + 1;
			i ++;
		}
		table[beg] = min;
		return min;
	}
	
	public static void main(String[] args) {
		String tmp = "I have inserted a large number of new examples from the papers for the Mathematical "
				+ "Tripos during the last twenty years, which should be useful to Cambridge students";
		String[] words = tmp.split(" ");
		
		int L = 36;
		
		System.out.println(new Q20().getMinMessiness(words, L));
	}
}
