package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaysPageObject{
	@FindBy(xpath = "//a[@aria-controls='wizard-hotel-pwa-v2']")
	private WebElement stays;
	@FindBy(xpath="(//div[@id='gc-custom-header-nav-bar-acct-menu']//button)[1]")
	private WebElement signInBtn;
	@FindBy(xpath="//button[@class='uitk-faux-input']")
	private WebElement goToBtn;
	@FindBy(xpath="//input[@id='location-field-destination']")
	private  WebElement destination;
	@FindBy(xpath="//button[@id='d1-btn']")
	private WebElement checkInBtn;
	@FindBy(xpath="//input[@id='d1']")
	private WebElement checkIn;
	@FindBy(xpath="//button[@id='d2-btn']")
	private WebElement checkOutBtn;
	@FindBy(xpath="//input[@id='d2']")
	private WebElement checkOut;
	@FindBy(xpath="//div[@id='adaptive-menu']")
	private WebElement travelers;
	@FindBy(xpath="//button[@data-testid='submit-button']")
	private WebElement srchBtn;
	@FindBy(xpath="//div[@id='location-field-destination-input-error']")
	private WebElement destinationError;
	private WebDriver driver ;
	public StaysPageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDestination() {
		return destination;
	}

	public void setDestination(String goTo) {
		goToBtn.click();
		destination.sendKeys(goTo);
		destination.sendKeys(Keys.ENTER);
	}
	public WebElement getChkInBtn() {
		return checkInBtn;
	}

	public WebElement getChkin() {
		return checkIn;
	}

	public void setChkin(String chkin ) {
		checkIn.sendKeys(chkin);
	}
	public WebElement getChkOutBtn() {
		return checkOutBtn;
	}

	public WebElement getChkOut() {
		return checkOut;
	}

	public void setChkOut(String chkout ) {
		checkOut.sendKeys(chkout);
	}

	public void selectTravelers(){
		travelers.click();
	}

	public WebElement GetsearchBtn(){

		return srchBtn;
	}

	public WebElement GetDestinationError() {
		return destinationError;
	}
	
	public WebElement GetsignInBtn()
	{
		return signInBtn;
	}

	public WebElement GetStays() {
		
		return stays;
		
		
	}


}
