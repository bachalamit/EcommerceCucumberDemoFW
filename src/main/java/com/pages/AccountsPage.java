package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	private By accountSections = By.cssSelector("div#center_column span");
		
	public AccountsPage(WebDriver driver) {
	this.driver=driver;
		
	}
	
	public String getAccPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getAccSectionCounts()
	{
		return driver.findElements(accountSections).size();
	}

	public List<String> getAccSectionsList()
	{
		List<String> tempacclist = new ArrayList<>();
		List<WebElement> acclist = driver.findElements(accountSections);
		for(WebElement e : acclist)
		{
				String text = e.getText();
				System.out.println(text);
				tempacclist.add(text);
		}
		
		return tempacclist;
			
	}
}
