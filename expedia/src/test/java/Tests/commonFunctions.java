package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

		}

		@AfterSuite
		public void teardown()
		{
			if(driver!=null)
				driver.quit();
		}
	


}
