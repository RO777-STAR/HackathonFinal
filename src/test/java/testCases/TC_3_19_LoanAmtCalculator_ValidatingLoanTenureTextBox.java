package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_19_LoanAmtCalculator_ValidatingLoanTenureTextBox extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateLoanTenureTextBox() {
		
		logger.info("**** TC_3_19_LoanAmtCalculator_ValidatingLoanTenureTextBox Started ****");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForLoanAmountCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Loan Tenure Text Box is visible
			if(obj1.getLoanTenureTextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_19 got failed, Loan Tenure Text Box is not visible.");
				System.out.println("TC_3_19 got failed, Loan Tenure Text Box is not visible.");
				myAssert.fail();
			}
			
			//Validating if Loan Tenure Text Box is enabled
			if(obj1.getLoanTenureTextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_19 got failed, Loan Tenure Text Box is not enabled.");
				System.out.println("TC_3_19 got failed, Loan Tenure Text Box is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_19 got failed, validation of Loan Tenure Text Box was "
							   + "unsuccessful");
			
			logger.error("TC_3_19 got failed, validation of Loan Tenure Text Box was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_19_LoanAmtCalculator_ValidatingLoanTenureTextBox Ended ****");
	}	
}
