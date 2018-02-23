package main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileList {
	public static void main(String args[]) {

		try {

			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			while ((strLine = br.readLine()) != null) {

				String[] splitted = strLine.split("[-,]");
				System.out.println(Arrays.toString(splitted));
				//System.out.println(splitted[05]);
			}
			

			br.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

/*
int i = 0;
for (List<String> nestedList : list) {
    array[i++] = nestedList.toArray(new String[nestedList.size()]);
}*/
		
/*int[] results = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
   
        results[i] = Integer.parseInt(arr);
        System.out.println("1");
        System.out.println(results);
        System.out.println("2");

   
}
*/
		
		
		
		
		
	/*
		//double arr[] = new double[(list.get(2)).length];
		String listie = (String)list.get(0);
	
		for (String arr : listie) {
			
			System.out.println(arr);
			
		}
		//System.out.println(arr);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for(int i=0;i<list.size();i++) 
		{
				String[] list1 =list.get(i);
				int leng = list1.length;
			for(int j=0;j<=leng;j++)
			{
				double arr[] =
			}
		}*/
		
		
	//	arr[i][]
		
		
		
		/*ListIterator<String[]> itr=list.listIterator();  
		
		while(itr.hasNext()){  
			System.out.println(Arrays.toString(itr.next()));  
			}  */
		
		
		/*String[][] str = new String[][] {};
		
			for(int i=0;i<list.size();i++)
			{
				for(int j=0;i<list.get(i).length;j++) {
					
					for (String[] stri : list) {
					str[i][j] = stri;
					
				}
					*/
			
			
		
		
		
		
		
		
		
		
		
	/*
	String[] array = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(0)
		System.out.println(array[i]);
		}*/


/*public String[] addingToArray() {
	PortTracker portTracker = new PortTracker();
	int initial = portTracker.fileFetching();
	String[] stringArr = new String[initial];
	try {
		FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		int i= 0;
		
		String strLine;
		while ((strLine = br.readLine()) != null){
			System.out.println(strLine);
			stringArr[i] = strLine;
		    i++;
		    System.out.println(stringArr[i]);
		}
		
	
		fstream.close();
	} catch (Exception e) {
		System.err.println("Error: " + e.getMessage());
	}
	return stringArr;

}*/
/*for (int i = 0; i < list.size(); i++) {

for (int j = 0; j <= (list.get(i).length); j++) {
	String arr = (list.get(i)[j]);
	System.out.println(arr);
}
System.out.println("k");

}*/
