package automationFramework.dice.com;

import org.testng.annotations.Test;

import automationFramework.dice.base.BaseTest;

public class SecondTest extends BaseTest {
	
	@Test
	public void secondTestMethod(){
		
		
		driver.get("https://www.linkedin.com/");
		System.out.println("linkedin opened");
		
	}
}
