package functional;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileOperation {

	public void FileOperatorMethod(String readLocation,String writeLocation) throws IOException {
		
		List<Double> testList = new ArrayList<Double>();
		List<String> stringList = new ArrayList<String>();
		PortfolioImpll portfolioImpll = new PortfolioImpll();
		String strLine;
		double value;

		try {
			FileInputStream fstream = new FileInputStream(readLocation);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				
                
				HashMap<Integer, Double> noOfStocks = portfolioImpll.getNoOfStocks(strLine);
				HashMap<Integer, Double> stockPrice = portfolioImpll.getStockPrice(strLine);
				value = portfolioImpll.portfolioCalculation(noOfStocks, stockPrice);
				stringList.add(strLine);
				testList.add(value);
			}
            List<String> sortedList=portfolioImpll.portfolioSort(testList, stringList);
			System.out.println(sortedList);
			portfolioImpll.fileWriting(sortedList, writeLocation);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
