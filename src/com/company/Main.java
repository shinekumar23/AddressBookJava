package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AddressBookManagerImplementation addressBookManagerImplementation = new AddressBookManagerImplementation();
        AddressBookImplementation addressBookImplementation = new AddressBookImplementation();
        File openedfile = null;
        int flag = 0;
        while (flag == 0) {
            System.out.println("1: Create New Address Book\n2: Open Address Book\n3: Save Address Book\n" +
                    "4: Save As AddressBook\n5: Close Address Book\n6: Quit");

            Scanner sc = new Scanner(System.in);
            Scanner f = new Scanner(System.in);
            System.out.println("Please Enter a Choice");
            int choicemain = sc.nextInt();

            switch (choicemain) {
                case 1:
                    System.out.println("Enter the Name of AddressBook Without csv Extention");
                    String filename = f.nextLine();
                    addressBookManagerImplementation.newAddressBook(filename);
                case 2:
                        addressBookManagerImplementation.showFiles();
                        Scanner add = new Scanner(System.in);
                        System.out.println("In Which csv file you like to add your Address");
                        String openfile = add.nextLine();
                        openedfile = addressBookManagerImplementation.openAddressBook(openfile);
                            System.out.println("1: Add Person\n2: Edit Person\n3: Delete Person\n4: Search Person\n5: Sort by Zip\n" +
                                    "6: Sort By Name\n7: Display\n8: Main Menu");

                            int choiceNest = sc.nextInt();
                            switch (choiceNest) {
                                case 1:
                                    addressBookImplementation.addPerson(openedfile);
                                    break;
                                case 4:
                                    sc.nextLine();
                                    System.out.println("Enter the phone");
                                    String phone = sc.nextLine();
                                    addressBookImplementation.searchPerson(phone, openedfile);
                                    break;
                                default:
                                    System.out.println("Other Options are not implemented");
                                    break;
                            }
                case 6:
                    flag=1;
                    break;
                default:
                    System.out.println("Other Options are not implemented");
            }
        }
    }
}