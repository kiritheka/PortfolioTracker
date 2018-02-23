package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversion {

	public static void main(String[] args) throws java.lang.Exception {

		

		try {
			
			List<String[]> list = new ArrayList<String[]>();
			String strLine;
			int count = 0;
			
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				String[] splitted = strLine.split("[-,]");
				list.add(count, splitted);
				System.out.println(Arrays.toString(list.get(count)));
				count++;
			}
			System.out.println("count is" + count);
			
			
			int i = 0;
			
			int[][] ArrayRes = new int[count][7];
			for (String[] s : list) {
				
				int len=0;
				  for (String s1 : s) { 
					 
					 ArrayRes[i][len] = Integer.parseInt(s1);
				   //  System.out.println("value in list "+ i + len + " is" +Arrays.toString(ArrayRes[i]));  
				     len++;
				  } 
				  i++;
				  //System.out.println("length " +  ArrayRes.length);
				 
			}
			
			


			for (int j = 0; j < count; j++) {
				int value =0;
				for (int k = 0; k < list.get(j).length; k += 2) {
					value = value + (ArrayRes[j][k] * ArrayRes[j][k+1]);
					
				}
				System.out.println("total " + value);
				
			}

			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
