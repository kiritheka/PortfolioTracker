package portfolio;

import static org.junit.jupiter.api.Assertions.*;
import org.easymock.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class PortfolioTest {

	PortfolioImpl portfolioImpl = new PortfolioImpl();

	@Test
	@DisplayName("Getting Symbols & Stocks")
	void testGetStocksAndSymbol() {
		HashMap<String, Double> expectedResult = new HashMap<>();
		expectedResult.put("GOOG", 50.0);
		assertEquals(expectedResult, portfolioImpl.getStocksAndSymbol("GOOG-50,MS-"));
		expectedResult.put("MS", 100.0);
		assertEquals(expectedResult, portfolioImpl.getStocksAndSymbol("GOOG-50,MS-100"));
		// assertEquals("{}", portfolioImpll1.getStocksAndSymbol("GOOG-").toString());
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void doCheckingException() {
		exception.expect(ArrayIndexOutOfBoundsException.class);
		exception.expectMessage("empty String");
		portfolioImpl.getStocksAndSymbol("Goo").toString();
	}

	@Test
	@Tag("API fetch")
	void testGetStockPrice() {
		HashMap<String, Double> expectedResult = new HashMap<>();
		expectedResult.put("MS", 100.0);
		expectedResult.put("GOOG", 50.0);
		
		
		FetchStockPrice fetchStockPrice = EasyMock.createMock(FetchStockPrice.class);
        Double price = 78.00;
		EasyMock.expect(fetchStockPrice.sendRequest(EasyMock.isA(String.class))).andReturn(price);
		
		assertEquals("{1135.73=50.0, 57.51=100.0}", portfolioImpl.getStockPrice(expectedResult).toString());

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

}
