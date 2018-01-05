package com.local.auro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertyReader {

	InputStream inputStream;

	public String getPropValues(String propertyName) throws IOException {

		String value = null;
		try {
			Properties prop = new Properties();
			String propFileName = "pageConstants.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
			value = prop.getProperty(propertyName);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return value;
	}
}