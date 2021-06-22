package com.comparator.qa.TestCases;

import org.testng.annotations.Test;

import com.comparator.qa.OpenWeatherApi.GetTempOWAPI;
import com.comparator.qa.base.BaseClass;
import com.comparator.qa.pages.NDTVHomePage;
import com.comparator.qa.pages.NDTVWeatherPage;
import com.comparator.qa.util.TestUtil;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class TempratureComparisionTest extends BaseClass {
  
	NDTVHomePage NDTVHomePageobj;
	NDTVWeatherPage NDTVWeatherPageobj;
	GetTempOWAPI GetTempOWAPIobj;
	String CityName;
	String unit;
	String APIkey;
	int allowedVariation;

	@BeforeClass
	public void setup() {

		initialization();
		NDTVHomePageobj = new NDTVHomePage();
		NDTVHomePageobj.declineBreakingNewsNotification();
		NDTVWeatherPageobj = NDTVHomePageobj.clickOnWeatherLink();
		CityName = prop.getProperty("City");
		unit = prop.getProperty("units");
		APIkey = prop.getProperty("appid");
		allowedVariation = (Integer) prop.get("expectedVariation");
		
	}

  @Test
  public void Verify_the_difference_between_UI_and_API_is_not_greater_than_allowed_limit() throws IOException{
	  NDTVWeatherPageobj.citySearchBox.sendKeys(CityName);
		WebElement checkbox = NDTVWeatherPageobj.CityCheckboxElementonSearch(CityName);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		Assert.assertTrue(checkbox.isSelected(),CityName+" is not selected from the search bar");
		
		WebElement cityElementOnMap =	NDTVWeatherPageobj.getCityElementonMap(CityName);
		cityElementOnMap.click();
		
		String str = NDTVWeatherPageobj.tempinCelcius.getText();
		System.out.println(str);
	    int tempUI = TestUtil.extractNumericTemp(str);
	    float tempAPI = GetTempOWAPIobj.getTempfromOpenWeather(CityName, unit, APIkey);
	    //float tempAPI = 6.87f;
	    float variation = Math.abs(tempAPI-tempUI);
	    System.out.println("actual variation: "+variation);
	    System.out.println("allowed variation: "+allowedVariation);
	    Assert.assertTrue(variation<allowedVariation, "The variation is more than the expected");
	    
	    
		
  }

}
