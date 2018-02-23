package main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadLine {

    public static void main(String[] args) {        
        try {
            File file = new File("/home/linuxuser/portfolio.txt");
            Scanner sc = new Scanner(file);

            List<Person> people = new ArrayList<Person>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] eachstock = line.split("[-,]");
                String stockName = eachstock[0];
                String numberOfStock = eachstock[1];
                //int age = Integer.parseInt(details[2]);
                Person p = new Person(stockName, numberOfStock);
                people.add(p);
            }

            for(Person p: people){
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }
    }
}

class Person{

    private String gender;
    private String name;
    private int age;

    public Person(String gender, String name){
        this.gender = gender;
        this.setName(name);
       // this.age = age;
    }

    /**
     * @return the gender
     */
public String getGender() {
    return gender;
}

/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
    this.gender = gender;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}

/**
 * @return the name
 */
public String getName() {
    return name;
}

/**
 * @return the age
 */
public int getAge() {
    return age;
}

/**
 * @param age the age to set
 */
public void setAge(int age) {
    this.age = age;
}

public String toString(){
    return this.gender + " " + this.name + " " + this.age;
}


}