package avien_e.avien_e;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Base {

	public static WebDriver driver;
	static String URL = "https://dev.topuniversities.com/";
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;	

	public static void intialization() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\avien_e\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(URL);
		

		driver.manage().window().maximize();

		/*
		 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * //String currentDir = System.getProperty(
		 * "C:\\Users\\Admin\\eclipse-workspace\\avien_e\\ScreenshotsAll");
		 * FileUtils.copyFile(scrFile, new File(
		 * "C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\avien_e\\\\ScreenshotsAll/homepage.png"
		 * ));
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void failed(String testMethodName) {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:/Users/Admin/eclipse-workspace/avien_e"
					+ "/ScreenshotsAll/"+testMethodName+
		"_"+".png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Extent_Report() {
		
		        // start reporters
				htmlReporter = new ExtentHtmlReporter("C://Users//Admin//eclipse-workspace//avien_e//Extent_Repots//extent.html");
				// create ExtentReports and attach reporter(s)
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
	}
	
	

}
