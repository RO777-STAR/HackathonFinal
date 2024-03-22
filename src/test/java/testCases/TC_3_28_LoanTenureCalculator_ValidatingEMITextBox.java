package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_28_LoanTenureCalculator_ValidatingEMITextBox extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingValidatingEMITextBox() {
		
		logger.info("**** TC_3_28_LoanTenureCalculator_ValidatingEMITextBox Started ****");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if EMI Text Box is visible
			if(obj1.getEMITextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_28 got failed, EMI Text Box is not visible.");
				System.out.println("TC_3_28 got failed, EMI Text Box is not visible.");
				myAssert.fail();
			}
			
			//Validating if EMI Text Box is enabled
			if(obj1.getEMITextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_28 got failed, EMI Text Box is not enabled.");
				System.out.println("TC_3_28 got failed, EMI Text Box is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_28 got failed, validation of EMI Text Box was unsuccessful");
			
			logger.error("TC_3_28 got failed, validation of EMI Text Box was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_28_LoanTenureCalculator_ValidatingEMITextBox Ended ****");
	}
}
