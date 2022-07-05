package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
	
	private WebDriver driver;
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInbtn = By.id("SubmitLogin");
	private By forgotpwdlink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean forgotPasswordlink()
	{
		return driver.findElement(forgotpwdlink).isDisplayed();
	}
	public void enterUserName(String uname)
	{
		driver.findElement(emailID).sendKeys(uname);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickonSignIn()
	{
		driver.findElement(signInbtn).click();
	}
	
	public AccountsPage doLogin(String uname, String pwd) {
		driver.findElement(emailID).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInbtn).click();
		
		return new AccountsPage(driver);

	}
}
