package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class commonFunctions {

	public static Properties properties = null;
	public static WebDriver driver = null;
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

	public static void expediaVisibilityCheck(String expediaobject)
	{
		WebElement page = null;
		try {

			page = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expediaobject)));
			if(new WebDriverWait(driver, 30).until(ExpectedConditions.attributeContains(page, "visibility", "visible"))==true)
			{
				System.out.println("Expedia loaded");
				driver.findElement(By.xpath("//div[@class='uitk-card uitk-grid all-cell-1-1 elevation-4']")).click();
				
			}
		}
		catch(Exception e) {
			System.out.println(expediaobject);
			System.out.println(page.getAttribute("visibility"));
			e.printStackTrace();
		}


	}


	@AfterSuite
	public void teardown()
	{
		if(driver!=null)
			driver.quit();
	}



}
