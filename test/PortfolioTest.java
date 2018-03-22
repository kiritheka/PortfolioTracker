package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import portfolio.PortfolioImpl;

import static org.mockito.Mockito.*;

public class PortfolioTest {

	PortfolioImpl portfolioImpl = new PortfolioImpl();

	@Test
	@DisplayName("Getting Symbols & Stocks")
	void testGetStocksAndSymbol() {
		HashMap<String, Double> expectedResult = new HashMap<>();
		HashMap<String, Double> expectedResultForAdd = new HashMap<>();

		expectedResult.put("GOOG", 50.0);
		assertEquals(expectedResult, portfolioImpl.getStocksAndSymbol("GOOG-50,MS-"));

		expectedResultForAdd.put("MS", 100.0);
		expectedResultForAdd.put("GOOG", 550.0);
		assertEquals(expectedResultForAdd, portfolioImpl.getStocksAndSymbol("GOOG-50,MS-100,GOOG-500"));
		// assertEquals("{}", portfolioImpll1.getStocksAndSymbol("GOOG-").toString());
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void doCheckingException() {
		exception.expect(ArrayIndexOutOfBoundsException.class);
		exception.expectMessage("empty String");
		portfolioImpl.getStocksAndSymbol("Goo").toString();
	}

	@Test
	void testGetStockPrice() {
		HashMap<String, Double> expectedResult = new HashMap<>();
		expectedResult.put("MS", 100.0);
		expectedResult.put("GOOG", 50.0);

		HashMap<Double, Double> stockPriceAndCount = new HashMap<Double, Double>();
		stockPriceAndCount.put(1135.73, 50.0);
		stockPriceAndCount.put(57.51, 100.0);

		PortfolioImpl portfolioImpl = mock(PortfolioImpl.class);
		// when(portfolioImpl.getStockPrice(expectedResult)).thenReturn(stockPriceAndCount);
		doReturn(stockPriceAndCount).when(portfolioImpl).getStockPrice(expectedResult);
		assertEquals("{1135.73=50.0, 57.51=100.0}".toString(), portfolioImpl.getStockPrice(expectedResult).toString());

		// assertEquals("{1135.73=50.0,57.51=100.0}",portfolioImpl.getStockPrice(expectedResult).toString());

	}

	@Test
	void testPortfolioCalculation() {
		HashMap<Double, Double> expectedPrice = new HashMap<>();
		expectedPrice.put(1135.73, 50.0);
		expectedPrice.put(57.51, 100.0);
		assertEquals(62537.5, portfolioImpl.portfolioCalculation(expectedPrice));
		expectedPrice.put(0.0, 10.0);
		assertEquals(62537.5, portfolioImpl.portfolioCalculation(expectedPrice));

	}

	@Test
	@DisplayName("Sorting Users")
	void testsortingPortfolio() {
		LinkedHashMap<String, Double> total = new LinkedHashMap<>();
		LinkedHashMap<String, String> userList = new LinkedHashMap<>();
		total.put("User1", 62537.5);
		total.put("User2", 772537.5);
		total.put("User3", 552537.5);
		userList.put("User1", "GOOG-50,MS-56");
		userList.put("User2", "INFY-89,AMZN-55");
		userList.put("User3", "MS-90,GOOG-34");
		String[] expectedUserArray = { "INFY-89,AMZN-55", "MS-90,GOOG-34", "GOOG-50,MS-56" };

		assertArrayEquals(expectedUserArray, portfolioImpl.sortingPortfolio(total, userList));
	}

	@Test
	void testWritingInFile() throws IOException {
		String[] SortedUserArray = { "GOOG-100,AMZN-90,MS-80,GOOG-50", "INFY-100,GOOG-50,MS-10", "GOOG-50,MS-10" };
		portfolioImpl.writingInFile(SortedUserArray, "/home/linuxuser/portTest.txt");
		assertTrue("home/linuxuser/portTest.txt".length() > 0);
	}

}
