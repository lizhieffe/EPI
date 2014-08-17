package Chap17;

import java.util.Arrays;

public class Q01 {
	
	int[] scores;
	
	public Q01 (int[] inputScores) {
		this.scores = inputScores;
		Arrays.sort(scores);
	}
	
	int findNumCombinations(int val) {
		if (scores == null || scores.length == 0)
			return 0;
		
		return findNumCombinations(val, 0, scores.length);
	}
	
	private int findNumCombinations(int val, int start, int end) {
		if (start >= end || end <= 0 || start >= scores.length)
			return 0;
		
		if (val < scores[start])
			return 0;
		
		if (val == scores[start])
			return 1;
		
		int result;
		result = findNumCombinations(val - scores[start], start, end)
				+ findNumCombinations(val, start + 1, end);
		
		return result;
	}
	
	int findNumDistinctSequences(int val) {
		if (scores == null || scores.length == 0)
			return 0;
		
		return findNumDistinctSequences(val, 0, scores.length);
	}
	
	private int findNumDistinctSequences(int val, int start, int end) {
		if (start >= end || end <= 0 || start >= scores.length)
			return 0;
		
		if (val < scores[start])
			return 0;
		
		int result = 0;
		for (int i = 0; i < scores.length; i ++) {
			if (val == scores[i])
				result ++;
			else
				result = result + findNumDistinctSequences(val - scores[i], start, end);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] scores = {2, 3, 7};
		int val = 7;
		Q01 service = new Q01(scores);
		System.out.println(service.findNumCombinations(val));
		System.out.println(service.findNumDistinctSequences(val));
	}
}
