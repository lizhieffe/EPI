package Chap18;

public class Q03 {
	public int maxWater(int[] height) {
		if (height == null || height.length <= 2)
			return 0;
		
		int sum = 0;

		int tmpIndex = -1;
		int tmpHeight = -1;
		int tmpHeightSum = 0;
		
		
		for (int i = 0; i < height.length; i ++) {
			if (tmpHeight <= height[i]) {
				sum = sum + (i - tmpIndex - 1) * tmpHeight - tmpHeightSum;
				tmpIndex = i;
				tmpHeight = height[i];
				tmpHeightSum = 0;
			}
			else
				tmpHeightSum = tmpHeightSum + height[i];
		}
		
		tmpIndex = height.length;
		tmpHeight = -1;
		tmpHeightSum = 0;
		
		for (int j = height.length - 1; j >= tmpIndex; j --) {
			if (tmpHeight <= height[j]) {
				sum = sum + (tmpIndex - j - 1) * tmpHeight - tmpHeightSum;
				tmpIndex = j;
				tmpHeight = height[j];
				tmpHeightSum = 0;
			}
			else
				tmpHeightSum = tmpHeightSum + height[j];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] height = {1, 2, 5, 2, 2, 3, 5, 2, 3, 4, 1};
		Q03 service = new Q03();
		System.out.print(service.maxWater(height));
	}
}
