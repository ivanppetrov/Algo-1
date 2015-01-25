package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WordCountResult {
	private File file;
	private int lines;
	private int words;
	private int chars;
	
	public WordCountResult(File file) {
		this.file = file;
		readFile();
	}
	
	private void readFile() {
		String content = "", line;
		int counter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			while ((line = br.readLine()) != null) {
				content += line + " ";
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setLines(counter);
		
		String[] words = content.split("\\s");
		
		setWords(words.length);
		
		setChars(content.length() - 1);
	}
	
	public int getLineCount() {
		return this.lines;
	}
	
	public int getWordCount() {
		return this.words;
	}
	
	public int getCharacterCount() {
		return this.chars;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public void setChars(int chars) {
		this.chars = chars;
	}

	
}
