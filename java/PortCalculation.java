package main.test;

public class PortCalculation {

	double[] totalPrice = new double[3];

	public double getPrice(String symbol) {
		if (symbol.equals("GOOG")) {
			return 800.00;
		} else if (symbol.equals("INFY"))
			return 900.00;
		else if (symbol.equals("AMZN"))
			return 600.00;
		else if (symbol.equals("MS"))
			return 500.50;
		return 0.0;
	}

	public double[] PortfolioTotal(String[][] symbol, int[][] noOfStocks, int[] stocksPerUser) {

		for (int i = 0; i < symbol.length; i++) {
			for (int j = 0; j < stocksPerUser[i]; j++) {
				double stockValue = getPrice(symbol[i][j]);
				totalPrice[i] += noOfStocks[i][j] * stockValue;
			}
			System.out.println("Total price of " + (i + 1) + "st holder is " + totalPrice[i]);
		}
		return totalPrice;
	}

}
