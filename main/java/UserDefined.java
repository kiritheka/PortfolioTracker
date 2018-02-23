package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Filereader {
	public int value;
	public String stockname;

	public Filereader(int value, String stockname) {
		this.value = value;
		this.stockname = stockname;
	}

	public String toString() {
		return "value = " + this.value + ", name = " + this.stockname;
	}
}

public class UserDefined {
	public static void main(String[] args) {
		
		/*// List<String[]> list = new ArrayList<String[]>();
		String strLine;
		int count = 0;
		ArrayList<Filereader> list = new ArrayList<>();

		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				list.add(new Filereader(count, strLine));
				count++;
			}
				for (Filereader p : list) {
					System.out.println(p);
				}
			fstream.close();
			}
		}catch(

	Exception e)
	{
		System.err.println("Error: " + e.getMessage());
	}*/

		
		String strLine;
		int count = 0;
		ArrayList<Filereader> list = new ArrayList<>();

		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				
				list.add(new Filereader(count, strLine));
				
				count++;
			}
			
		//	String[] value = list.get(0)
			for (Filereader p : list) {
				System.out.println(p);
			}
			
			
			
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}	
		
		
		
		
		
		
		
		
		
		
}
}
