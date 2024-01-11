package BillingPages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OPD_OP_Charges_Save_Charge_Verification_Serach_Patient 
{
	WebDriver driver;
	//----OPCharge---//
	//Menu icon 
	//By Search=By.xpath("mat-icon[mattooltip='Search']");
	By mainmenuADTScreen=By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	//By ADTMenu=By.xpath("//span[contains(text(),'ADT')]");
	By SideBarMenuADTScreen=By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By AdmissionForm=By.xpath("//span[contains(text(),'Admission Form')]");
	By BillingMenuClik=By.xpath("//span[contains(text(),'Billing')]");

	//By Search=By.xpath("mat-icon[mattooltip='Search']");
		By mainmenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/mat-icon[1]");
		By OPDMenu=By.xpath("//*[@id='mat-menu-panel-6']/div/div/div[1]/div[1]/div[1]/div/img");
		By SideBarMenu=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside");
		By RegistrationMenu=By.cssSelector("a[id='2004']");
		By EncounterList=By.cssSelector("a[id='2006']");

		
	//OPCharge
	By OPChargescreen=By.cssSelector("a[id='59985']");
	//By IPChargesClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[2]/ul/li[5]/a/span[1]");
	By ADT=By.xpath("//span[contains(text(),'ADT')]");
	By AdmissionDashboard=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[3]");

	//advanced search
	By AdvancedSearchClick2=By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	//MRN 
	By MRNCLick=By.cssSelector("input[ng-reflect-name='mrn']");
	//Search button
	By SearchButtonClick2=By.cssSelector("button[ng-reflect-message='Search']");

	//Taking MRN From dashboard
	By MRNClick=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-admission-dashboard/mat-drawer-container/mat-drawer-content/div/table/tbody/tr[1]/td[2]");
	//service Type
	By AllDropDownSearch=By.cssSelector("input[aria-label='dropdown search']");
	
	//Service Name
	By ServiceNameClick=By.cssSelector("input[ng-reflect-name='serviceName']");
	By ServiceNameSelOpt=By.xpath("//span[contains(text(),'Laparotomy - exploratory')]");

	//Specialty
	By SpecialityClick=By.cssSelector("mat-select[ng-reflect-name='department']");
	By SpecialitySelOpt=By.xpath("//span[contains(text(),'Rehabilitation')]");

	//Payer
	By PayerClick=By.cssSelector("mat-select[ng-reflect-name='payer']");
	By PayerSelOpt=By.xpath("//span[contains(text(),'Self')]");
	//Add Service Button
	By ServiceButtonClick=By.cssSelector("button[ng-reflect-message='Add Service']");
	//Save Button
	By SaveButtonClick=By.cssSelector("button[type='submit']");
	//Yes Button 
	By YesButtonClick=By.cssSelector("mat-icon[ng-reflect-message='Yes']");
	
	//Take MRN From Encounter List
	By MRNClick1=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-patient-encounter-list/mat-drawer-container/mat-drawer-content/div[2]/table/tbody/tr[1]/td[1]");
	//Clicking on radio button
			By RadioButton=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/mat-drawer-container/mat-drawer-content/div/div/app-charge-verification/app-patient-search/div/div/div/table/tbody/tr[2]/td[1]/div/mat-radio-button");
	//Charge Verification
		By ChargeVerificationClick=By.cssSelector("a[id='3116']");
		By SearchClick4=By.cssSelector("button[ng-reflect-message='Search']");
		//advanced search
		By AdvancedSearchClick3=By.xpath("/html/body/app-root/app-layout/ng-sidebar-container/div/div/app-header/nav/div[2]/mat-icon");
		//MRN 
		By MRNCLick3=By.cssSelector("input[ng-reflect-name='mrn']");
	public void OPD_OP_Charges_Charge_Verification() throws InterruptedException, IOException
	{

		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(8000);
		WebElement ele=driver.findElement(mainmenu);
		act.moveToElement(ele).build().perform();
		act.click(ele).perform();

		Thread.sleep(10000);
		driver.findElement(OPDMenu).click();

		//Over the slide bar in OPD Screen
		Thread.sleep(3000);
		WebElement overforopdslide1=driver.findElement(SideBarMenu);
		act.moveToElement(overforopdslide1).build().perform();

		Thread.sleep(5000);
		driver.findElement(RegistrationMenu).click();
		driver.findElement(RegistrationMenu).click();

		Thread.sleep(5000);
		driver.findElement(EncounterList).click();

		Thread.sleep(5000);
		WebElement MRN1=driver.findElement(MRNClick1);
		String MRNS=MRN1.getText();

		System.out.println("MRN Number:"+MRNS);
		Thread.sleep(4000);
		Actions act1 = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele2=driver.findElement(mainmenuADTScreen);
		act1.moveToElement(ele2).build().perform();
		act1.click(ele2).perform();

		Thread.sleep(3000);
		driver.findElement(BillingMenuClik).click();

		//Over the slide bar in Billing menu Screen
		Thread.sleep(3000);
		WebElement overforopdslide2=driver.findElement(SideBarMenuADTScreen);
		act.moveToElement(overforopdslide2).build().perform();

		//OPCharge
		Thread.sleep(4000);
		driver.findElement(OPChargescreen).click();

		Thread.sleep(4000);
		driver.findElement(AdvancedSearchClick2).click();

		Thread.sleep(2000);
		driver.findElement(MRNCLick).sendKeys(MRNS);

		Thread.sleep(3000);
		driver.findElement(SearchButtonClick2).click();
		
		/*//Selecting type of Service
		Thread.sleep(2000);
		driver.findElement(ServiceTypeClick).click();
		//Thread.sleep(1000);
		//driver.findElement(AllDropDownSearch).sendKeys("Service");
		Thread.sleep(1000);
		driver.findElement(ServiceSelOpt).click();*/

		//Selecting Service Name
		Thread.sleep(2000);
		driver.findElement(ServiceNameClick).sendKeys("Laparotomy");
		Thread.sleep(2000);
		driver.findElement(ServiceNameSelOpt).click();

		//Selecting type of Specialty
		Thread.sleep(2000);
		driver.findElement(SpecialityClick).click();
		Thread.sleep(1000);
		driver.findElement(AllDropDownSearch).sendKeys("Rehabilitation");
		Thread.sleep(1000);
		driver.findElement(SpecialitySelOpt).click();

		/*//Selecting type of Service
		Thread.sleep(2000);
		driver.findElement(PayerClick).click();
		//Thread.sleep(1000);
		//driver.findElement(AllDropDownSearch).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(PayerSelOpt).click();*/

		//Service button click
		Thread.sleep(2000);
		driver.findElement(ServiceButtonClick).click();

		//Save button click
		Thread.sleep(2000);
		driver.findElement(SaveButtonClick).click();

		//Yes Button Click
		Thread.sleep(2000);
		driver.findElement(YesButtonClick).click();

		Thread.sleep(5000);

		Actions actt = new Actions(driver);
		WebElement overforopdslide4=driver.findElement(SideBarMenuADTScreen);
		actt.moveToElement(overforopdslide4).build().perform();
		//Charge Verification......
		
		
		
				Thread.sleep(3000);
				driver.findElement(ChargeVerificationClick).click();

				//Advanced search
				Thread.sleep(3000);
				driver.findElement(AdvancedSearchClick3).click();

				// Enter MRN
				Thread.sleep(2000);
				driver.findElement(MRNCLick3).sendKeys(MRNS);
				
				//Click on search button
				Thread.sleep(3000);
				driver.findElement(SearchClick4).click(); 
				
				Thread.sleep(3000);
				driver.findElement(RadioButton).click();

		/*if (driver.getPageSource().contains("Order update Successfully.")) 
		{
			System.out.println("Order update Successfully");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File("C:\\Selenium Eclipse WorkSpace\\Medcare_Hati\\ScreenShot\\FailedIP_Charges_For_Self_Payer.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"Charegs not saved");
		}*/

	}
	public OPD_OP_Charges_Save_Charge_Verification_Serach_Patient(WebDriver driver)
	{
		this.driver=driver;
	}
}
