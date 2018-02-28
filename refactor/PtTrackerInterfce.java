package refactor;

import java.util.List;

public interface PtTrackerInterfce {
	int[][] getNoOfStocks();

	List<String[]> getStockSymbol();

	int[][] getStockPrice(List<String[]> symbol);

	int[] portfolioCalculation(int[][] stockPrice, int[][] noOfStocks);

	void portfolioSort(int[] totalValue);
}
