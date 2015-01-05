package Chap21;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q07 {
	List<Q07File> files = new ArrayList<Q07File>();
	Map<String, List<File>> wordIndex = new HashMap<String, List<File>>();
	
	private void loadTextFiles() {
		File folder = new File(Q07Constant.RES_ROOT, Q07Constant.TEXT_FILES_FOLDER);
		File[] listOfFiles = folder.listFiles();
		int num = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				num++;
				Q07File fi = new Q07File(listOfFiles[i]);
				files.add(fi);
			} else if (listOfFiles[i].isDirectory()) {
			}
		}
		System.out.println(num + " files are read");
	}
	
	private void buildWordIndex() {
		for (Q07File file : files) {
			String[] words = file.getWords();
			for (int i = 0; i < words.length; i++) {
				if (!wordIndex.containsKey(words[i])) {
					wordIndex.put(words[i], new ArrayList<File>());
				}
				List<File> fileList = wordIndex.get(words[i]);
				fileList.add(file.getFile());
			}
		}
	}
	
	private List<File> searchForFiles(List<String> keys) {
		List<File> result = new ArrayList<File>();
		if (keys == null || keys.size() == 0)
			return result;
		List<File> tmp = new ArrayList<File>();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			if (!wordIndex.containsKey(key))
				return new ArrayList<File>();
			if (i == 0)
				result.addAll(wordIndex.get(key));
			else {
				List<File> fileList = wordIndex.get(key);
				for (File file : fileList)
					if (result.contains(file))
						tmp.add(file);
				result = tmp;
				tmp = new ArrayList<File>();
			}
		}
		return result;
	}
	
	private void awaitQuery() {
		while (true) {
			System.out.println("Please input query string:");
			Scanner sc = new Scanner(System.in);
			final String s = sc.nextLine();
			
			Runnable task = new Runnable() {
				public void run() {
					String[] queryWords = s.split(" ");
//					searchForFiles(new ArrayList<String>(Arrays.asList(queryWords)));
					List<File> result = searchForFiles(Arrays.asList(queryWords));
					System.out.print("Search result for Query [");
					for (int i = 0; i < queryWords.length; i++)
						System.out.print(queryWords[i] + ", ");
					System.out.print("] are [");
					for (File file : result)
						System.out.print(file + ", ");
					System.out.print("]");	
				}
			};
			new Thread(task).start();
		}
	}
	
	public static void main(String[] args) {
		Q07 service = new Q07();
		service.loadTextFiles();
		service.buildWordIndex();
		service.awaitQuery();
	}
}
