package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Quick_Registration_Advanced_Search_By_Name;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Advanced_Search_Quick_Registration_By_Name 
{
	public WebDriver driver;	
	@Test(priority=1)	
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		Login Loginapp=new Login(driver);
		Loginapp.login_Medcare(Uesrid);
	} 
	
	@Test(priority=2)
	@Parameters({"NamePAr"})
	public void TC_02_Verify_That_User_Is_Able_To_Add_New_Encounter_For_Already_Registred_Patient_By_Advanced_Searh_By_Name(String NamePAr) throws InterruptedException, IOException
	{
		Quick_Registration_Advanced_Search_By_Name   QuickReg=new Quick_Registration_Advanced_Search_By_Name (driver);
		QuickReg.Quick_Registration_Advanced_Search_Name(NamePAr);	
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
