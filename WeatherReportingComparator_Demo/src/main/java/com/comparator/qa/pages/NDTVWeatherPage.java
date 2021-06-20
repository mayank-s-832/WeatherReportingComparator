package com.comparator.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comparator.qa.base.BaseClass;

public class NDTVWeatherPage extends BaseClass {

	@FindBy(xpath = "//input[@id = 'searchBox']")
	WebElement citySearchBox;
	
	@FindBy(xpath = "//b[contains(text(),'Temp in Degrees')]")
	WebElement getTempinDegree;
	
	public NDTVWeatherPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement checkCityCheckbox(String cityname) {
		String checkboxXpath = "//input[@id = '"+cityname+"']"; 
		System.out.println(checkboxXpath);
		WebElement element =driver.findElement(By.xpath(checkboxXpath));
		return element;
		
	}
	
//	public static void main(String[] args) {
//		NDTVWeatherPage obj = new NDTVWeatherPage();
//		obj.checkCityCheckbox("Ajmer");
//
//	}
}

