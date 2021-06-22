package com.comparator.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comparator.qa.base.BaseClass;

public class NDTVWeatherPage extends BaseClass {

	@FindBy(xpath = "//input[@id = 'searchBox']")
	public WebElement citySearchBox;

	@FindBy(xpath = "//b[contains(text(),'Temp in Degrees')]")
	WebElement getTempinDegree;

	@FindBy(xpath = "//div[@class = 'cityText']")
	List<WebElement> availableCitiesOnMap;
	
	@FindBy(xpath = "//b[contains(text(),'Temp in Degrees')]")
	public WebElement tempinCelcius;

	public NDTVWeatherPage() {
		PageFactory.initElements(driver, this);
	}

	// search bar-
	public WebElement CityCheckboxElementonSearch(String cityname) {
		String checkboxXpath = "//input[@id = '" + cityname + "']";
		System.out.println(checkboxXpath);
		WebElement element = driver.findElement(By.xpath(checkboxXpath));
		return element;

	}

	public boolean checkCityonMap(String cityName) {
		boolean random = false;
	for(WebElement el : availableCitiesOnMap) {
		if(el.getText().equals(cityName)) {
			random = true;
			break;
		}
	}
		
		return random;
	}

	public WebElement getCityElementonMap(String cityname) {

		String cityElementXPath = "//div[contains(text(),'" + cityname + "')]";
		System.out.println(cityElementXPath);
		WebElement element = driver.findElement(By.xpath(cityElementXPath));
		return element;

	}

//	public static void main(String[] args) {
//		NDTVWeatherPage obj = new NDTVWeatherPage();
//		// obj.CityCheckboxElement("Ajmer");
//		obj.getCityElementonMap("Patna");
//
//	}
}
