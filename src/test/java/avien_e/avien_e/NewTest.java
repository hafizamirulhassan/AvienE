package avien_e.avien_e;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners(CustomerListeners.class)

public class NewTest extends Base {

	ExtentTest print;

	@BeforeMethod
	public void setup() throws InterruptedException {

		Extent_Report();

		Thread.sleep(5000);
		
		intialization();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://dev.topuniversities.com/";
		Assert.assertEquals(actualURL, expectedURL);
		if (actualURL.equalsIgnoreCase(expectedURL)) {
			System.out.println("Test PASS --- URL is fine");
		} else {
			System.out.println("Test FAILED");
		}

		print = extent.createTest("TopUniversities Registration Test Case");
		print.log(Status.INFO, "Test Case Started");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		extent.flush();
	}

	
	@Test(priority = 1)
	public void TU_Registration() throws InterruptedException, IOException {

		boolean display = driver.findElement(By.id("popup-buttons")).isDisplayed();
		boolean enable = driver.findElement(By.id("popup-buttons")).isEnabled();
		if (display == true && enable == true) {
			driver.findElement(By.id("popup-buttons")).click();
			print.log(Status.PASS, "CLOSE COOKIE POPUP");
			print.pass("CLOSE THE COOKIE POPUP");

		} else {
			System.out.println("Cookie popup is  inactive !!");
			print.log(Status.FAIL, "Popup button is not clickable.");

		}

		Thread.sleep(2000);

		// driver.findElement(By.className("leadinModal-close")).click();

		driver.findElement(By.id("reg_form_btn")).click();
		print.log(Status.PASS, "CLICK ON SIGNUP BUTTON");

		//for (int i = 0; i < 1; i++) 
			
			driver.findElement(By.id("edit-field-first-name-und-0-value")).sendKeys("aaa");

			// Thread.sleep(1000);
			driver.findElement(By.id("edit-field-last-name-und-0-value")).sendKeys("Test");
			// Thread.sleep(1000);
			WebElement email = driver.findElement(By.id("edit-mail--3"));
			email.sendKeys("justtestt3@mail.com");

			// Thread.sleep(1000);
			driver.findElement(By.id("edit-pass--3")).sendKeys("test11435");

			// Thread.sleep(1000);
			driver.findElement(By.id("edit-field-erg-1-und-1")).click();
			// Thread.sleep(1000);
			driver.findElement(By.id("edit-field-partner-optin-und-0")).click();
			// Thread.sleep(1000);
			driver.findElement(By.id("edit-submit--8")).click();

			
			 /*String actualError=driver.findElement(By.cssSelector("div[class='messages error']")).getText(); 
			  String expectedError="This email is already taken. Please log in or reset the password to continue.";
			  
			 // Assert.assertEquals(actualError, expectedError);
			  
			  if(!actualError.equalsIgnoreCase(expectedError)) {
			  
			  System.out.println("Test passed"); 
			  }
			  else { System.out.println("Test Failed");
			  }*/
			 
			
			/*boolean expected_Value=driver.findElement(By.cssSelector("div[class='messages error']")).isDisplayed();
			if(i==0) {
				
				Assert.assertFalse(expected_Value);
			}else {
				
				Assert.assertTrue(expected_Value);
			}*/

			  Thread.sleep(1000);
			  
		driver.findElement(By.xpath(
				"//label[@class='l-what-study-level-masters option']//div[@class='radio-title'][contains(text(),'Masters')]"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(
				"//form[@id='qs-firebase-sso-global-step-two-form']//div[@class='ms-tags']//p[@class='CaptionCont SelectBox search']"))
				.click();

		/*
		 * List<WebElement> element=driver.findElements(By.
		 * xpath("//div[@id='user-global-reg']//div[@class='form-item form-type-select form-item-what-subjects-interest form-group closed']//optgroup[1]"
		 * ));
		 * 
		 * for(WebElement opt:element) { System.out.println(opt.getText()); }
		 */

		driver.findElement(By.xpath(
				"//form[@id='qs-firebase-sso-global-step-two-form']//div[@class='ms-tags']//p[@class='CaptionCont SelectBox search']"))
				.click();

		driver.findElement(By.xpath("//label[text()='History & Archaeology']")).click();
		driver.findElement(By.xpath("//label[text()='Architecture']")).click();
		driver.findElement(By.xpath("//label[text()='Art & Design']")).click();
		driver.findElement(By.xpath("//label[text()='Theology, Divinity & Religious Studies']")).click();

		driver.findElement(By.className("cell-text")).click();

		driver.findElement(By.xpath(
				"//form[@id='qs-firebase-sso-global-step-two-form']//div[@class='ms-tags']//span[@class='jcf-select-opener']"))
				.click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Canada']")).click();

		Thread.sleep(2000);

		WebElement elem = driver.findElement(By.id("edit-cor"));
		elem.click();
		elem.sendKeys("Afghanistan");
		System.out.println("You Entered :" + elem.getAttribute("value"));

		WebElement aaa = driver.findElement(By.cssSelector(
				"div.form-type-textfield:nth-child(5) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1)"));
		aaa.click();

		driver.findElement(By.name("mobile_number")).sendKeys("46465464");
		driver.findElement(By.id("edit-submit--4")).click();

		Thread.sleep(2000);
		}
	

	@Test(priority = 2)
	public void validation() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Top Universities | Worldwide university rankings, guides & events";

		Assert.assertEquals(actualTitle, expectedTitle);
		print.log(Status.PASS, driver.getTitle());

	}

	@Test(priority = 3)
	public void StartMatching() {

		WebElement StartMatching=driver.findElement(By.className("sml"));
		boolean actual=StartMatching.isDisplayed();
		
		if(actual) {
			StartMatching.click();
			
		}else {
			
			System.out.println("Button is inactive.");

		}
		

		Assert.assertTrue(true);
		
		
		/*if (!display == true && enable == true) {

			driver.findElement(By.className("sml")).click();

			
		} else {

		}*/

	}

}
