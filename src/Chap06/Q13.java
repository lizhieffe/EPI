package Chap06;

public class Q13 {
	public static void permute(int[] array, int[] permutation) {
		int i = 0;
		while (i < array.length) {
			int dest = permutation[i];
			if (dest == i)
				i ++;
			else {
				int tmp = array[dest];
				array[dest] = array[i];
				array[i] = tmp;
				
				permutation[i] = permutation[dest];
				permutation[dest] = dest;
			}
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9};
		int[] permutation = {3, 0, 4, 1, 2};
		new Q13().permute(array, permutation);
	}
}
