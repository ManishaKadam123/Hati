package ADTTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ADTPages.ADT_Admission_List_Dashboard_Advanced_Search_By_MRN;
import Pages.Login;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ADTAdmissionListDashboard_Advanced_Search_By_MRN 
{
	public WebDriver driver;
	ATUTestRecorder recorder;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	
	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_ADT_Admission_Form_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		Login Loginapp=new Login(driver);
		Loginapp.login_Medcare(Uesrid);

	}
	@Test(priority=2)
	@Parameters({"MRNPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Search_Admission_Record_Through_Advanced_Search_By_MRN(String MRNPar) throws InterruptedException, IOException
	{
		ADT_Admission_List_Dashboard_Advanced_Search_By_MRN adtsearch=new ADT_Admission_List_Dashboard_Advanced_Search_By_MRN(driver);
		adtsearch.ADTDashboardAdmissionListAdvancedSearch(MRNPar);
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException 
	{
		recorder = new ATUTestRecorder(".//Videos//","ADTAdmissionListDashboard_Advanced_Search_By_MRN-"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		Thread.sleep(8000);
		driver.manage().window().maximize(); 
	}
	@AfterMethod(alwaysRun=true)
	public void FailedScreenShot(ITestResult Result) throws IOException
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_ADTAdmissionListDashboard_Advanced_Search_By_MRN"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		driver.quit();
		recorder.stop();
	}
}
