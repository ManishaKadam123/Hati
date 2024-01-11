package ADTPages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class Existing_Admission_Request_Advanced_Search_By_Name {
	WebDriver driver = null;
	By mainmenu = By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By OPDMenu = By.xpath("//span[contains(text(),'OPD')]");
	By SideBarMenu = By.cssSelector("aside[ng-reflect-ng-class='sidebar-panel']");
	By RegistrationMenu = By.xpath("//span[contains(text(),'Registration')]");
	By EncounterListClick = By.xpath("//span[contains(text(),'Encounter List')]");
	By mainmenuADTScreen = By.cssSelector("mat-icon[ng-reflect-message='Menu']");
	By ADT = By.xpath("//span[contains(text(),'ADT')]");
	By AdmissionDashboard = By.xpath(
			"/html/body/app-root/app-layout/ng-sidebar-container/ng-sidebar/aside/app-sidebar/app-menu/ul/li[3]");

	// Advanced Search
	By AdvancedSearchClick = By.cssSelector("mat-icon[ng-reflect-message='Expand']");
	// MRN
	By NameClick = By.cssSelector("input[ng-reflect-name='patientName']");
	// Search
	By SearchClick = By.cssSelector("button[ng-reflect-message='Search']");
	// AddButton
	By AddButton = By.cssSelector("mat-icon[ng-reflect-message='Add Admission Request']");

	public void ADTExistingAdmissionAdvancedSearch_By_Name(String NamePar) throws InterruptedException, IOException {
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement ele = driver.findElement(mainmenu);
		act.moveToElement(ele).build().perform();
		act.click(ele).perform();
		// ADT
		Thread.sleep(3000);
		driver.findElement(ADT).click();

		// AddButton
		Thread.sleep(3000);
		driver.findElement(AddButton).click();
		if (driver.getPageSource().contains("Admission Request")) {
			System.out.println("Admission Request screen Showing successfully");
		} else 
		{
			System.out.println("Admission Requst page failed");
		}
		// Click on Advanced Search
		Thread.sleep(3000);
		driver.findElement(AdvancedSearchClick).click();

		Thread.sleep(3000);
		driver.findElement(NameClick).sendKeys(NamePar);

		Thread.sleep(3000);
		driver.findElement(SearchClick).click();
		Thread.sleep(3000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if (driver.getPageSource().contains(NamePar)) 
		{
			System.out.println(NamePar + " " + "Patient searched successfully ");
		}
		else
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//FailedExisting_Admission_Request_Advanced_Search_By_Name.png"+ dateFormat.format(date)));
			Assert.assertTrue(false,"No patients found matching this search");
		}
			File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot2, new File(".//ScreenShot\\Existing_Admission_Request_Advanced_Search_By_Name.png"+ dateFormat.format(date)));
		}

	public Existing_Admission_Request_Advanced_Search_By_Name(WebDriver driver) 
	{
		this.driver = driver;
	}
}
