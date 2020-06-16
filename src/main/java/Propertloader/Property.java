package Propertloader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Property {

		Properties prop = new Properties();	
		
		public static void main(String[] args) throws URISyntaxException {
			Property pl = new Property();
		}

		
		public Property(){
			
			loadProperties();
		}
		
		public void loadProperties() {
			
			
			try {
			
			InputStream fi = this.getClass().getResourceAsStream("/TestData/td.properties");
			prop.load(fi);
			
			}catch(Exception a) {
				System.out.println(a);
			}
			
		}
		
		
		public String getProperty(String key) {
			
			return prop.getProperty(key);
		}

		public static void loadLog4jPropertyFile(String sPathLog4jPropertyFile) throws Exception{
			FileInputStream fi = new FileInputStream(sPathLog4jPropertyFile);
			Properties props = new Properties();
			props.load(fi);
			PropertyConfigurator.configure(props);
			}
}
