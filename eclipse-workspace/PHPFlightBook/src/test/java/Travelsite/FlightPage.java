package Travelsite;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.HomePage;
import resources.BaseFile;

public class FlightPage extends BaseFile {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void searchFlightFunctionalityTest() throws InterruptedException {

		// go to Flight Tab
		HomePage flight = new HomePage();
		flight.getFlightTab().click();

		// select RoundTrip button
		if (!flight.getReturnTrip().isSelected()) {
			flight.getReturnTrip().click();
		}

		// Select business class from dropdown
		flight.getTravelClass(prop.getProperty("travelClass"));
		// Select source city
		flight.getSourceCity(prop.getProperty("sourceCity"));
		// Select destination city
		flight.getDestinationCity(prop.getProperty("destinationCity"));
		// Select travel dates
		flight.getTravelDates();
		// Select passenger details
		flight.getPersonDetails();
		// Click on search button
		flight.getSearch();/*
		// Check the count of flights available in list
		flight.getSearchList();
	}

	@AfterTest
	public void teardown() throws IOException {
		driver.quit();*/
	}
}