package com.cbs.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;

public class TuringSearchAndShortKeys extends TestBase
{
	Actions action;
	@FindBy(xpath="//input[@id='turingSearchtext']")
	WebElement turing_search;
	
	
	public TuringSearchAndShortKeys()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void serachByCustomerID() throws Exception
	{
		turing_search.sendKeys("100678");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void serachByCustomerName() throws Exception
	{
		turing_search.clear();
		Thread.sleep(2000);
		turing_search.sendKeys("sidharth sunil malhotra");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
	}
	
	public void serachByCustomerAccountNumber() throws Exception
	{
		turing_search.clear();
		Thread.sleep(2000);
		turing_search.sendKeys("100020011000217");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
	}
	
	public void serachByPANNumber() throws Exception
	{
		turing_search.clear();
		Thread.sleep(2000);
		turing_search.sendKeys("caypk0853q");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
	}
	
	public void serachByAadhaarNumber() throws Exception
	{
		turing_search.clear();
		Thread.sleep(2000);
		turing_search.sendKeys("878787878798");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
	}
	
	public void serachByMobilenumber() throws Exception
	{
		turing_search.clear();
		Thread.sleep(2000);
		turing_search.sendKeys("9555555555");
		Thread.sleep(2000);
		turing_search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		turing_search.clear();
	}
}
