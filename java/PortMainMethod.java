package main.test;

import java.util.Scanner;

public class PortMainMethod {

	public static void main(String args[]) {
		
		 //String[][] symbol = {{"GOOG","INFY","MS"},{"GOOG","MS"},{"AMZN","MS","INFY"}};
		 //int[][] stocksPerSymbol ={{80,90,50},{9999,90,89},{60,40,20}};
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Number of StockHolder");
		int noOfHolder = scan.nextInt();

		int[] stock = new int[noOfHolder];
		for (int i = 0; i < noOfHolder; i++) {
			System.out.println("Enter the no of stocks by holder " + (i + 1));
			stock[i] = scan.nextInt();
		}

		String[][] symbol = new String[noOfHolder][noOfHolder];
		for (int i = 0; i < noOfHolder; i++) {
			  System.out.println("Enter the Names of symbol by holder" + (i + 1));
		    for (int j = 0; j < stock[i]; j++) {
				symbol[i][j] = scan.next();
			}
		}

		int[][] stocksPerSymbol = new int[noOfHolder][noOfHolder];
		for (int i = 0; i < noOfHolder; i++) {
			  System.out.println("Enter the STOCK VALUE of symbol by holder" + (i + 1));
			for (int j = 0; j < stock[i]; j++) {
				stocksPerSymbol[i][j] = scan.nextInt();
			}
		}

		PortCalculation portCalculation = new PortCalculation();
		double[] TotalPortfolio = portCalculation.PortfolioTotal(symbol, stocksPerSymbol, stock);
	}

}
