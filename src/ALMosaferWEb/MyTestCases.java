package ALMosaferWEb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void setUp() {
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popup = driver.findElement(By.className("sc-iBmynh"));

		if (popup.isDisplayed()) {
			WebElement SARButton = driver.findElement(By.className("cta__saudi"));
			SARButton.click();

		}
	}

	@Test(priority = 1, enabled = false)
	public void CheckLanguage() {
		String ExpectedLanguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();

		assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {
		String ExpectedCurrancy = "SAR";
		String ActualCurrancy = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();

		assertEquals(ActualCurrancy,ExpectedCurrancy);
	}

	@Test(priority = 3, enabled = false)
	public void CheckNumber() {
		String ExpectedNumber = "+966554400000";
	    String ActualNumber = driver.findElement(By.tagName("strong")).getText();

		assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4, enabled = false)
	public void CheckLogo() {
		WebElement Footer = driver.findElement(By.tagName("footer"));
		
		System.out.println();
		assertEquals(driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(),true);

	}
	
	@Test(priority = 5, enabled = false)
	public void CheckHotel() {
		
		
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-chalets")).getAttribute("aria-selected"), "false");

	}
	
	@Test(priority = 7)
	public void Changelanguage() {
		 Random rand = new Random();
		 int randomIndexForTheWebsite= rand.nextInt(Websites.length);
		driver.get(Websites[randomIndexForTheWebsite]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			String EXLanguage= "ar";
			String ACLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			assertEquals(ACLanguage, EXLanguage);
		}
		else {
			String EXLanguage= "en";
			String ACLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			assertEquals(ACLanguage, EXLanguage);
			
		}
	}
	
	
	
	@AfterTest
	public void postTest() {

	}
}