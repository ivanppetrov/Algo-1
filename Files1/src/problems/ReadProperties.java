package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import exceptions.FileFormatException;

public class ReadProperties {
	private static final String EXTENSION = "properties";
	
	public static Map<String, String> parseProperties(File file) {
		Map<String, String> propertiesMap = new HashMap<String, String>();
		
		if (getFileExtension(file).equalsIgnoreCase(EXTENSION)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				String key, value;
				while ((line = br.readLine()) != null) {
					if (checkLine(line)) {
						key = line.substring(0, line.indexOf("="));
						value = line.substring(line.indexOf("=") + 1);
						propertiesMap.put(key.replaceAll("\\s+",""), value);
					}
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new FileFormatException();
		}
		
		return propertiesMap;
	}
	
	private static boolean checkLine(String line) {
		if (line.startsWith("#")) {
			return false;
		} else {
			if (line.contains("=")) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private static String getFileExtension(File file) {
		String fileName  = file.getName();

		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	public static void main(String[] args) {
		File file = new File("Prop.properties");
		Map<String, String> prop = parseProperties(file);
		
		for (String key : prop.keySet()) {
			System.out.println(key + " : " + prop.get(key));
		}
	}

}
