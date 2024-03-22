package testCases;

import org.testng.annotations.Test;

import pageObjects.InterestAmountForCurrentYearPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_1_02_DisplayingTheEMIPaymentTable extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void displayResult() {
		
		logger.info("**** TC_1_02_DisplayingTheEMIPaymentTable Started ****");
		try {
			InterestAmountForCurrentYearPage obj1 = new InterestAmountForCurrentYearPage(driver);
			
			//Scroll to Table
			obj1.scrollToTable();

			//Click on the Years
			obj1.clickOnYears();
			
			//Displaying the datas
			obj1.printTheEMIPaymentTable();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_1_02 got failed, displaying the datas wasn't successful");
			
			logger.error("TC_1_02 got failed, displaying the datas wasn't successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_1_02_DisplayingTheEMIPaymentTable Ended ****");
	}
}
