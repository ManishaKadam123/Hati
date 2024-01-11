package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.OPD_Reg_WIth_OLD_IC_With_VIP_Patient;
import Pages.OPD_Registration_Encounter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OPD_Reg_ID_OLD_IC_With_VIP_Patient {
public WebDriver driver;	
	

	@Test	
	@Parameters({"Uesrid"})
	
public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
{
		Login Loginapp=new Login(driver);
		 Loginapp.login_Medcare(Uesrid);
		 
}

@Test
@Parameters({"PrimaryIdNumber12","SecondaryIdNumber12","SecondaryExparyDatePar","FullNamePar","DateOfBirthPar","MotherNamePar","PatientNotes","ResidentialAddressPar","PostCodePar","MobileNumberPar","Emailpar","PersonalFaxpar","WorkFaxpar","WorkContactNopar","HomeContactNopar","EmploymentNoPar","WorkFromPar","ContactNumberPar","ResAddPar","PostCodePar12","Healthtouristcodepar","AgentIdNoPar","AgentNamePar","StartDatePar","EndDatePar","ContactNoPar4","EmailIdPar4","Address23Par","PostCodePar34"})
public void TC_02_Verify_That_User_Is_Able_Fill_The_Basic_Information_To_Registration_Page_WIth_VIP_Patient_for_OLD_IC(String PrimaryIdNumber12,String SecondaryIdNumber12,String SecondaryExparyDatePar,String FullNamePar,String DateOfBirthPar,String MotherNamePar,String PatientNotes,String ResidentialAddressPar,String PostCodePar,String MobileNumberPar,String Emailpar,String PersonalFaxpar,String WorkFaxpar,String WorkContactNopar,String HomeContactNopar,String EmploymentNoPar,String WorkFromPar,String ContactNumberPar,String ResAddPar,String PostCodePar12,String Healthtouristcodepar,String AgentIdNoPar,String AgentNamePar,String StartDatePar,String EndDatePar,String ContactNoPar4,String EmailIdPar4,String Address23Par,String PostCodePar34) throws InterruptedException, IOException, AWTException 
{
	OPD_Reg_WIth_OLD_IC_With_VIP_Patient   reg=new OPD_Reg_WIth_OLD_IC_With_VIP_Patient (driver);
	  reg.OPD_Reg_With_OLD_IC_VIP_Patient(PrimaryIdNumber12,SecondaryIdNumber12,SecondaryExparyDatePar,FullNamePar,DateOfBirthPar,MotherNamePar,PatientNotes,ResidentialAddressPar,PostCodePar,MobileNumberPar,Emailpar,PersonalFaxpar,WorkFaxpar,WorkContactNopar,HomeContactNopar,EmploymentNoPar,WorkFromPar,ContactNumberPar,ResAddPar,PostCodePar12,Healthtouristcodepar,AgentIdNoPar,AgentNamePar,StartDatePar,EndDatePar,ContactNoPar4,EmailIdPar4,Address23Par,PostCodePar34);	  
}
@Test
@Parameters({"EncounterRemarksPar","AddNotesPar","NamePar","IdentificationNOPar","PhoneNoPar","AddressPar","PostcodeParAdetailsPar"})
public void TC_03_Verify_That_User_Is_Able_TO_Fill_Encounter_Details(String EncounterRemarksPar,String AddNotesPar,String NamePar,String IdentificationNOPar,String PhoneNoPar,String AddressPar,String PostcodeParAdetailsPar) throws InterruptedException, IOException, AWTException
{
	  OPD_Registration_Encounter enc=new OPD_Registration_Encounter(driver);
	  enc.Encounter(EncounterRemarksPar,AddNotesPar,NamePar,IdentificationNOPar,PhoneNoPar,AddressPar,PostcodeParAdetailsPar);
} 
@BeforeTest
public void startBrowser() 
{
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://medcare-productqa.hatiintl.com/");
    //driver.close();
    //driver.quit();
}
}
