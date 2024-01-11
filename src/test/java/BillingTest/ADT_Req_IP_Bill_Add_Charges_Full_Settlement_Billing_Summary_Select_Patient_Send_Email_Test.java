package BillingTest;

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

import ADTPages.ADTAdmissionForm_WIth_Reg;
import ADTPages.ADTRequestForm;
import ADTPages.AdmissionRegScreen;
import BillingPages.ADTRequestedForm_IP_Bill_Full_Settlement_Cash_Apply_Discount;
import BillingPages.ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email;
import BillingPages.ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_View_Bill;
import Pages.Login;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email_Test 
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
	@Parameters ({"PriNumberPar","PatientNamePar","ExpiryDatePar","DOBPar","MobilePar","EmailPar","DOAPar","LengthPar","NotesPar","RemarksPar"})
	public void TC_02_User_Able_To_Do_AdmissionRequestform(String PriNumberPar,String PatientNamePar,String ExpiryDatePar,String DOBPar,String MobilePar,String EmailPar,String DOAPar,String LengthPar,String NotesPar,String RemarksPar) throws InterruptedException, IOException
	{
		ADTRequestForm ADT=new ADTRequestForm (driver);
		ADT.ADTFORREQUEST(PriNumberPar,PatientNamePar,ExpiryDatePar,DOBPar,MobilePar,EmailPar,DOAPar,LengthPar,NotesPar,RemarksPar);
	}
	@Test(priority=3)
	@Parameters({"AddressPar"})
	public void TC_03_User_Able_to_Do_ADTRegistartionForm(String AddressPar) throws InterruptedException, IOException
	{		
		AdmissionRegScreen ADTReg=new AdmissionRegScreen(driver);
		ADTReg.Registration(AddressPar);		
	}
	@Test(priority=4)
	@Parameters({"LengthOfStayPar","AdmittingDiagPar","AddNotesPar","PatientNotesPar","AdmissionRemarksPar","BillEstimationPar","ReferralRemarksPar","NamePar","IdentificationNOPar","PhoneNumberPar","AddressPar","ZipCodePar"})
	public void TC_04_Verify_User_Can_Fill_ADT_Admission_Form(String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String BillEstimationPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar,String ZipCodePar) throws InterruptedException, IOException
	{
		ADTAdmissionForm_WIth_Reg ADTForm=new ADTAdmissionForm_WIth_Reg(driver);
		ADTForm.ADT_Admission_Form(LengthOfStayPar, AdmittingDiagPar, AddNotesPar, PatientNotesPar, AdmissionRemarksPar, BillEstimationPar, ReferralRemarksPar, NamePar, IdentificationNOPar, PhoneNumberPar,AddressPar,ZipCodePar);
	}
	@Test(priority=5)
	public void TC_05_Verify_That_User_Is_Able_To_Send_Email_To_Patient_After_Bill_Completed() throws InterruptedException, IOException
	{
		ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email ip=new ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email(driver);
		ip.ADT_REQ_IPD_BIll_FullSettelment_Billing_Summary_Send_Email();
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException 
	{
		recorder = new ATUTestRecorder(".//Videos//","ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email_Test-"+dateFormat.format(date),false);
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
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_ADT_Req_IP_Bill_Add_Charges_Full_Settlement_Billing_Summary_Select_Patient_Send_Email_Test.png"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		//driver.quit();
		recorder.stop();
	}
}