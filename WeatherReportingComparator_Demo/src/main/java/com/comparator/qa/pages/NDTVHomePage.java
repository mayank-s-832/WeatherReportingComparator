package com.comparator.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comparator.qa.base.BaseClass;

public class NDTVHomePage extends BaseClass {
	
	@FindBy(linkText = "No Thanks")
	WebElement notificationDecline;
	
	@FindBy(xpath = "//a[@id ='h_sub_menu']")
	WebElement expandButton;

	@FindBy(xpath = "//a[contains(text(),'WEATHER')]")
	WebElement weatherPageLink;
	
	public NDTVHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public NDTVWeatherPage clickOnWeatherLink() {
		expandButton.click();
		weatherPageLink.click();
		return new NDTVWeatherPage();
	}
	
	public void declineBreakingNewsNotification() {
		if(notificationDecline.isDisplayed()) {
			notificationDecline.click();
		}
		
	}
}
