package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.BaseFile;

public class HomePage extends BaseFile {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav row-reverse ']/li[2]")
	private WebElement flightTab;

	@FindBy(xpath = "//label[contains(text(),'Round Trip')]")
	private WebElement RTrip;

	@FindBy(xpath = "//span[contains(text(),'Economy')]")
	private WebElement TravelClass;

	@FindBy(xpath = "//div[contains(@id,'location_from')]")
	private WebElement sourceCity;

	@FindBy(xpath = "//div[contains(@id,'location_to')]")
	private WebElement destinationCity;

	@FindBy(xpath = "//input[@id='FlightsDateStart']")
	private WebElement departDate;

	@FindBy(xpath = "//div[8]/div/div/div[2]/div[contains(text(),'29')]")
	private WebElement currentDate;

	@FindBy(xpath = "//div[8]/div/div/div[2]/div[contains(text(),'30')]")
	private WebElement nextDate;

	@FindBy(xpath = "//div[contains(@class,'row no-gutters mb-15 row-reverse')]//div[contains(@class,'row no-gutters')]//div[1]//div[1]//div[2]//div[1]//span[1]//button[1]")
	private WebElement Adult;

	@FindBy(xpath = "//div[@id='flights']//div[2]//div[1]//div[2]//div[1]//span[1]//button[1]")
	private WebElement Child;

	@FindBy(xpath = "//div[contains(@class,'col-md-4 col-xs-12')]//div[3]//div[1]//div[2]//div[1]//span[1]//button[1]")
	private WebElement Infant;

	@FindBy(xpath = "//div[@class='col-xs-12 col-md-12']//button[contains(text(),'Search')]")
	private WebElement search;

	@FindBy(xpath = "//p[@class='text-muted post-heading']")
	private WebElement FlightList;

	// Select for travel class
	public void getTravelClass(String Travelclass) throws InterruptedException {
		TravelClass.click();
		Thread.sleep(2000);
		List<WebElement> DropdownList = driver.findElements(By.xpath("//ul[@class='chosen-results']//li"));
		for (int i = 0; i < DropdownList.size(); i++) {
			if (DropdownList.get(i).getText().equals(Travelclass)) {
				DropdownList.get(i).click();
				break;
			}
		}
	}

// Select Source City
	public void getSourceCity(String city) throws InterruptedException {
		sourceCity.click();
		Thread.sleep(2000);
		sourceCity.findElement(By.tagName("a")).sendKeys(city);
		Thread.sleep(2000);
		sourceCity.findElement(By.tagName("a")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

//Select Flight tab
	public WebElement getFlightTab() {
		return flightTab;
	}

	// Select Return radio button
	public WebElement getReturnTrip() {
		return RTrip;
	}

	// Select Destination City
	public void getDestinationCity(String city) throws InterruptedException {
		destinationCity.click();
		Thread.sleep(2000);
		destinationCity.findElement(By.tagName("a")).sendKeys(city);
		Thread.sleep(2000);
		destinationCity.findElement(By.tagName("a")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

//Select Travel Dates
	public void getTravelDates() {
		// Select Departure Date
		departDate.click();
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);", currentDate);
		currentDate.click();
		// Select Return Date
		int count = driver.findElements(By.xpath("//div[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div"))
				.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String text = driver
					.findElements(By.xpath("//div[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div")).get(i)
					.getText();
			if (text.equals("30")) {
				driver.findElements(By.xpath("//div[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div")).get(i)
						.click();
				break;
			}
		}
	}

	// Select Adult,Child,Infant
	public void getPersonDetails() {
		Adult.click();
		Child.click();
		Infant.click();
	}

//Click on Search button
	public void getSearch() {
		search.click();
	}

//Get the flights available
	public void getSearchList() {

		System.out.println(FlightList.getText());
	}
}