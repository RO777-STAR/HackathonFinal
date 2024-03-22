package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_14_LoanAmtCalculator_ValidatingEMISlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingEMISlider() {
		
		logger.info("**** TC_3_14_LoanAmtCalculator_ValidatingEMISlider Started ****");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForLoanAmountCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if EMI Slider is visible
			if(obj1.getEMISlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_14 got failed, EMI Slider is not visible.");
				System.out.println("TC_3_14 got failed, EMI Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if EMI Slider is enabled
			if(obj1.getEMISlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_14 got failed, EMI Slider is not enabled.");
				System.out.println("TC_3_14 got failed, EMI Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_14 got failed, validation of EMI Slider was unsuccessful");
			
			logger.error("TC_3_14 got failed, validation of EMI Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_14_LoanAmtCalculator_ValidatingEMISlider Ended ****");
	}
}
