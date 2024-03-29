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

import ADTPages.ADTRequestForm;
import ADTPages.AdmissionRegScreen;
import BillingPages.ADTAdmissionForm_WIth_Reg_with_Insurance;
import BillingPages.ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient;
import BillingPages.ADT_Reg_Insurance_GL_Approval_IP_Bill_Save_Company_settlement;
import BillingPages.GLApproval;
import BillingPages.GLApproval_ADT_Requested_FOR_IP_Charge_IP_BILL;
import BillingPages.GLApproval_For_OP_IP_FOR_IP_Charge_IP_BILL;
import BillingPages.IP_Charges_For_Self_Payer;
import Pages.Login;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient_Test 
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
	public void TC_04_Verify_User_Can_Fill_ADT_Admission_Form_With_Insurance(String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String BillEstimationPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar,String ZipCodePar) throws InterruptedException, IOException
	{
		ADTAdmissionForm_WIth_Reg_with_Insurance ADTForm=new ADTAdmissionForm_WIth_Reg_with_Insurance(driver);
		ADTForm.ADT_Admission_Form_with_Insurance(LengthOfStayPar, AdmittingDiagPar, AddNotesPar, PatientNotesPar, AdmissionRemarksPar, BillEstimationPar, ReferralRemarksPar, NamePar, IdentificationNOPar, PhoneNumberPar,AddressPar,ZipCodePar);
	}	
	@Test(priority=5)
	@Parameters({"PolicyNoPar","PolicyDatePar","HolderNamePar","CustomerNamePar","GLRefNOPar","GLDatePar","ExpiryDatePar","GLAmountPar","CoverageAmountPar","ContactNamePar","DesignationPar","ContactNoPar","GLRemarksPar"})
	public void TC_05_Verify_User_Can_DO_GL_Approval_For_IP_BILL_Charge_Verification(String PolicyNoPar,String PolicyDatePar,String HolderNamePar,String CustomerNamePar,String GLRefNOPar,String GLDatePar,String ExpiryDatePar,String GLAmountPar,String CoverageAmountPar,String ContactNamePar,String DesignationPar,String ContactNoPar,String GLRemarksPar) throws InterruptedException, IOException
	{
		ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient GLIPChargesipbill=new ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient(driver);
		GLIPChargesipbill.GLApprovalForADT_Req_IPCharges_IPBILL_Charge_Verification(PolicyNoPar,PolicyDatePar,HolderNamePar,CustomerNamePar,GLRefNOPar,GLDatePar,ExpiryDatePar,GLAmountPar,CoverageAmountPar,ContactNamePar,DesignationPar,ContactNoPar,GLRemarksPar);	 
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException 
	{
		
		
		recorder = new ATUTestRecorder(".//Videos//","ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient_Test-"+dateFormat.format(date),false);
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
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_ADT_REQ_With_Payer_IP_Bill_Add_Charges_Against_Payer_Final_Bill_Charge_Verifi_Search_Patient_Test"+dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		//driver.quit();
		recorder.stop();
	}
}