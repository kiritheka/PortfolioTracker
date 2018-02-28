package newe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserIO implements Porte {

	FileOperate symbols = new FileOperate();
	String readString = symbols.FileReader();
	String writeString = symbols.FileWriter();

	@Override
	public long fileCounting() throws Exception {
		long leng = Files.lines(Paths.get(URI.create("file:///" + readString))).count();
		return leng;
	}

	@Override
	public String[] stringArray() throws Exception {
		int count = (int) fileCounting();
		String[] stringaarray = new String[count];

		String strLine;
		int count1 = 0;

		FileInputStream fstream = new FileInputStream(readString);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		while ((strLine = br.readLine()) != null) {

			stringaarray[count1] = strLine;
			count1++;
		}
		fstream.close();
		System.out.println("hello" + Arrays.toString(stringaarray));
		return stringaarray;

	}

	@Override
	public List<String[]> fileReading() throws Exception {

		List<String[]> list = new ArrayList<String[]>();

		try {
			String strLine;
			int count1 = 0;
			FileInputStream fstream = new FileInputStream(readString);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {

				strLine = strLine.replaceAll("GOOG", "500").replace("MS", "900").replace("INFY", "500").replace("AMZN",
						"700");
				String[] splitted = strLine.split("[-,]");
				System.out.println(Arrays.toString(splitted));
				list.add(count1, splitted);
				// System.out.println(list);
				count1++;

			}

			fstream.close();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return list;
	}

	@Override
	public int[] portfolioCalculation() throws Exception {

		int count = (int) fileCounting();
		List<String[]> list = fileReading();

		int i = 0;
		int[][] ArrayRes = new int[count][7];
		for (String[] s : list) {

			int len = 0;
			for (String s1 : s) {

				ArrayRes[i][len] = Integer.parseInt(s1);
				len++;
			}
			i++;
		}

		int arr1[] = new int[(count)];
		for (int j = 0; j < count; j++) {
			int value = 0;
			for (int k = 0; k < list.get(j).length; k += 2) {

				value = value + (ArrayRes[j][k] * ArrayRes[j][k + 1]);

			}
			arr1[j] = value;
			System.out.println("total " + arr1[j]);
		}

		return arr1;
	}

	@Override
	public void portfolioSorting() throws Exception {

		// final String FILENAME = "/home/linuxuser/portfoliowritee.txt";
		int arr1[] = portfolioCalculation();
		int count = (int) fileCounting();
		String[] stringaarray = stringArray();

		for (int fir = 0; fir < arr1.length; fir++) {
			for (int l = count - 1; l > fir; l--) {
				if (arr1[fir] < arr1[l]) {
					int temp = arr1[l];
					String temp1 = stringaarray[l];

					arr1[l] = arr1[fir];
					stringaarray[l] = stringaarray[fir];

					arr1[fir] = temp;
					stringaarray[fir] = temp1;

				}

			}
		}
		
		for (int c = 0; c < arr1.length; c++) {
			System.out.println(stringaarray[c] + " value is " + arr1[c]);
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(writeString));

		for (int h = 0; h < (stringaarray.length); h++) {
			bw.write(stringaarray[h]);
			bw.newLine();
		}
		bw.close();
	}

	public static void main(String[] args) throws Exception {

		UserIO replacingg = new UserIO();
		replacingg.portfolioSorting();

	}
}
