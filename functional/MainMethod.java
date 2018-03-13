package functional;

import java.util.Scanner;

public class MainMethod {

	public String FileReaderLoaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location file to be read");
		String filereadLocation = scan.next();
		return filereadLocation;

	}

	public String FileWriterLoaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the location file to be written");
		String filewriteLocation = scan.next();
		return filewriteLocation;

	}

	public static void main(String[] args) throws Exception {
		MainMethod mainMethod = new MainMethod();
		FileOperation fileOperation = new FileOperation();
	
		String readLocation = mainMethod.FileReaderLoaction();
		String writeLocation = mainMethod.FileWriterLoaction();
		
		fileOperation.FileOperatorMethod(readLocation,writeLocation);

	}

}
