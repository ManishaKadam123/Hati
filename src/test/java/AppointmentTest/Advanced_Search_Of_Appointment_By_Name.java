package AppointmentTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppointmentPages.Appointment_List_Advanced_Search_By_Name;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Advanced_Search_Of_Appointment_By_Name
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
	@Parameters({"NameSearch"})
	public void TC_02_Verify_That_User_Can_Search_Appoint_Using_Advanced_Search_By_Name(String NameSearch) throws InterruptedException, IOException
	{
		Appointment_List_Advanced_Search_By_Name search=new Appointment_List_Advanced_Search_By_Name(driver);
		search.Advanced_Search_For_Appointment_List_BY_Name(NameSearch);	
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
