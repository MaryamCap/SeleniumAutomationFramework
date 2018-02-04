package automationFramework.dice.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	public WebDriver driver;
	public WebDriverWait wait;
	public Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
		wait = new WebDriverWait(driver, 40);
	}

	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}

	protected void type(String text, By element) {
		findElement(element).sendKeys(text);
	}

	protected void click(By element) {
		findElement(element).click();
	}

	private WebElement findElement(By element) {
		return driver.findElement(element);
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
			} catch (StaleElementReferenceException e) {

			}
			attempts++;
		}
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		wait.until(condition);
	}
	public String getTitle(){
		return driver.getTitle();
	}
	
	protected String getText(By element){
		return findElement(element).getText();
	}

}
