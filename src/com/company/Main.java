package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AddressBookManagerImplementation addressBookManagerImplementation=new AddressBookManagerImplementation();
        System.out.println("1: Create New Address Book\n2: Open Address Book\n3: Save Address Book\n" +
                "4: Save As AddressBook\n5: Close Address Book\n6: Quit");

        Scanner sc=new Scanner(System.in);
        Scanner f=new Scanner(System.in);
        System.out.println("Please Enter a Choice");
        int choicemain=sc.nextInt();
        switch (choicemain){
            case 1:
                System.out.println("Enter the Name of AddressBook");
                String filename=f.nextLine();
                addressBookManagerImplementation.newAddressBook(filename);
        }
    }
}
