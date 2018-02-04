package automationFramework.dice.com;

import org.testng.annotations.Test;

import automationFramework.dice.base.BaseTest;

public class FirstTest extends BaseTest{
	
	@Test
	public void firstTestMethod(){
		
		
		driver.get("https://www.dice.com/");
		System.out.println("dice opened");
		
	}
	

}
