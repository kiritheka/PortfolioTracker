import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import main.java.FileFetching;

public class PortTracker {

	public int fileFetching() {
		List<String[]> list = new ArrayList<String[]>();
		String strLine;
		int count = 0;

		try {
			FileInputStream fstream = new FileInputStream("/home/linuxuser/portfolio.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {
				String[] splitted = strLine.split("[-,]");
				list.add(count, splitted);
				System.out.println(Arrays.toString(list.get(count)));
				count++;
			}

			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return count;

	}

	public static void main(String args[]) {
		PortTracker portTracker = new PortTracker();
		System.out.println(portTracker.fileFetching());

	}
}
