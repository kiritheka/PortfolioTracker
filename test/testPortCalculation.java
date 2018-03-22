package main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class testPortCalculation {
	PortCalculation portCalculation = new PortCalculation();

	@Test
	public void testGetPrice() {
		assertEquals(800.00, portCalculation.getPrice("GOOG"));
		assertEquals(500.50, portCalculation.getPrice("MS"));
		assertNotEquals(100.00, portCalculation.getPrice("INFY"));
		assertNotNull(portCalculation.getPrice("AMZN"));
		assertEquals(0.0, portCalculation.getPrice("FLPKRT"));
		assertEquals(0.00, portCalculation.getPrice("-123"));
		assertNotSame(900.00, portCalculation.getPrice("INFY"));

	}

	@Test
	public void testPortfolioTotal() {
		String[][] symbols = { { "GOOG", "INFY", "MS" }, { "INFY", "AMZN" }, { "MS" } };
		int[][] noOfStocks = { { 90, 80, 70 }, { 800, 320 }, { 70 } };
		int[] stocksPerUser = { 3, 2, 1 };
		double[] actualValue = portCalculation.PortfolioTotal(symbols, noOfStocks, stocksPerUser);
		double[] expectedValue = { 179035.0, 912000.0, 35035.0 };
		double[] expctd = { 179035.008, 912000.0, 35035.0 };
		assertTrue(Arrays.equals(expectedValue, actualValue));
		assertArrayEquals(expectedValue, actualValue);
		assertNotNull(actualValue);
		assertArrayEquals(expctd, actualValue, 0.009);

	}

}
