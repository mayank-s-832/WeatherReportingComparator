package com.comparator.qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.comparator.qa.base.BaseClass;
import com.comparator.qa.pages.NDTVHomePage;
import com.comparator.qa.pages.NDTVWeatherPage;

public class NDTVWeatherTest extends BaseClass {
	
	NDTVHomePage NDTVHomePageobj;
	NDTVWeatherPage NDTVWeatherPageobj;
	String CityName;

	
	@BeforeMethod
	public void setup() {
		//new BaseClass();
		initialization();
		NDTVHomePageobj = new NDTVHomePage();
		NDTVWeatherPageobj = new NDTVWeatherPage();
		CityName = prop.getProperty("City");
		}

  @Test
  public void f() {
	  System.out.println(CityName);
  }
}
