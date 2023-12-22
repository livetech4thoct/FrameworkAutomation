package dec22nd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("config.properties");
		
		Properties configProp=new Properties();
		
		configProp.load(fis);
		
		System.out.println(configProp.getProperty("browser"));
		
		System.out.println(configProp.getProperty("url"));

	}

}
