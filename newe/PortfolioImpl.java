package newe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortfolioImpl implements Portfolio {

	@Override
	public void stockValue(int GOOG,int INFY,int MS,int AMZN) {

		GOOG = 500;
		 INFY = 1000;
		 MS = 900;
		 AMZN = 2000;
		
		
	}

	public int fileFetching() {
		List<String[]> list = new ArrayList<String[]>();
		String strLine;
		int count = 0;
		System.out.println(goog); 

		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				String[] splitted = strLine.split("[-,]");
				list.add(count, splitted);
				System.out.println(Arrays.toString(list.get(count)));
				count++;	
			}
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return count;
	}
	 


		
		
		
	
	public static void main(String args[]) {
		
	}

}
