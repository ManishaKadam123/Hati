package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListener extends testutils implements ITestListener {

	@Override
    public void onTestFailure(ITestResult result) {
		System.out.println("Test failed and details are - screenshot craptured");
		try {
			getscreenshots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
}