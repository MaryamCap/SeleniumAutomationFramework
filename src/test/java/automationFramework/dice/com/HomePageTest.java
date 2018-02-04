package automationFramework.dice.com;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationFramework.dice.base.BaseTest;
import automationFramework.dice.base.CsvDataProvider;
import automationFramework.dice.pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test(dataProvider = "CsvDataProvider" , dataProviderClass = CsvDataProvider.class)
	public void contactUsTest(Map<String, String> testData){
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String email = testData.get("email");
		String companyName = testData.get("companyName");
		String stateName = testData.get("stateName");
		String postalCode = testData.get("postalCode");
		
		log.info("firstName " + firstName  + "lastName "  + lastName + 
				"email"+  email + "companyName" + companyName +"stateName" + stateName + "postalCode" + postalCode);
		
		HomePage homePage = new HomePage(driver, log);
		String expectedPageTitle = "Homepage | Merieux Nutrisciences US";
		
        homePage.openHomePage();
		
		//fill up login and password
		homePage.fillUpContactForm(firstName,lastName,email,companyName, stateName,postalCode);
		//click on submit button
	    homePage.pushSubmitButton();
		
		//verify title of profile page
		log.info("Verification");
		String actualTitle = "Homepage | Merieux Nutrisciences US";
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is not expected.\n Expected: " +
		expectedPageTitle + "\nActual: " + actualTitle);
	}
	
	@Test
	public void searchHomePageTest(){
		log.info("search your keyword");
		HomePage homePage = new HomePage(driver, log);
		homePage.openHomePage();
		WebElement element = driver.findElement(By.xpath("//*[@id='edit-keys-27']"));
		element.sendKeys("food");
		homePage.pushSearchButton();
	}
	
	
}
