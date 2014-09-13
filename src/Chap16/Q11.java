package Chap16;

import java.util.ArrayList;
import java.util.List;

public class Q11 {
	public List<String> generateGreyCode(int n) {
		List<String> result = new ArrayList<String>();
		
		if (n == 0)
			return result;
		
		if (n == 1) {
			result.add("0");
			result.add("1");
			return result;
		}
		
		List<String> tmp = generateGreyCode(n - 1);
		for (int i = 0; i < tmp.size(); i ++)
			result.add("0" + tmp.get(i));
		for (int i = tmp.size() - 1; i >= 0; i --)
			result.add("1" + tmp.get(i));
		
		return result;
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(new Q11().generateGreyCode(n));
	}
}
