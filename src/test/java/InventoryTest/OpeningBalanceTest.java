package InventoryTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InventoryPages.OpeningBalance;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpeningBalanceTest {
	public WebDriver driver;
	@BeforeTest
	public void startBrowser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
	}
	@Test
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_Medcare(String Uesrid) throws InterruptedException, IOException
	{
		Login Loginapp=new Login(driver);
		Loginapp.login_Medcare(Uesrid);
	}
	@Test
	@Parameters({"IteamGroupPar","IteamCategoryPar","IteamCodePar","IteamNamePar","BatchNoPar","ExpirayDatePar","QuantityPar"})
	public void TC_03_Verify_That_User_can_Create_Opening_Balance(String IteamGroupPar,String IteamCategoryPar,String IteamCodePar,String IteamNamePar,String BatchNoPar,String ExpirayDatePar,String QuantityPar) throws InterruptedException, IOException
	{
		OpeningBalance OPBalance=new OpeningBalance(driver);
		OPBalance.User_Can_Create_Opening_Balance(IteamGroupPar,IteamCategoryPar,IteamCodePar,IteamNamePar,BatchNoPar,ExpirayDatePar,QuantityPar);
	}
}
