package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import pageObjects.HomeLoanEMICalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;
import utilities.ExcelUtils;


public class TC_2_01_StoringTheYearTableInTheExcel extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	ExcelUtils write = new ExcelUtils();
	Assertions myAssert = new Assertions();
	
	@Test
	public void storeTable() {
		logger.info("**** TC_2_01_StoringTheYearTableInTheExcel Started ****");
		try {
			HomeLoanEMICalculatorPage obj1 = new HomeLoanEMICalculatorPage(driver);
			
			//Waiting for the main menu button
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigator();
			
			//Scrolling to the table
			obj1.scrollToTable();
			
			//Getting the year table in a 2D Array- 
			String[][] datas = obj1.getDatas();
			
			//Writing the datas into the excel sheet
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 	// Timestamp for the excel file
			String fileName = "YearTable" + timeStamp + ".xlsx";
			String path = ".//TestData/" + fileName;
			write.writeExcel(datas, path);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_2_01 got failed, storing the data was unsuccessful");
			logger.error("TC_2_01 got failed, storing the data was unsuccessful");
			myAssert.fail();
		}
		logger.info("**** TC_2_01_StoringTheYearTableInTheExcel Ended ****");
	}
}
