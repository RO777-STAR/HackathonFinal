package testCases;

import org.testng.annotations.Test;

import pageObjects.InterestAmountForCurrentYearPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_1_01_ParsingRequiredValuesToTheRespectiveFields extends BaseClass{
	
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	
	@Test
	public void parseDatas() {
		
		logger.info("**** TC_1_01_ParsingRequiredValuesToTheRespectiveFields Started ****");
		try {
			InterestAmountForCurrentYearPage obj1 = new InterestAmountForCurrentYearPage(driver);
			
			//Waiting for the main menu element
			wait.waitForMainMenu(driver);
			
			//Navigating to the page - 
			obj1.navigator();
			obj1.clickCarLoan();
			
			//Waiting for the car loan element to load
			wait.waitForTheCarLoan(driver);
			
			//Clicking on the car loan 
			obj1.clickCarLoan();
			
			//Parsing the required values - 
//			obj1.setLoanAmt(p.getProperty("loanAmount"));
//			obj1.setInterest(p.getProperty("interestRate"));
			obj1.setLoanAmt("1500000");
			obj1.setInterest("9.5");
			
			obj1.moveLoanTenureSlider(-375);
			obj1.clickOnYear();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_1_01 got failed, data parsing wasn't successful");
			logger.error("TC_1_01 got failed, data parsing wasn't successful");
			myAssert.fail();
		}
		logger.info("**** TC_1_01_ParsingRequiredValuesToTheRespectiveFields Ended ****");
	}
}
