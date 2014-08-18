package Chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Q01 {
	public void printAnagrams(String[] strings) {
		if (strings == null || strings.length == 0)
			return;
		
		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strings.length; i ++) {
			char[] chars = strings[i].toCharArray();
			Arrays.sort(chars);
			String tmp = new String(chars);
			if (!anagrams.containsKey(tmp))
				anagrams.put(tmp, new ArrayList<String>());
			anagrams.get(tmp).add(strings[i]);
		}
		
		Iterator<Entry<String, ArrayList<String>>> it = anagrams.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, ArrayList<String>> entry = it.next();
			System.out.print(entry.getKey() + ": ");
			for (String s : entry.getValue()) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String s0 = "abcd";
		String s1 = "dcba";
		String s2 = "dcab";
		String s3 = "abdc";
		String s4 = "gt";
		String s5 = "tg";

		String[] strings = {s0, s1, s2, s3, s4, s5};
		Q01 service = new Q01();
		service.printAnagrams(strings);
	}
}
