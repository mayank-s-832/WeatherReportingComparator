package com.comparator.qa.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.comparator.qa.base.BaseClass;
import com.comparator.qa.pages.NDTVHomePage;
import com.comparator.qa.pages.NDTVWeatherPage;

public class NDTVWeatherPageTest extends BaseClass {

	NDTVHomePage NDTVHomePageobj;
	NDTVWeatherPage NDTVWeatherPageobj;
	String CityName;

	@BeforeClass
	public void setup() {
		// new BaseClass();
		initialization();
		NDTVHomePageobj = new NDTVHomePage();
		NDTVHomePageobj.declineBreakingNewsNotification();
		NDTVWeatherPageobj = NDTVHomePageobj.clickOnWeatherLink();
		CityName = prop.getProperty("City");
	}

	@Test
	public void Verify_city_name_entered_and_checked() {
		NDTVWeatherPageobj.citySearchBox.sendKeys(CityName);
		WebElement checkbox = NDTVWeatherPageobj.CityCheckboxElementonSearch(CityName);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		Assert.assertTrue(checkbox.isSelected(),CityName+" is not selected from the search bar");
	}
	
	@Test(dependsOnMethods = {"Verify_city_name_entered_and_checked"})
	public void Verify_city_is_present_on_the_map() {
		
		boolean presence = NDTVWeatherPageobj.checkCityonMap(CityName);
		Assert.assertTrue(presence, "City "+CityName+" is not present on the map");
	}
	
	@Test(dependsOnMethods = {"Verify_city_is_present_on_the_map"})
	public void verify_temp_information_is_present_for_the_city() {
	WebElement cityElementOnMap =	NDTVWeatherPageobj.getCityElementonMap(CityName);
	cityElementOnMap.click();
	String str = NDTVWeatherPageobj.tempinCelcius.getText();
	System.out.println(str);
	Assert.assertTrue(NDTVWeatherPageobj.tempinCelcius.isDisplayed(),"Temp of city "+CityName+" is not visible on the map");
	
	}
}
