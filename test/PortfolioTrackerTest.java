package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import portfolio.PortfolioImpl;
import portfolio.PortfolioTracker;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PortfolioTrackerTest {

	PortfolioTracker portfolioTracker = new PortfolioTracker();
	String[] expectedUserArray = { "GOOG-100,AMZN-90,MS-80,GOOG-50", "INFY-100,GOOG-50,MS-10", "GOOG-50,MS-10" };

	@Test
	void testGetLocationToRead() throws IOException {
		assertEquals("home/linux", portfolioTracker.getLocationToRead());
	}

	@Test
	void testGetLocationToWrite() throws IOException {
		assertEquals("home/linuxwrite", portfolioTracker.getLocationToWrite());
	}

	@Test
	void testPortfolioCalculation() throws IOException {
		assertArrayEquals((expectedUserArray), portfolioTracker.PortfolioCalculation("/home/linuxuser/portfolio.txt"));
	}

	@Test
	void testPortfolioExecution() throws IOException {
		portfolioTracker.PortfolioExecution(expectedUserArray, "/home/linuxuser/new.txt");
		assertTrue("home/linuxuser/new.txt".length() > 0);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void doCheckingException() throws IOException {
		exception.expect(FileNotFoundException.class);
		exception.expectMessage("NO FILE");
		portfolioTracker.PortfolioCalculation("home/linuxuser/ys.txt");
	}

}
