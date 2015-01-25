package problems;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FixSubtitles {
	
	public static void fixEncoding(Path path) {
		String content = "", line;
		try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("windows-1251"))) {
			while ((line = br.readLine()) != null) {
				content += line + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path.toFile()), "UTF-8")){
			out.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Path path = Paths.get("subs.srt");
		fixEncoding(path);
	}

}
