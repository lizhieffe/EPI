package Chap07;

import java.util.ArrayList;
import java.util.HashMap;

public class Q05 {
	ArrayList<String> result;
	String input;
	HashMap<Integer, ArrayList<Character>> map;
	
	public ArrayList<String> getAllSequences(String input, HashMap<Integer, ArrayList<Character>> map) {
		this.result = new ArrayList<String>();
		this.input = input;
		this.map = map;
		
		if (input == null || input.length() == 0 || map == null || map.size() == 0)
			return result;
		
		String solution = "";
		get(solution, 0);
		
		return this.result;
	}
	
	private void get(String solution, int index) {
		if (index == input.length()) {
			result.add(solution);
			return;
		}
		
		Integer integer = input.charAt(index) - '0';
		ArrayList<Character> chars = map.get(integer);
		for (int i = 0; i < chars.size(); i ++) {
			StringBuilder builder = new StringBuilder(solution);
			builder.append(chars.get(i));
			get(builder.toString(), index + 1);
		}
	}
	
	public static void main(String[] args) {
		String input = "123";
		HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
		ArrayList<Character> a1 = new ArrayList<Character>();
		a1.add('a');
		a1.add('b');
		a1.add('c');
		ArrayList<Character> a2 = new ArrayList<Character>();
		a2.add('d');
		a2.add('e');
		a2.add('f');
		ArrayList<Character> a3 = new ArrayList<Character>();
		a3.add('g');
		a3.add('h');
		a3.add('i');
		map.put(1, a1);
		map.put(2, a2);
		map.put(3, a3);
		
		Q05 service = new Q05();
		System.out.println(service.getAllSequences(input, map));
	}
}
