package BillingTest;
import java.awt.AWTException;
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

import BillingPages.OPD_OP_Charges_Save_Charge_Verification_Serach_Patient;
import Pages.Login;
import Pages.Quick_Registration;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OPD_Reg_Encounter_OP_charge_Charge_Verification_Search_patient_Test 
{
	public WebDriver driver;
	ATUTestRecorder recorder;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_Verify_Login(String Uesrid) throws InterruptedException, IOException 
	{
		//Login
		Login LoginScreen=new Login(driver);
		LoginScreen.login_Medcare(Uesrid);
	}	
	@Test(priority=2)
	@Parameters({"QuickPrimaryIdNumberPar","QuickExparyDatePar","QuickFullNamePar","QuickDateOfBirthPar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration(String QuickPrimaryIdNumberPar,String QuickExparyDatePar,String QuickFullNamePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
	{
		Quick_Registration QuickReg=new Quick_Registration (driver);
		QuickReg.Quick_Registration_Verification(QuickPrimaryIdNumberPar,QuickExparyDatePar,QuickFullNamePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);	
	}
	 @Test(priority=3)
	 public void TC_03_Verify_That_User_Can_Verify_That_Charge_Verification_For_OP_Charge() throws InterruptedException, IOException
	 {
		 OPD_OP_Charges_Save_Charge_Verification_Serach_Patient charge=new OPD_OP_Charges_Save_Charge_Verification_Serach_Patient(driver);
		 charge.OPD_OP_Charges_Charge_Verification();
	 }
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException 
	{
		recorder = new ATUTestRecorder(".//Videos//","OPD_Reg_Encounter_OP_charge_Charge_Verification_Search_patient_Test"+dateFormat.format(date),false);
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
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_OPD_Reg_Encounter_OP_charge_Charge_Verification_Search_patient_Test"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		//driver.quit();
		recorder.stop();
	}
}
