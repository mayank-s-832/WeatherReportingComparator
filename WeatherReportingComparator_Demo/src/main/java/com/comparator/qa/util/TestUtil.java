package com.comparator.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comparator.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long page_load_time = 20;
	public static long implicitly_wait_time = 10;

	public void TakeScreenShotMethod(String filewithpath) throws IOException {

		TakesScreenshot takess = ((TakesScreenshot)driver); 
		File file = takess.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filewithpath);
		FileUtils.copyFile(file, DestFile);
	}

	
	public static WebElement explicitWait(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;
	}

}
