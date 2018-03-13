package functional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;

public class PortfolioImpll implements Portfolio {

	@Override
	public HashMap<Integer, Double> getNoOfStocks(String stringLine) {

		HashMap<Integer, Double> noOfStocks = new HashMap<Integer, Double>();
		System.out.println("array value is " + stringLine);
		int i = 0;
		String string = stringLine.replaceAll("[^0-9]+", " ");
		String stockArray[] = (string.trim().split(" "));

		for (String string1 : stockArray) {
			double valuee = Double.parseDouble(string1);
			noOfStocks.put(i, valuee);
			i++;
		}

		return noOfStocks;
	}

	@Override
	public HashMap<Integer, Double> getStockPrice(String stringLine) {

		HashMap<Integer, Double> stockPrice = new HashMap<Integer, Double>();
		int i = 0;
		String stockArray[] = stringLine.split("[^a-zA-Z]+");

		for (String string1 : stockArray) {
			String price = FetchStockPrice
					.sendRequest("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + string1
							+ "&interval=1min&apikey=GQ7GFRH3XJS6L2Q5");
			double vlue = Double.parseDouble(price);
			stockPrice.put(i, vlue);
			i++;
		}
		return stockPrice;
	}

	@Override
	public double portfolioCalculation(HashMap<Integer, Double> noOfStocks, HashMap<Integer, Double> stockPrice) {

		double sum = 0;
		for (Integer key : noOfStocks.keySet()) {
			sum += noOfStocks.get(key) * stockPrice.get(key);
		}
		System.out.println("sum is  " + sum);
		return sum;

	}

	
	@Override
	
	public List<String> portfolioSort(List<Double> testList, List<String> stringList) {
		Collections.sort(testList);
		Collections.reverse(testList);
		Collections.indexOfSubList(testList, stringList);
		return stringList;
	}

	@Override
	public void fileWriting(List<String> sortedList, String fileWriteLocation) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriteLocation));
		String[] stringArray = sortedList.toArray(new String[0]);
		for (int h = 0; h < (stringArray.length); h++) {
		bw.write(stringArray[h]);
		System.out.println(stringArray[h]);
		bw.newLine();
		}
		bw.close();
	}
	
}
