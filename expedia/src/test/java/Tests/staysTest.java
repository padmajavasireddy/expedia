package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.StaysPageObject;



public class staysTest extends commonFunctions{
	StaysPageObject staysObject = new StaysPageObject();
	
	@BeforeTest
	public void NavigateToStays()
	{
		//WebElement expediapage = staysObject.getExpediaPageObject();
		
		expediaVisibilityCheck(properties.getProperty("expediapage"));
		staysObject.SelectStays();
	}
	
	@Test
	public void emptydestinationTest() throws InterruptedException {
		
		staysObject.searchClick();
		Assert.assertEquals(staysObject.destinationError(), "Please select a destination","Destination is mandatory");
		
	}
	

}
