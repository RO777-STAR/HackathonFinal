package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_32_LoanTenureCalculator_ValidatingInterestRateSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingInterestRateSlider() {
		
		logger.info("**** TC_3_32_LoanTenureCalculator_ValidatingInterestRateSlider Started ****");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Interest Rate Slider is visible
			if(obj1.getIntRateSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_32 got failed, Interest Rate Slider is not visible.");
				System.out.println("TC_3_32 got failed, Interest Rate Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if Interest Rate Slider is enabled
			if(obj1.getIntRateSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_32 got failed, Interest Rate Slider is not enabled.");
				System.out.println("TC_3_32 got failed, Interest Rate Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_32 got failed, validation of Interest Rate Slider was "
							   + "unsuccessful");
			
			logger.error("TC_3_32 got failed, validation of Interest Rate Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_32_LoanTenureCalculator_ValidatingInterestRateSlider Ended ****");
	}
}