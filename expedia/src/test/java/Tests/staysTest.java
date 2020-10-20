package Tests;

import java.text.ParseException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.StaysPageObject;

public class staysTest extends commonFunctions{
	StaysPageObject staysObject;
	@BeforeTest
	public void NavigateToStays()
	{
		waitForPageLoad();
		expediaVisibilityCheck(properties.getProperty("expediapage"));
		System.out.println(driver.getTitle());
		staysObject = new StaysPageObject(driver);
		staysObject.GetsignInBtn().click();
		staysObject.GetStays().click();
	}
	
	@Test(priority=1)
	public void emptydestinationTest() throws InterruptedException {
		
		staysObject.GetsearchBtn().click();
		Assert.assertEquals(staysObject.GetDestinationError().getText(),"Please select a destination","Destination is mandatory to search");
		
	}
	
	@Test(priority=2)
public void SearchWithdestinationTest() throws InterruptedException {
		String destination = "London";
		staysObject.setDestination(destination);
		staysObject.GetsearchBtn().click();
		String currenturl = driver.getCurrentUrl();
		if (currenturl.contains("Hotel-Search")&& currenturl.contains(destination))
		{
			Assert.assertTrue(true);
			System.out.println("Search for Hotel with destination " + destination + " is successful and navigated to the results of hotels for " +destination);
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Search for Hotel with destination " + destination + " is not successful and navigated to the results of hotels for " +destination);
		}
		   
	}
	
	@Test(priority=3)
	public void chkinChkout28daysTest() throws ParseException, InterruptedException
	{
		driver.get(properties.getProperty("url"));
		waitForPageLoad();
		staysObject.GetStays().click();
		String destination = "London";
		staysObject.setDestination(destination);
		getDate();
		staysObject.getChkInBtn().click();
		String day = getDay();
		driver.findElement(By.xpath("(//button[@class='uitk-new-date-picker-day'][@data-day='"+day+"'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='uitk-new-date-picker-day'][@data-day='22'])[2]")).click();
		staysObject.GetcalendarCloseBtn().click();
		staysObject.GetsearchBtn().click();
		String error = staysObject.Geterror28days().getText();
		Assert.assertEquals(error, "Dates must be no more than 28 days apart");
		}
	
	@Test(priority=4)
	
	public void selectChkInChkOutTest() {
		staysObject.getChkOutBtn().click();
		driver.findElement(By.xpath("//button[@class='uitk-new-date-picker-day selected'][@data-day='1']")).click();
		staysObject.GetcalendarCloseBtn().click();
		staysObject.GetsearchBtn().click();
		
	}

}
