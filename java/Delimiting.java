package main.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.JavaFileObject;

public class Delimiting {
	public static void main(String args[]) {

		try {

			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				String[] splitted = strLine.split("-");
				String arr = Arrays.toString(splitted);
				System.out.println(arr);

				ArrayList myList = new ArrayList(Arrays.asList(arr.split(",")));
				System.out.println(myList);
				System.out.println(Integer.parseInt((String) myList.get(1)));
				/*int b = (int) myList.get(3);
				int c = a*b;
				System.out.println(c);*/
				

				/*
				 * Pattern p = Pattern.compile("[a-zA-Z]+"); Matcher m = p.matcher(arr);
				 * 
				 * //Pattern p1 = Pattern.compile("([a-zA-Z]+)"); //Matcher m1 =
				 * p1.matcher(arr);
				 * 
				 * ArrayList<String> allMatches = new ArrayList<>();
				 * 
				 * while (m.find()) { allMatches.add(m.group()); //
				 * System.out.println(m.group()); // System.out.println(allMatches); }
				 * System.out.println(allMatches);
				 */
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
}
