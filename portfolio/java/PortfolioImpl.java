package portfolio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONException;

public class PortfolioImpl implements Portfolio {

	@Override
	public HashMap<String, Double> getStocksAndSymbol(String singleUser) {
		HashMap<String, Double> symbolAndStocks = new HashMap<String, Double>();
		try {
			System.out.println("Portfolio passed is " + singleUser);
			int i = 0;

			String string = singleUser.replaceAll("[^0-9]+", " ");
			String noOfStocksArray[] = (string.trim().split(" "));
			String symbolArray[] = singleUser.split("[^a-zA-Z]+");

			for (String noOfStocks : noOfStocksArray) {
				double stockCount = Double.parseDouble(noOfStocks);

				if (symbolAndStocks.containsKey(symbolArray[i]))
					symbolAndStocks.put(symbolArray[i], symbolAndStocks.get(symbolArray[i]) + stockCount);
				else
					symbolAndStocks.put(symbolArray[i], stockCount);
				System.out.println("symbol & Stock " + symbolArray[i] + " = " + stockCount);
				i++;
			}
			System.out.println("checking for add  " + symbolAndStocks);

		} catch (NumberFormatException e) {
		}
		return symbolAndStocks;
	}

	@Override
	public HashMap<Double, Double> getStockPrice(HashMap<String, Double> symbolAndStocks) {

		HashMap<Double, Double> stockPriceAndCount = new HashMap<Double, Double>();
		for (String keySymbol : symbolAndStocks.keySet()) {

			double stockPrice = FetchStockPrice.sendRequest(keySymbol);
		    System.out.println("%%% IN GET STOCK PRICE METHOD.... WAITING FOR FETCH %%%");
			stockPriceAndCount.put(stockPrice, symbolAndStocks.get(keySymbol));
			System.out.println("after fetching : " + keySymbol + " price is " + stockPrice);
		}
		return stockPriceAndCount;
	}

	@Override
	public double portfolioCalculation(HashMap<Double, Double> stockPriceAndCount) {

		double userTotal = 0;
		for (double key : stockPriceAndCount.keySet()) {
			userTotal += stockPriceAndCount.get(key) * key;
		}
		System.out.println("userTotal is  " + userTotal);
		System.out.println();
		return userTotal;

	}

	@Override

	public String[] sortingPortfolio(LinkedHashMap<String, Double> userTotal, LinkedHashMap<String, String> userList) {

		List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(userTotal.entrySet());
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		String[] sortedUserList = new String[userList.size()];
		int i = 0;

		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		Collections.reverse(list);

		for (Map.Entry<String, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("After sorting " + sortedMap);

		for (String key : sortedMap.keySet()) {
			sortedUserList[i] = userList.get(key);
			i++;
		}
		return sortedUserList;

	}

	@Override
	public void writingInFile(String[] sortedUserList, String locationToWrite) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(locationToWrite));
		for (int h = 0; h < (sortedUserList.length); h++) {
			bw.write(sortedUserList[h]);
			System.out.println(sortedUserList[h]);
			bw.newLine();
		}
		bw.close();
	}
}
