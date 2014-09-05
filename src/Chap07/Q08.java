package Chap07;

import java.util.ArrayList;
import java.util.List;

public class Q08 {
	List<List<Integer>> result;
	String s;
	
	public List<List<Integer>> getAllValidIp(String s) {
		result = new ArrayList<List<Integer>>();
		if (null == s || s.length() <= 3)
			return result;
		
		this.s = s;
		
		List<Integer> solution = new ArrayList<Integer>();
		findFirst(solution);
		
		return result;
	}
	
	private void findFirst(List<Integer> solution) {
		if (null == s || s.length() <= 3)
			return;
		
		for (int i = 0; i < Math.min(3, s.length()); i ++) {
			int tmpInt = Integer.parseInt(s.substring(0, i + 1));
			if (tmpInt < 256) {
				ArrayList<Integer> tmpSolution = new ArrayList<Integer>(solution);
				tmpSolution.add(tmpInt);
				findSecond(tmpSolution, i + 1);
			}
		}
	}
	
	private void findSecond(List<Integer> solution, int beg) {
		if (s.length() - beg <= 2)
			return;
		
		for (int i = 0; i < Math.min(3, s.length() - beg); i ++) {
			int tmpInt = Integer.parseInt(s.substring(beg, beg + i + 1));
			if (tmpInt < 256) {
				ArrayList<Integer> tmpSolution = new ArrayList<Integer>(solution);
				tmpSolution.add(tmpInt);
				findThird(tmpSolution, beg + i + 1);
			}
		}
	}
	
	private void findThird(List<Integer> solution, int beg) {
		if (s.length() - beg <= 1)
			return;
		
		for (int i = 0; i < Math.min(3, s.length() - beg); i ++) {
			int tmpInt = Integer.parseInt(s.substring(beg, beg + i + 1));
			if (tmpInt < 256) {
				ArrayList<Integer> tmpSolution = new ArrayList<Integer>(solution);
				tmpSolution.add(tmpInt);
				findForth(tmpSolution, beg + i + 1);
			}
		}
	}
	
	private void findForth(List<Integer> solution, int beg) {
		if (s.length() - beg <= 0)
			return;
		
		int tmpInt = Integer.parseInt(s.substring(beg, s.length()));
		if (tmpInt < 256) {
			ArrayList<Integer> tmpSolution = new ArrayList<Integer>(solution);
			tmpSolution.add(tmpInt);
			result.add(tmpSolution);
		}
	}
	
	public static void main(String[] args) {
		String s = "123456";
		System.out.println(new Q08().getAllValidIp(s));
	}
}
