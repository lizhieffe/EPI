package Chap05;

public class Q01 {
	
	int[] cachedTable;
	
	// brutal method
	public int getParity(long x) {
		int result = 0;
		while (x != 0) {
			result ^= (x & 1);
			x >>= 1;
		}
		return result;
	}
	
	// use cached table to determine x
	public int getParity1(long x) {
		if (cachedTable == null)
			generateCachedTable();
		int result = 0;
		
		result = cachedTable[(int) (x >> (3 * 16) - 1)] 
				^ cachedTable[(int) (x >> (2 * 16)) & ((int) Math.pow(2, 16) - 1)]
				^ cachedTable[(int) (x >> (1 * 16)) & ((int) Math.pow(2, 16) - 1)]
				^ cachedTable[(int) x & ((int) Math.pow(2, 16) - 1)];
		
		return result;
	}
	
	private void generateCachedTable() {
		int size = (int) Math.pow(2, 16);
		cachedTable = new int[size];
		
		cachedTable[0] = 0;
		
		for (int i = 0; i < 16; i ++) {
			for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j ++) {
				cachedTable[j] = cachedTable[j - (int) Math.pow(2, i)] ^ 1;
			}
		}
	}
	
	public static void main(String[] args) {
		long x = 13;
		
		Q01 service = new Q01();
		System.out.println(service.getParity(x));
		System.out.println(service.getParity1(x));

	}
}
