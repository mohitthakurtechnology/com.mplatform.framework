package com.mplatform.framework.pagefactory.webapp.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath = "//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='login-button']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(String userName,String passWord)
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();
	}
	
}
