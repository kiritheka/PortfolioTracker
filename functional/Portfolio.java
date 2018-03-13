package functional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Portfolio {

	HashMap<Integer, Double> getNoOfStocks(String stringLine);

	HashMap<Integer, Double> getStockPrice(String stringLine);

	double portfolioCalculation(HashMap<Integer, Double> noOfStocks, HashMap<Integer, Double> stockPrice);

	public List<String> portfolioSort(List<Double> testList, List<String> stringList);

	void fileWriting(List<String> sortedList, String fileWriteLocation) throws IOException;

}
