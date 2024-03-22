package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_03_EMICalculator_IntegressionTestingForLoanAmountTextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenLoanAmountSliderAndTextBox() {
		logger.info("**** TC_3_03_EMICalculator_IntegressionTestingForLoanAmountTextBoxAndSlider Started ****");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForEMICalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			obj1.moveLoanAmtSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(obj1.getLoanAmtTextBoxValue(), "10,00,000", "The initial value of"
															+ " the loan amount textbox is not"
															+ " 10,00,000");
			
			//Moving the slider to Desired Position
			obj1.moveLoanAmtSlider(130);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(obj1.getLoanAmtTextBoxValue().equals("50,00,000")) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_03 got failed, Integration Testing for Loan Amount Text Box and "
						+ "slider was not successful.");
				System.out.println("TC_3_03 got failed, Integration Testing for Loan Amount Text "
						   + "Box and Slider was unsuccessful.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_03 got failed, Integration Testing for Loan Amount Text Box "
							   + "and Slider was unsuccessful");
			
			logger.error("TC_3_03 got failed, Integration Testing for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_03_EMICalculator_IntegressionTestingForLoanAmountTextBoxAndSlider Ended ****");
	}
}
