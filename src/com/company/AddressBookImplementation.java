package com.company;

import java.io.*;
import java.util.Scanner;

public class AddressBookImplementation extends Person implements AddressBookInterface {
    @Override
    public void addPerson(File openedfile) throws IOException {
        Person person = new Person(firstname, lastname, city, state, zipcode, phonenumber);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        firstname = in.nextLine();
        System.out.println("Enter last name: ");
        lastname = in.nextLine();
        System.out.println("Enter City: ");
        city = in.nextLine();
        System.out.println("Enter State: ");
        state = in.nextLine();
        System.out.println("Enter Zipcode: ");
        zipcode = in.nextLine();
        System.out.println("Enter Phone: ");
        phonenumber = in.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(openedfile, true));
        writer.append(firstname);writer.append(",");writer.append(lastname);writer.append(",");writer.append(city);
        writer.append(",");writer.append(state);writer.append(",");writer.append(zipcode);writer.append(",");
        writer.append(phonenumber);writer.append("\n");
        writer.close();
        System.out.println("The user details are entered");

    }

    @Override
    public void editPerson() {

    }

    @Override
    public void deletePerson() {

    }

    public String searchPerson(String phone, File openedfile) throws FileNotFoundException {
        Scanner viewfile=new Scanner(openedfile);
        String templine="Contact not found";
        String line="";
        while (viewfile.hasNextLine()){
            line=viewfile.nextLine();
            String[] Contact=line.split(",");
            if(Contact[5].equals(phone)){
                System.out.println("Contact found\n"+line);
                templine=line;
            }
        }
        if (templine == "Contact not found"){
            System.out.println(templine);
        }
        return templine;

    }

    @Override
    public void sortByZip() {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void display() {

    }
}
