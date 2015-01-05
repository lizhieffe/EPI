package Chap21;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Q02 {
	
	Q02Dictionary dict = new Q02Dictionary();
	
	private void loadDict() {
		dict.addWordsFromFile(Q02Constant.DICT_FILE_NAME);
	}
	
	private void awaitQuery() {
		while (true) {
			System.out.println("Please input query string:");
			Scanner sc = new Scanner(System.in);
			final String s = sc.nextLine();
			
			Runnable task = new Runnable() {
				public void run() {
					processQueryString(s);
					processQueryString1(s);
				}
			};
			new Thread(task).start();
		}
	}
	
	private void processQueryString(String s) {
		System.out.println("Query (" + s + ") is being processed");
		final long startTime = System.currentTimeMillis();
		Set<String> result = dict.findWordsWithinDistance(s, Q02Constant.MAX_DISTANCE);
		final long endTime = System.currentTimeMillis();
		System.out.print("Similar words for \"" + s + "\" are: (" + (endTime - startTime) + "ms) [");
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp + ", ");
		}
		System.out.println("]");
	}
	
	private void processQueryString1(String s) {
		System.out.println("Query (" + s + ") is being processed");
		final long startTime = System.currentTimeMillis();
		Set<String> result = dict.findWordsWithinDistance1(s, Q02Constant.MAX_DISTANCE);
		System.out.print("Similar words for \"" + s + "\" are: [");
		final long endTime = System.currentTimeMillis();
		System.out.print("Similar words for \"" + s + "\" are: (" + (endTime - startTime) + "ms) [");
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp + ", ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Q02 spellChecker = new Q02();
		spellChecker.loadDict();
		spellChecker.awaitQuery();
	}
}
