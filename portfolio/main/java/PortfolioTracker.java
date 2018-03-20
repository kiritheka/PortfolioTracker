package portfolio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class PortfolioTracker {

	PortfolioImpl portfolioImpll1 = new PortfolioImpl();
	LinkedHashMap<String, Double> allUserTotal = new LinkedHashMap<String, Double>();
	LinkedHashMap<String, String> allUserPortfolio = new LinkedHashMap<String, String>();

	public String getLocationToRead() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location of file to be read");
		String locationToRead = scan.next();
		return locationToRead;
	}

	public String getLocationToWrite() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location of file to be written");
		String locationToWrite = scan.next();
		return locationToWrite;
	}

	public String[] PortfolioCalculation(String locationToRead) throws IOException {
		String singleUser;
		String[] sortedUserList;
		try {
			FileInputStream fstream = new FileInputStream(locationToRead);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			int i = 1;
			while ((singleUser = br.readLine()) != null) {

				HashMap<String, Double> symbolAndStocks = portfolioImpll1.getStocksAndSymbol(singleUser);
				HashMap<Double, Double> stockPriceAndCount = portfolioImpll1.getStockPrice(symbolAndStocks);
				double userTotal = portfolioImpll1.portfolioCalculation(stockPriceAndCount);
				allUserTotal.put("USER" + i, userTotal);
				allUserPortfolio.put("USER" + i, singleUser);
				i++;
			}
			System.out.println(allUserTotal);
			System.out.println(allUserPortfolio);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sortedUserList = portfolioImpll1.sortingPortfolio(allUserTotal, allUserPortfolio);
		return sortedUserList;
	}

	public void PortfolioExecution(String[] sortedUserList, String locationToWrite) throws IOException {
		portfolioImpll1.writingInFile(sortedUserList, locationToWrite);
	}

	public static void main(String[] args) throws Exception {
		PortfolioTracker portfolioTracker = new PortfolioTracker();

		String locationToRead = portfolioTracker.getLocationToRead();
		String locationToWrite = portfolioTracker.getLocationToWrite();
		String[] userArray = portfolioTracker.PortfolioCalculation(locationToRead);
		portfolioTracker.PortfolioExecution(userArray, locationToWrite);
	}
}
