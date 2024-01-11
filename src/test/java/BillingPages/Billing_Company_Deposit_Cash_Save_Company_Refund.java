package BillingPages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Billing_Company_Deposit_Cash_Save_Company_Refund 
{
	WebDriver driver;
	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	By ADTMenu=By.xpath("//*[@id='mat-menu-panel-16']/div/div/div[1]/div[1]/div[3]/div/span");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By AdmissionForm=By.xpath("//span[contains(text(),'Admission Form')]");
	By BillingMenuClik=By.xpath("//span[contains(text(),'Billing')]");
	//Sub Bill Menu
	By BillClick=By.cssSelector("a[id='31']");
	//DepositClick
	By DepositClick=By.cssSelector("a[id='30']");
	//COmpany Sub Menu
	By CompanyMenuClick=By.cssSelector("a[id='131']");
	//COmpany Type
	By CompanyTypeClick=By.cssSelector("mat-select[ng-reflect-name='companyType']");
	By CompanySelOpt=By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[1]/span");
	//company
	By CompanySelectClick=By.cssSelector("mat-select[placeholder='Select Company']");
	//COmpany Select Option
	By CompanySelOptClick=By.xpath("//span[contains(text(),'AIA Berhad')]");
	//Search click
	By SearchClick=By.xpath("//mat-icon[contains(text(),'search')]");
	//Amount
	By AmountClick=By.cssSelector("input[formcontrolname='amount']");
	//Remark
	By RemarkClcik=By.cssSelector("input[ng-reflect-name='remark']");
	//Save button
	By SaveBtnClick=By.cssSelector("mat-icon[ng-reflect-message='Save']");
	//Add payment details
	By AddPaymentDetailsClick=By.cssSelector("mat-icon[ng-reflect-message='Add Payment Details']");
	//Save payment Details
	By SavePaymentBtnClick=By.cssSelector("mat-icon[ng-reflect-message='Save Payment Details']");
	//Yes Button
	By YesBtnClick=By.xpath("//mat-icon[contains(text(),'done')]");

	//..Refund..//
	By RefundMenuClick=By.cssSelector("a[id='5998']");
	//Refund Company
	By RefundCompanyClick=By.cssSelector("a[id='6000']");
	//Button Add refund
	By ButtonAddRefundClick=By.cssSelector("button[data-automation-attribute='button-add-refund']");
	//Company type
	By CompanyTypeClick1=By.cssSelector("mat-select[data-automation-attribute='select-deposit-against']");
	By CompanyTypeSelOpt1=By.xpath("//span[contains(text(),'Insurance')]");

	//Company
	By CompanyClick1=By.cssSelector("mat-select[data-automation-attribute='select-encounter-type']");
	By CompanySelOpt1=By.xpath("//span[contains(text(),'AIA Berhad')]");

	//Check all deposit
	By CheckDeposit=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-refund-against-companydeposit/app-refund-against-deposit/div[3]/div[1]/table/tbody/tr[1]/td[1]/mat-checkbox/label");
	//Refund amount click
	By RefundAmountClick=By.cssSelector("input[ng-reflect-name='Ramount']");
	//Save button click
	By SaveButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Save']");

	//Add payment Details
	By AddPaymentDetails=By.cssSelector("mat-icon[ng-reflect-message='Add Payment Details']");
	//Save Payment Details
	By SavePaymentDetailsClick=By.cssSelector("mat-icon[ng-reflect-message='Save Payment Details']");
	//Button Save Dialog 
	By ButtonSaveDialogClick=By.xpath("/html/body/div[2]/div[4]/div/mat-dialog-container/app-confirm-dialog/div/form/div[3]/div/button[1]/span[1]/mat-icon");
	//Final Confirm Button
	By FinalCOnfirmBtn=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-dynamic-confirm-dialog/div/form/div[3]/div/button[1]/span[1]/mat-icon");
	public void Billing_Company_Deposit_Refund_Amount() throws InterruptedException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		WebElement ele1=driver.findElement(mainmenuADTScreen);
		act.moveToElement(ele1).build().perform();
		act.click(ele1).perform();

		Thread.sleep(8000);
		driver.findElement(BillingMenuClik).click();

		//Over the slide bar in Billing menu Screen
		Thread.sleep(3000);
		WebElement overforopdslide2=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide2).build().perform();

		//DepositClick
		Thread.sleep(5000);
		driver.findElement(BillClick).click();

		//DepositClick
		Thread.sleep(3000);
		driver.findElement(DepositClick).click();

		//CLicking on Company Sub Menu
		Thread.sleep(3000);
		driver.findElement(CompanyMenuClick).click();

		Thread.sleep(3000);
		driver.findElement(CompanyTypeClick).click();
		Thread.sleep(3000);
		driver.findElement(CompanySelOpt).click();

		//Select company click
		Thread.sleep(2000);
		driver.findElement(CompanySelectClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("AIA Berhad");
		Thread.sleep(2000);
		driver.findElement(CompanySelOptClick).click();

		//Click on search
		Thread.sleep(2000);
		driver.findElement(SearchClick).click();

		//Click on Amount
		Thread.sleep(2000);
		driver.findElement(AmountClick).sendKeys("10000");

		//Click on Remarks
		Thread.sleep(2000);
		driver.findElement(RemarkClcik).sendKeys("Adding company deposit");

		//Save Button
		Thread.sleep(2000);
		driver.findElement(SaveBtnClick).click();

		//Click on Add payment details
		Thread.sleep(2000);
		driver.findElement(AddPaymentDetailsClick).click();

		//Click on Add payment details
		Thread.sleep(2000);
		driver.findElement(SavePaymentBtnClick).click();

		//Clicking on Yes button
		//Click on Add payment details
		Thread.sleep(2000);
		driver.findElement(YesBtnClick).click();

		//TabSwitch
		Thread.sleep(5000);
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles

		ArrayList<Object> tabs = new ArrayList<Object> (driver.getWindowHandles());

		//Use the list of window handles to switch between windows
		Thread.sleep(5000);
		driver.switchTo().window((String)tabs.get(0));

		//....Company Refund....//

		//Over the slide bar in Billing menu Screen
		Actions act2 = new Actions(driver);
		Thread.sleep(3000);
		WebElement overforopdslide3=driver.findElement(SideBarMenuADTScreen);
		act2.moveToElement(overforopdslide3).build().perform();

		Thread.sleep(4000);
		driver.findElement(RefundMenuClick).click();

		//Click on company menu
		Thread.sleep(3000);
		driver.findElement(RefundCompanyClick).click();

		//Clicking on add button
		Thread.sleep(3000);
		driver.findElement(ButtonAddRefundClick).click();

		//Company type
		Thread.sleep(2000);
		driver.findElement(CompanyTypeClick1).click();
		Thread.sleep(2000);
		driver.findElement(CompanyTypeSelOpt1).click();

		//Company 
		Thread.sleep(2000);
		driver.findElement(CompanyClick1).click();
		Thread.sleep(2000);
		driver.findElement(CompanySelOpt1).click();

		//Select Check box
		Thread.sleep(2000);
		driver.findElement(CheckDeposit).click();

		//Refund amount
		Thread.sleep(2000);
		driver.findElement(RefundAmountClick).sendKeys("100");

		//Click on save
		Thread.sleep(2000);
		driver.findElement(SaveButtonClick).click();

		//Click on add payment details button
		Thread.sleep(2000);
		driver.findElement(AddPaymentDetails).click();

		//Click on Save payment details
		Thread.sleep(2000);
		driver.findElement(SavePaymentDetailsClick).click();

		//Click on save button dialog
		Thread.sleep(2000);
		driver.findElement(ButtonSaveDialogClick).click();

		//Final Confirm Btn

		Thread.sleep(2000);
		driver.findElement(FinalCOnfirmBtn).click();

		//TabSwitch
		Thread.sleep(5000);
		String windowHandle2 = driver.getWindowHandle();

		//Get the list of window handles

		ArrayList<Object> tabs2 = new ArrayList<Object> (driver.getWindowHandles());

		//Use the list of window handles to switch between windows
		Thread.sleep(5000);
		driver.switchTo().window((String)tabs2.get(0));


	}
	public Billing_Company_Deposit_Cash_Save_Company_Refund(WebDriver driver)
	{
		this.driver=driver;
	}
}
