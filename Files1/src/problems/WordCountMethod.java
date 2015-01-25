package problems;

import java.io.File;
import java.nio.file.Path;

public class WordCountMethod {

	public WordCountResult wordCount(Path path) {
		return new WordCountResult(path.toFile());
	}
	
	public WordCountResult wordCount(File file) {
		return new WordCountResult(file);
	}
	
	public static void main(String[] args) {
		WordCountResult wc = new WordCountResult(new File("test.txt"));
		
		System.out.println(wc.getLineCount());
		System.out.println(wc.getWordCount());
		System.out.println(wc.getCharacterCount());

	}

}
