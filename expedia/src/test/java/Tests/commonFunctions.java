package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonFunctions {

	public Properties properties;
	public WebDriver driver;
	
	public Properties loadpropertiesfile() throws IOException
	{
		FileInputStream fileinputstream = new FileInputStream("config.Properties");
		Properties properties = new Properties();
		properties.load(fileinputstream);
		System.out.println(properties);
		return properties;
	}


	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		properties = loadpropertiesfile();
		String browser = properties.getProperty("browser");
		String driverlocation = properties.getProperty("chromedriverpath");
		String url = properties.getProperty("url");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver =  new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[@class='uitk-card uitk-grid all-cell-1-1 elevation-4']")).click();
	}

	public  void expediaVisibilityCheck(String expediaobject)
	{
		WebElement page = null;
		try {

			page = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expediaobject)));
			if(new WebDriverWait(driver, 30).until(ExpectedConditions.attributeContains(page, "visibility", "visible"))==true)
			{
				
				System.out.println("Expedia loaded");
				//driver.findElement(By.xpath("(//div[@id='gc-custom-header-nav-bar-acct-menu']//button)[1]")).click();
				//driver.findElement(By.xpath("//a[@aria-controls='wizard-hotel-pwa-v2']")).click();	
				
			}
		}
		catch(Exception e) {
			System.out.println(expediaobject);
			System.out.println(page.getAttribute("visibility"));
			e.printStackTrace();
		}

	}
	
	public void waitForPageLoad() {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	        	System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	           return String
		                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
		                .equals("complete");
	        }
	    });
	}
	
	public Date getDate() throws ParseException {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateWithoutTime = cal.getTime();
		return dateWithoutTime;
	}


	@AfterSuite
	public void teardown()
	{
		//if(driver!=null)
		//	driver.quit();
	}



}
