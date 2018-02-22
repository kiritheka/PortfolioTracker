package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Finl {

	private static final Object[] string = null;

	public static void main(String args[]) {

		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			List<String> list = new ArrayList<String>();
			int count = 0;

			while ((strLine = br.readLine()) != null) {
				list.add(count, strLine);
				System.out.println(list.get(count));
				count++;
			}

			System.out.println(list);
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
	

	}
}
