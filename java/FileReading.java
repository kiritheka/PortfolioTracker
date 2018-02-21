package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReading {

	public static void main(String args[]) {

		String fileName = "/home/linuxuser/portfolio.txt";

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			//stream.forEach(System.out::printl1n);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
