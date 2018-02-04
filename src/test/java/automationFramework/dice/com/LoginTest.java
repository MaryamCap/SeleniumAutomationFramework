package automationFramework.dice.com;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationFramework.dice.base.BaseTest;
import automationFramework.dice.base.CsvDataProvider;
import automationFramework.dice.pages.LoginPage;
import automationFramework.dice.pages.ProfilePage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "CsvDataProvider" , dataProviderClass = CsvDataProvider.class)
	public void positiveLoginTest(Map<String, String> testData){
//		String expectedErrorMessage = "Email and/or password incorrect.";
		String testNumber = testData.get("no");
		String email = testData.get("email");
		String password = testData.get("password");
		String description = testData.get("description");
		
		log.info("Test No #" + testNumber + "for " + description + "where\nEmail: " + email + "\nPassword: " + password);
		
		LoginPage loginPage = new LoginPage(driver, log);
		String expectedPageTitle = "Seeker Dashboard - Profile";
//		String correctProfileName = "Maryam Heidarimoheb";
		//open dice.com page
		loginPage.openLoginPage();
		
		//fill up login and password
		loginPage.fillUpEmailAndPassword(email, password);
		//click on submit button
		ProfilePage profilePage = loginPage.pushSignInButton();
		profilePage.waitForProfilePageToLoad();
		//verify title of profile page
		log.info("Verification");
		String actualTitle = profilePage.getTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is not expected.\n Expected: " +
		expectedPageTitle + "\nActual: " + actualTitle);
		
		//verify correct name on profile page
//		Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "profile name is not expected");
	}
}
