package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private PropertiesReader() {

	}
	
	public static Properties readProperties(String fileName) throws IOException {
		Properties prop = null;
		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			prop = new Properties();
			prop.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
