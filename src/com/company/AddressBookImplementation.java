package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    @Override
    public void searchPerson() {

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
