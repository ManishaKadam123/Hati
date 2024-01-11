package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Encounter_List_Screen_Advanced_Search_BY_MRN;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Encounter_List_Advanced_Search_By_MRN 
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
	public void TC_02_Verify_That_User_Is_Able_TO_Seacrh_Record_Through_Advanced_Search_By_MRN() throws InterruptedException
	{
		Encounter_List_Screen_Advanced_Search_BY_MRN advanced=new Encounter_List_Screen_Advanced_Search_BY_MRN(driver);
		advanced.Advanced_Search_For_Encounter_List_BY_MRN();
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
