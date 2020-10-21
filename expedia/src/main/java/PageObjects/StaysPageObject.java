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
	private WebElement checkInInput;
	@FindBy(xpath="//button[@id='d2-btn']")
	private WebElement checkOutInputBtn;
	@FindBy(xpath="//button[@class='uitk-flex-item uitk-new-date-picker-top-bar-selection selection-filled uitk-new-date-picker-input']")
	private WebElement checkOutInput;
	@FindBy(xpath="//div[@id='adaptive-menu']")
	private WebElement travelers;
	@FindBy(xpath="//button[@data-testid='submit-button']")
	private WebElement srchBtn;
	@FindBy(xpath="//div[@id='location-field-destination-input-error']")
	private WebElement destinationError;
	@FindBy(xpath="//button[@class='uitk-button uitk-button-small uitk-button-has-text uitk-button-primary uitk-flex-item uitk-flex-shrink-0 dialog-done']/span")
	private WebElement calendarCloseBtn;
	@FindBy(xpath="//div[@id='d2-error']")
	private WebElement error28days;
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

	public WebElement getChkinInput() {
		return checkInInput;
	}

	public WebElement getChkOutInputBtn() {
		return checkOutInputBtn;
	}

	public WebElement getChkOutInput() {
		return checkOutInput;
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

	public WebElement GetcalendarCloseBtn()
	{
		return calendarCloseBtn;
	}

	public WebElement Geterror28days() {
		return error28days;
	}
}
