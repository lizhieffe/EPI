package Chap21;

import java.io.File;

import Utils.FileUtil;

public class Q07File {
	
	private String content;
	private File file;
	private String[] words;
	
	Q07File(File file) {
		this.file = file;
		loadFileContent();
		findAllWords();
	}
	
	public File getFile() {
		return file;
	}
	
	public String[] getWords() {
		return words;
	}
	
	private void loadFileContent() {
		this.content = FileUtil.readFile(file);
	}
	
	private void findAllWords() {
		words = content.split(" ");
	}
}
