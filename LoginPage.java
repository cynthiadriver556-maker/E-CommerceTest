package com.simplilearn.SeleniumDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simplilearn.SeleniumDemo.utils.Log;

public class LoginPage extends BasePage {
	
	@FindBy(name = "username")  //locator
	public WebElement login_username;
	
	@FindBy(name = "password")  //locator
	public WebElement login_password;
	
	@FindBy(tagName= "button")  //locator for login button
	public WebElement login_button;
	
	//@FindBy()
	//public WebElement // locatpr for invalid  username

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Page actions using Base Page methods
	public void enterUsername(String username) {
	Log.step("Enter username");
		safeType(login_username, username);
	}
	
	public void enterPassword(String password) {
		Log.step("Enter password");
		safeType(login_password, password);
	}
	
	public void clickLogin() {
		Log.step("clicking login button");
		safeClick(login_button);
	}
	
	public DashboardPage loginValidUser(WebDriver driver, String user, String pass) {
		Log.step("Login Flow with valid user");
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
		waitForUrlContains("/dashboard");
		return new DashboardPage(driver);
	}


	public DashboardPage loginInValidUser(WebDriver driver, String user, String pass) {
		Log.step("Login Flow with valid user");
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
		waitForUrlContains("/dashboard");
		return new DashboardPage(driver);
	}

/*	*public String loginInvalidUser(WebDriver driver, String user, String pass) {
		Log.step("Login Flow with invalid user");
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
		//waitForUrlContains("/dashboard");
		//return new DashboardPage(driver);
		
		return null;
	}*/
	
	
	
	
	
	

}

	
	

