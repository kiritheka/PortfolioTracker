package portfolio;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;


public interface Portfolio {

	HashMap<String, Double> getStocksAndSymbol(String singleUser);

	HashMap<Double, Double> getStockPrice(HashMap<String, Double> symbolAndStocks);

	double portfolioCalculation(HashMap<Double, Double> stockPriceAndCount);

	public String[] sortingPortfolio(LinkedHashMap<String, Double> userTotal, LinkedHashMap<String, String> userList);

	void writingInFile(String[] sortedUserList, String fileWriteLocation) throws IOException;

}
