package refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import newe.Port;

public class PortfolioTrackerImpl implements PortfolioTracker {

	@Override
	public int[][] getNoOfStocks(String[] stringaarray) {

		List<String[]> list = new ArrayList<String[]>();
		int[][] ArrayRest = new int[8][8];
		int count = 0;
		int j = 0;
		for (String string : stringaarray) {

			string = string.replaceAll("[^0-9]+", " ");
			String stockArray[] = (string.trim().split(" "));

			//System.out.println("after   " + count + Arrays.toString(stockArray));
			list.add(count, stockArray);

			// System.out.println("list" + Arrays.toString(list));
			count++;
		}

		for (String[] strings : list) {
			int i = 0;
			for (String string : strings) {

				ArrayRest[j][i] = Integer.parseInt(string);
				//System.out.println("Aray is " + j + " " + i + " " + ArrayRest[j][i]);
				i++;
			}
			j++;

		}

		return ArrayRest;
	}

	@Override
	public List<String[]> getStockSymbol(String[] stringaarray) {

		List<String[]> list = new ArrayList<String[]>();
		int count = 0;
		for (String string : stringaarray) {
			// System.out.println(string);
			String stockArray[] = string.split("[^a-zA-Z]+");
			//System.out.println(Arrays.toString(stockArray));
			list.add(count, stockArray);
			count++;
		}

		return list;
	}

	@Override
	public int[][] getStockPrice(List<String[]> symbol) {
		int[][] ArrayRes = new int[8][9];
		int i = 0;
		for (String[] string : symbol) {
			//System.out.println(string);
			int j = 0;
			for (String string2 : string) {
				String arrty = string2.replaceAll("GOOG", "500").replace("MS", "900").replace("INFY", "500")
						.replace("AMZN", "700");
				ArrayRes[i][j] = Integer.parseInt(arrty);
				//System.out.println("hello" + i + j + ArrayRes[i][j]);
				j++;
			}
			i++;
		}
		// System.out.println(Arrays.toString(ArrayRes));
		return ArrayRes;

	}

	@Override
	public int[] portfolioCalculation(int[][] stockPrice, int[][] noOfStocks, String[] stringaarray) {
		List<String[]> list = getStockSymbol(stringaarray);
		int[] Arraymulti = new int[3];
		for (int i = 0; i < 3; i++) {
			int value = 0;
			int lk = list.get(i).length;
			for (int j = 0; j < lk; j++) {
				value = value + stockPrice[i][j] * noOfStocks[i][j];
			}
			Arraymulti[i] = value;
			//System.out.println("kikiki  " + i + Arraymulti[i]);
		}
		return Arraymulti;
	}

	@Override
	public void portfolioSort(int[] Arraymulti) {
		for (int fir = 0; fir < Arraymulti.length; fir++) {
			for (int l = 3 - 1; l > fir; l--) {
				if (Arraymulti[fir] < Arraymulti[l]) {
					int temp = Arraymulti[l];
					Arraymulti[l] = Arraymulti[fir];
					Arraymulti[fir] = temp;			
				}

			}
		}
		
		for (int c = 0; c < Arraymulti.length; c++) {
			System.out.println( " Sorted value is " + Arraymulti[c]);
		}
	}

	public static void main(String[] args) throws Exception {

		FileOperationImpl fileOperationImpl = new FileOperationImpl();
		PortfolioTrackerImpl PortfolioTrackerImpl = new PortfolioTrackerImpl();

		String[] stringaarray = fileOperationImpl.FileReader();
		List<String[]> symbol = PortfolioTrackerImpl.getStockSymbol(stringaarray);
		int[][] stockPrice = PortfolioTrackerImpl.getStockPrice(symbol);
		int[][] noOfStocks = PortfolioTrackerImpl.getNoOfStocks(stringaarray);
		int[] totalValue = PortfolioTrackerImpl.portfolioCalculation(stockPrice, noOfStocks, stringaarray);
        PortfolioTrackerImpl.portfolioSort(totalValue);
	}

}
