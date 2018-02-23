package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberMultiply {
	public static void main(String[] args) throws FileNotFoundException{
        File file = new File("/home/linuxuser/sample.txt");

        Scanner sc = new Scanner(file);

        int value1;
        int value2;
        int total;

        while(sc.hasNext()){
        	
        	value1 = sc.nextInt();
        	value2 = sc.nextInt();
            total = value1 * value2;
            System.out.println(total); 
        }
    }
}
