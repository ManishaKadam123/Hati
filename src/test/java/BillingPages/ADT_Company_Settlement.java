package BillingPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ADT_Company_Settlement {
	WebDriver driver;
	//For all Drop down Search
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By IPDBillClick=By.xpath("//span[contains(text(),'IPD Bill')]");
	//Company Invoicing
	By CompanyInvoicingMenu=By.cssSelector("a[id='30005']");
	//Company Invoice Sub menu
	By CompanyInvoiceSubMenu=By.cssSelector("CompanyInvoicingMenu");
	//Company Type 1
	By CompanyType1Click=By.cssSelector("mat-select[formcontrolname='payerType']");
	By CompanyType1SelOpt=By.xpath("//span[contains(text(),'Insurance')]");

	//Company from Company invoice
	By Company1Click=By.cssSelector("mat-select[formcontrolname='payer']");
	By Company1SelOpt=By.xpath("//span[contains(text(),'AIA Berhad')]");
	//Dates
	//SelectDispatchDate
	By DispatchStartDate1Click=By.cssSelector("input[ng-reflect-name='fromDate']");
	By DispatchEndDate1Click=By.cssSelector("input[ng-reflect-name='toDate']");
	//Search Button
	By Search1Click=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-invoice-corporate/div[1]/form/mat-grid-list/div/mat-grid-tile[4]/div/mat-icon");
	//Save button
	By SaveClick1=By.cssSelector("button[type='submit']");




	//Invoice settlement
	By InvoiceSettlement=By.cssSelector("a[id='30216']");
	//Company type
	By CompanyTypeClick=By.cssSelector("mat-select[ng-reflect-name='payerType']");
	By CompanyTypeSelOpt=By.xpath("//span[contains(text(),'Insurance')]");

	//Company
	By CompanyClick=By.cssSelector("mat-select[ng-reflect-name='payer']");
	By COmpanySelOpt=By.xpath("//span[contains(text(),'AIA Berhad')]");

	//SelectDispatchDate
	By DispatchStartDateClick=By.cssSelector("input[ng-reflect-name='fromDate']");
	By DispatchEndDateClick=By.cssSelector("input[ng-reflect-name='toDate']");

	public void Company_Settlement() throws InterruptedException
	{
		
		Actions act = new Actions(driver);
		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide1).build().perform();

		//Clicking on IPD Bill
		Thread.sleep(3000);
		driver.findElement(IPDBillClick).click();


		//....Company invoice.....//
		//Clicking on Invoice settlement
		Thread.sleep(3000);
		driver.findElement(CompanyInvoicingMenu).click();

		Thread.sleep(3000);
		driver.findElement(CompanyInvoiceSubMenu).click();
		
		//Company Type
		Thread.sleep(2000);
		driver.findElement(CompanyTypeClick).click();
		Thread.sleep(2000);
		driver.findElement(CompanyTypeSelOpt).click();

		//Company
		Thread.sleep(2000);
		driver.findElement(CompanyClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("AIA Berhad");
		Thread.sleep(2000);
		driver.findElement(COmpanySelOpt).click();

	//start date end date
		Thread.sleep(2000);
		driver.findElement(DispatchStartDate1Click).sendKeys("01/01/2024");
		Thread.sleep(2000);
		driver.findElement(DispatchEndDate1Click).sendKeys("31/01/2024");
		//Clicking on Search button
		Thread.sleep(3000);
		driver.findElement(Search1Click).click();


		Actions act2 = new Actions(driver);
		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide2=driver.findElement(SideBarMenuADTScreen);
		act2.moveToElement(overforopdslide2).build().perform();

		//..Clicking on Invoice Settlement...//
		Thread.sleep(3000);
		driver.findElement(InvoiceSettlement).click();

		//Company Type
		Thread.sleep(2000);
		driver.findElement(CompanyTypeClick).click();
		Thread.sleep(2000);
		driver.findElement(CompanyTypeSelOpt).click();

		//Company
		Thread.sleep(2000);
		driver.findElement(CompanyClick).click();
		Thread.sleep(2000);
		driver.findElement(AllDropDownSearch).sendKeys("AIA Berhad");
		Thread.sleep(2000);
		driver.findElement(COmpanySelOpt).click();




	}


	public ADT_Company_Settlement(WebDriver driver)

	{
		this.driver=driver;

	}
}
