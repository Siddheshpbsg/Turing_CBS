package com.cbs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbs.base.TestBase;

public class Homepage extends TestBase
{
	@FindBy(xpath="//span[contains(text(),'Customer Creation (Individual)')]")
	WebElement Customer_Creation_Individual;
	
	@FindBy(xpath="//span[contains(text(),'Customer Creation (Non-Individual)')]")
	WebElement Customer_Creation_Non_Individual;
	
	@FindBy(xpath="//span[contains(text(),'Customer Maintenance')]")
	WebElement Customer_Maintenance;
	
	@FindBy(xpath="//span[contains(text(),'CASA (Account Creation)')]")
	WebElement CASA_Creation;
	
	@FindBy(xpath="//span[contains(text(),'Account Master TD')]")
	WebElement TD_Account;
	
	@FindBy(xpath="//span[contains(text(),'Loan Account Creation')]")
	WebElement Loan_Account;
	
	@FindBy(xpath="//span[contains(text(),'Cash')]")
	WebElement Cash;
	
	@FindBy(xpath="//span[contains(text(),'Transfer')]")
	WebElement Transfer;
	
	@FindBy(xpath="//span[contains(text(),'Account Master TD')]")
	WebElement TD_Creation;
	
	@FindBy(xpath="//span[contains(text(),'Loan Account Creation')]")
	WebElement Loan_Creation;
	
	@FindBy(xpath="//span[contains(text(),'Teller')]")
	WebElement Teller;
	
	@FindBy(xpath="//span[contains(text(),'Balances')]")
	WebElement Balance;
	
	@FindBy(xpath="//span[contains(text(),'Admin')]")
	WebElement Admin;
	
	@FindBy(xpath="//div/a/span[(text()='Clearing Inward')]")
	WebElement ClearingInward;
	
	@FindBy(xpath="//*[@id='sub-menu-2']/span")
	WebElement Misclellneous;

	@FindBy(xpath="//a[text()='Chequebook']")
	WebElement Chequebook;
	
	@FindBy(xpath="//*[@id=\"jumbotron\"]/div[2]/div[1]/div[5]/div[3]/a")
	WebElement Clearing_Outward;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePage()
	{
		return driver.getTitle();
	}
	
	public IndividualcustomerPage clickOnCustomerCreationInd()
	{
		Customer_Creation_Individual.click();
		return new IndividualcustomerPage();
	}
	
	public CorparateCustomerPage clickOnCustomerCreationcorp()
	{
		Customer_Creation_Non_Individual.click();
		return new CorparateCustomerPage();
	}
	
	public CustomerMaitenancePage clickOnCustomerMaintenance()
	{
		Customer_Maintenance.click();
		return new CustomerMaitenancePage();
	}
	
	public CASACreationPage clickOnCASACreation()
	{
		CASA_Creation.click();
		return new CASACreationPage();
	}
	
	public TDCreationPage clickOnTDCreation()
	{
		TD_Creation.click();
		return new TDCreationPage();
	}
	
	public LoanCreationPage clickOnLoanCreation()
	{
		Loan_Creation.click();
		return new LoanCreationPage();
	}
	
	public CashPage clickOnCash()
	{
		Cash.click();
		return new CashPage();
	}
	
	public TransferPage clickOnTransfer()
	{
		Transfer.click();
		return new TransferPage();
	}
	
	public TellerPage clickOnTeller()
	{
		Teller.click();
		return new TellerPage();
	}
	 
	public BalancePage clickOnBalance()
	{
		Balance.click();
		return new BalancePage();
	}
	
	public Quicklinks clickOnQuicklinks()
	{
		return new Quicklinks();
	}
	
	public TuringSearchAndShortKeys turingSearchAndShortKeys()
	{
		return new TuringSearchAndShortKeys();
	}
	
	public AdminActivity adminActivity()
	{
		Admin.click();
		return new AdminActivity();
	}
	
	public ClearingInwardPage clickOnClearingInward()
	{
		ClearingInward.click();
		return new ClearingInwardPage();
	}
	
	public DD_PO_Issueance dd_po_issueance()
	{
		return new DD_PO_Issueance();
	}
	
	public ChequebookPage clickOnChequebook() throws InterruptedException
	{
		Misclellneous.click();
		Thread.sleep(2000);
		Chequebook.click();
		return new ChequebookPage();
	}
	
	public Clearing_Outward clickonClearingOutward()
	{
		Clearing_Outward.click();
		return new Clearing_Outward();
	}
	
}
