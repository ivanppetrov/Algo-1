package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	private FileUtils() {
	}
	
	public static String readFrom(File file) throws IOException {
		BufferedReader reader = null;
		String line = null, result = "";
		
		reader = new BufferedReader(new FileReader(file));
		
		while ((line = reader.readLine()) != null) {
		    result += line;
		}
		
		reader.close();
		
		return result;
	}
	
	public static String readFrom(Path path) throws IOException {
		return readFrom(path.toFile());
	}
	
	public static void writeTo(File file, String text) throws IOException {
		String content = "";
		if (!file.exists()) {
			file.createNewFile();
		} else {
			content = readFrom(file);
		}
		
		FileWriter writer = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(content + text);
		bw.close();
	}
	
	public static void writeTo(Path path, String text) throws IOException {
		writeTo(path.toFile(), text);
	}
	
	public static void main(String[] args) {
		File file = new File("test.txt");
		Path path = Paths.get("C:\\Users\\ivan__000\\Documents\\workspace\\Files1\\test.txt");
		try {
			System.out.println(readFrom(file));
			writeTo(file, "Пешо е голем");
			System.out.println(readFrom(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
