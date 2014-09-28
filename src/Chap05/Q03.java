package Chap05;

public class Q03 {
	
	long[] precomputed_reverse;
	
	public Q03() {
		precomputed_reverse = new long[Integer.parseInt("FFFF", 16) + 1];
		for (int i = 0; i < precomputed_reverse.length; i ++)
			precomputed_reverse[i] = reverse(i);
	}
	
	public long reverseBits(long val) {
		final int kWordSize = 16;
		final int mask = Integer.parseInt("FFFF", 16);
		return (long)(precomputed_reverse[(int) (val & mask)] << (3 * kWordSize))
				| precomputed_reverse[(int) ((val >> 1 * kWordSize) & mask)] << (2 * kWordSize)
				| precomputed_reverse[(int) ((val >> 2 * kWordSize) & mask)] << (1 * kWordSize)
				| precomputed_reverse[(int) ((val >> 3 * kWordSize) & mask)];
	}
	
	private long reverse(long val) {
		for (int i = 0; i < 8; i ++) {
			int j = 15 - i;
			if (((val >> i) & 1) != ((val >> j) & 1))
				val = val ^ ((1 << i) | (1 << j));
		}
		return val;
	}
	
	public static void main(String[] args) {
		long val = 1;
		long result = new Q03().reverseBits(val);
		System.out.println(Long.toBinaryString(val));
		System.out.println(Long.toBinaryString(result));
	}
}
