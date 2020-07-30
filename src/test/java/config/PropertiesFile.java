package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop=new Properties();
	static String path=System.getProperty("user.dir");
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		try {
			FileInputStream fis=new FileInputStream(path+"\\src\\test\\java\\config\\config.properties");
			prop.load(fis);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	
	public static void setProperties() {
		try {
		OutputStream output= new FileOutputStream(path+"\\src\\test\\java\\config\\config.properties");
		prop.setProperty("browser", "ff");
		prop.store(output, null);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
