package com.cbs.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.cbs.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener
{
	public void beforeChangeValueOf(WebElement element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Value of the: " +element.toString() + "before any change mode");
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) 
	{	// TODO Auto-generated method stub
		System.out.println("Element value change to:" +element.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Before click on:" + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("After Click on:" + element.toString());
	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) 
	{// TODO Auto-generated method stub
		System.out.println("Before finding element:" + element.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("After finding element:" + element.toString() + "Using method:" + by.toString());
	}

	public void beforeNavigateBack(WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Before Navigateback to:" + driver.getCurrentUrl());
	}
	
	public void afterNavigateBack(WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("After navigateback to " + driver.getCurrentUrl());
	}

	public void beforeNavigateForward(WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Before NavigateForward:" + driver.getCurrentUrl());

	}
	
	public void afterNavigateForward(WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("After NavigateForward:" + driver.getCurrentUrl());
	}

	public void beforeNavigateTo(String url, WebDriver driver)
	{
		// TODO Auto-generated method stub
		System.out.println("Before NavigateTo" + url);
	}
	
	public void afterNavigateTo(String url, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("After NavigateTo" + url);
	}

	public void beforeScript(String element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Before Script:" + element);
	}
	
	public void afterScript(String element, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Inside the afterScript, Script is " + element);
	}

	public void onException(Throwable error, WebDriver driver)
	{	// TODO Auto-generated method stub
		System.out.println("Exception occured at " + error.getMessage());
		try
		{
			System.out.println("Break Application1");
			TestUtil util=new TestUtil();
			util.getscreenshot();
			System.out.println("Break Application2");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void beforeAlertAccept(WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver)
	{
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
}
