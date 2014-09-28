package Chap05;

import java.util.Random;

public class Q12 {
	public static int generateRandom(int a, int b) {
		if (b == a)
			return a;
		
		int interval = b - a;
		int digits = 0;
		int tmp = 1;
		while (tmp < interval) {
			tmp = tmp * 2;
			digits ++;
		}
		
		tmp = 0;
		Random randomGenerator = new Random();
		for (int i = 0; i < digits; i ++) {
			tmp = tmp * 2 + randomGenerator.nextInt(2);
		}
		
		if (tmp > interval)
			return generateRandom(a, b);
		else
			return a + tmp;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		for (int i = 0; i < 10000; i ++)
			System.out.print(generateRandom(a, b) + " ");
	}
}
