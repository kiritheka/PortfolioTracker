package refactor;

import java.util.List;

public interface PortfolioTracker {

	int[][] getNoOfStocks(String[] stringaarray);

	List<String[]> getStockSymbol(String[] stringaarray);

	int[][] getStockPrice(List<String[]> symbol);

	int[] portfolioCalculation(int[][] stockPrice, int[][] noOfStocks,String[] stringaarray);

	void portfolioSort(int[] totalValue);
}
