package com.comparator.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.comparator.qa.util.TestUtil;


public class BaseClass {
	
	
		public static WebDriver driver;
		public static Properties prop;
		String fileLocation;
		
		public BaseClass() {
			fileLocation = "TestData/config.properties";
			//initializing prop variable in constructor-
			try {
				prop = new Properties(); 
				FileInputStream ip = new FileInputStream(fileLocation); 
				prop.load(ip);  
			}catch(FileNotFoundException e){
				e.printStackTrace();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void initialization() {
			String browsername = prop.getProperty("browser");
			String chromepath = prop.getProperty("chromePath");
			String firefoxpath = prop.getProperty("firefoxPath");
			
			if(browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
			}else if(browsername.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", firefoxpath);
				driver = new FirefoxDriver();
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait_time, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
//	public static void main(String[] args) {
//		BaseClass obj = new BaseClass();
//		initialization();
//	}


	
}
