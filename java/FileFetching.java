package main.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileFetching {

	public static void main(String args[]) {
		
		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			List<String[]> list = new ArrayList<String[]>();
			int count=0;
			while ((strLine = br.readLine()) != null) {
				list.add(strLine);
			}
			for (String[] country : list) {
				  System.out.println(Arrays.toString(country); // or whatever
				}	
		}
		
		

		/*try {
			//System.out.println(Files.lines(new File("/home/linuxuser/portfolio.txt").toPath()).collect(Collectors.toList()));
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			List<String> list = new ArrayList<String>();
			int count=0;
			String[] stringArr;
			while ((strLine = br.readLine()) != null) {
				list.add(strLine);
				//System.out.println(strLine);
				 stringArr = list.toArray(new String[count]);
				 list.clear();
				System.out.println(Arrays.toString(stringArr));
				count++;
			}
			
			//System.out.println(Arrays.toString(stringArr));

			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
*/
	}
	
}

/*
 * try {
 * 
 * FileInputStream fstream = new
 * FileInputStream("/home/linuxuser/portfolio.txt"); BufferedReader br = new
 * BufferedReader(new InputStreamReader(fstream)); String strLine; int count=0;
 * while ((strLine = br.readLine()) != null) { //strArray = new String[]
 * {strLine}; System.out.println(strLine); count++; } System.out.println(count);
 * String[] strArray= new String[count-1]; for (int i=0;i<count;i++) { while
 * ((strLine = br.readLine()) != null) { strArray[i]=strLine; } }
 * System.out.println(strArray);
 * 
 * 
 * 
 * 
 * System.out.println(Arrays.toString(strArray)); int len = strArray.length;
 * System.out.println(len); System.out.println(Arrays.toString(strArray));
 * 
 * fstream.close(); } catch (Exception e) { System.err.println("Error: " +
 * e.getMessage()); }
 * 
 * }
 */
