package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaysPageObject {
	@FindBy(xpath="//input[@id='location-field-destination-input']")
	private  WebElement goTo;
	@FindBy(xpath="//input[@id='d1']']")
	private WebElement checkIn;
	@FindBy(xpath="//input[@id='d2']']")
	private WebElement checkOut;
	@FindBy(xpath="//div[@id='adaptive-menu']")
	private WebElement travelers;
	@FindBy(xpath="//button[@data-testid='submit-button']")
	private WebElement srchBtn;
	@FindBy(xpath="//div[@id='location-field-destination-input-error']")
	private WebElement destinationError;
	
	public String getDestination() {
		return goTo.getText();
	}
	
	public void setDestination(String destination) {
		this.goTo.sendKeys(destination);
	}
	
	public String getChkin() {
		return checkIn.getAttribute("value");
	}
	
	public void setChkin(String chkin ) {
		this.checkIn.sendKeys(chkin);
	}
	
	public String getChkOut() {
		return checkOut.getAttribute("value");
	}
	
	public void setChkOut(String chkout ) {
		this.checkOut.sendKeys(chkout);
	}
	
	public void selectTravelers(){
		travelers.click();
	}
	
	public void searchClick(){
		
		srchBtn.click();
	}
	
	public String destinationError() {
		return destinationError.getText();
	}
	
	
}
