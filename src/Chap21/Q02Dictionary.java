package Chap21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class Q02Dictionary {
	Set<String> dict = new HashSet<String>();
	
	public void addWordsFromFile(String fileName) {
		int oldSize = dict.size();
		File file = null;
		BufferedReader in = null;
		try {
			file = new File(Q02Constant.RES_ROOT, Q02Constant.DICT_FILE_NAME);
			in = new BufferedReader(new FileReader(file));
			while (in.ready()) {
				String s = in.readLine();
				dict.add(s);
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println((dict.size() - oldSize) 
				+ " words is loaded successfully to dictionary from file: " + Q02Constant.DICT_FILE_NAME);
	}
	
	public Set<String> findWordsWithinDistance(String s, int distance) {
		Set<String> result = new HashSet<String>();
		if (distance < 0)
			return result;
		if (distance == 0 && dict.contains(s)) {
			result.add(s);
			return result;
		}
		Iterator<String> it = dict.iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			if (Math.abs(tmp.length() - s.length()) > distance)
				continue;
			if (new Q02StringDistanceHelper().calculateDistance(tmp, s) <= distance)
				result.add(tmp);
		}
		return result;
	}
	
	public Set<String> findWordsWithinDistance1(String s, int distance) {
		Set<String> result = Q02StringUtil.generateStringsWithinDistance(s, distance);
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			if (!dict.contains(tmp))
				it.remove();
		}
		return result;
	}
	
	@Test
	public void tc1() {
		Q02Dictionary tc = new Q02Dictionary();
		tc.addWordsFromFile(Q02Constant.DICT_FILE_NAME);
		Set<String> result = tc.findWordsWithinDistance("adfdfdfdafdfawerwe", 2);
		System.out.println(result);
	}
}
