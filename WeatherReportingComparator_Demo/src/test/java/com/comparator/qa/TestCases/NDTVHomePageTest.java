package com.comparator.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.comparator.qa.base.BaseClass;
import com.comparator.qa.pages.NDTVHomePage;
import com.comparator.qa.pages.NDTVWeatherPage;

public class NDTVHomePageTest extends BaseClass {
	
	NDTVHomePage NDTVHomePageobj;
	NDTVWeatherPage NDTVWeatherPageobj;

	
	@BeforeMethod
	public void setup() {
		initialization();
		NDTVHomePageobj = new NDTVHomePage();
		NDTVHomePageobj.declineBreakingNewsNotification();
		}
  @Test
  public void WebsiteTitletest() {
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Get Latest News, India News, Breaking News, Today's News - NDTV.com", "Please check the url: not on correct webpage");
  }
}
