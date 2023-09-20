package com.cbs.pages;

import java.awt.Robot;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;
import com.cbs.util.TestUtil;

public class ClearingInwardPage extends TestBase
{
	Actions action=new Actions(driver);
	TestUtil util=new TestUtil();
	
	@FindBy(xpath="//a[@id='id_closeModal']")
	WebElement closeModal;
	
	public ClearingInwardPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void uploadInwardFile() throws Exception
	{
		util.inwardUpload();
		closeModal.click();
	}
}
