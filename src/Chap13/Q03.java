package Chap13;

import java.util.Hashtable;

public class Q03 {
	public boolean isConstructible(String L, String M) {
		if (L == null || M == null || L.length() > M.length())
			return false;
		if (L.length() == 0)
			return true;
		
		char[] l = L.toCharArray();
		char[] m = M.toCharArray();
		
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		
		for (int i = 0; i < l.length; i ++) {
			Character key = l[i];
			
			if (table.containsKey(key))
				table.put(key, table.get(key) + 1);
			else
				table.put(key, 1);
		}
		
		for (int i = 0; i < m.length; i ++) {
			Character key = m[i];
			
			if (table.containsKey(key)){
				if (table.get(key) > 1)
					table.put(key, table.get(key) - 1);
				else
					table.remove(key);
			}
		}
		
		return table.size() == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		String L = "abcdabcd";
		String M = "abcdabce";
		Q03 service = new Q03();
		System.out.println(service.isConstructible(L, M));
		
	}
}
