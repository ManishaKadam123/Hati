package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Quick_Registration_With_OLD_IC;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Quick_Reg_With_OLD_IC 
{
	public WebDriver driver;	
	@Test	
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		Login Loginapp=new Login(driver);
		Loginapp.login_Medcare(Uesrid);
	} 
	
	@Test
	@Parameters({"QuickPrimaryIdNumberPar","QuickFullNamePar","QuickDateOfBirthPar","QuickMobileNumberPar","QuickEncounterRemarksPar","QuickAddNotesPar","QuickEncounterNotesPar","QuickPatientNotesPar","QuickReferralRemarksPar"})
	public void TC_02_Verify_That_User_Is_Able_To_Do_Quick_Registration_With_Primary_ID_OLD_IC(String QuickPrimaryIdNumberPar,String QuickFullNamePar,String QuickDateOfBirthPar,String QuickMobileNumberPar,String QuickEncounterRemarksPar,String QuickAddNotesPar,String QuickEncounterNotesPar,String QuickPatientNotesPar,String QuickReferralRemarksPar) throws InterruptedException, IOException
	{
		Quick_Registration_With_OLD_IC  QuickReg=new Quick_Registration_With_OLD_IC(driver);
		QuickReg.Quick_Registration_Verification_With_OLD_IC(QuickPrimaryIdNumberPar,QuickFullNamePar,QuickDateOfBirthPar,QuickMobileNumberPar,QuickEncounterRemarksPar,QuickAddNotesPar,QuickEncounterNotesPar,QuickPatientNotesPar,QuickReferralRemarksPar);	
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
