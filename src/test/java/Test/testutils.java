
package Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class testutils extends Quick_Registration_Test
{
	
	
	public void getscreenshots() throws IOException {
		Date currentdate = new Date();
		String ScreenShotsFilename = currentdate.toString().replace(" ", "_").replace(":", "_");
		File screenshotfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(".//ScreenShot//" + ScreenShotsFilename + ".png"));	
	}
	
}
