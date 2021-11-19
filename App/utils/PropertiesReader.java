package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private PropertiesReader() {

	}

	/**
	 * Read properties file
	 * 
	 * @param filePath Path of the file
	 * @return {@code Properties}
	 * @throws IOException
	 * @author Shubham Kumar
	 */
	public static Properties readProperties(String filePath) throws IOException {
		Properties prop = null;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			prop = new Properties();
			prop.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
