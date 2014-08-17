package Chap07;

public class Q02 {
	
	public void replace(char[] array) {
		if (array == null || array.length == 0)
			return;
		
		int numA = 0;
		
		int j = 0;
		for (int i = 0; i < array.length; i ++) {
			if (array[i] != 'b')
				array[j ++] = array[i];
			
			if (array[i] == 'a')
				numA ++;
		}
		
		int k = j + numA - 1;
		for (int i = j - 1; i >= 0; i --) {
			if (array[i] == 'a') {
				array[k --] = 'd';
				array[k --] = 'd';
			}
			else
				array[k --] = array[i];
		}
	}
	
	public static void main(String[] args) {
		char[] array = {'a', 'b', 'c', 'd', 'b', 'a'};
		Q02 service = new Q02();
		service.replace(array);
		System.out.println();
	}
}
