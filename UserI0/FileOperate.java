package newe;

import java.util.Scanner;

public class FileOperate {
	
	public String FileReader() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location file to be read");
		String Fileread = scan.next();
		return Fileread;
		
	}
	public String FileWriter() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location file to be read");
		String Filewrite = scan.next();
		return Filewrite;
		
	}
	

}
