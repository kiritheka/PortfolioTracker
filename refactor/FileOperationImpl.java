package refactor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileOperationImpl  {

	public String[] FileReader() {

		String strLine;
		String[] stringaarray = new String[3];
		int count = 0;

		FileInputStream fstream;
		try {
			fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			
			while ((strLine = br.readLine()) != null) {
				stringaarray[count] = strLine;
				count++;
				//System.out.println(stringaarray)
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(stringaarray);
		return stringaarray;
	}


	public void FileWriter() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws Exception {

		FileOperationImpl fileOperationImpl = new FileOperationImpl();
		fileOperationImpl.FileReader();
	/*	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location file to be read");
		String fileread = scan.next();
		fileOperationImpl.FileReader();
		System.out.println("Enter the location file to be written");
		String fileWrite = scan.next();*/

	}

}
