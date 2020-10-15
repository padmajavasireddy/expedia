package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.StaysPageObject;



public class staysTest extends commonFunctions{
	StaysPageObject staysObject = new StaysPageObject();
	
	@Test
	public void emptydestinationTest() throws InterruptedException {
		driver.wait(6000);
		staysObject.searchClick();
		Assert.assertEquals(staysObject.destinationError(), "Please select a destination","Destination is mandatory");
		
	}
	

}
