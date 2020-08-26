package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AddressBookManagerImplementation managerImplementation=new AddressBookManagerImplementation();
        Person person=new Person();
        File openedfile=null;
        AddressBookImplementation addressBookImplementation=new AddressBookImplementation();


        Scanner f=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        int flag=0;
        while (flag == 0) {
            System.out.println("1: Create New Address Book\n2: Open Address Book\n3: Save Address Book\n" +
                    "4: Save As AddressBook\n5: Close Address Book\n6: Quit");
            System.out.println("Please Enter your choice: ");

            int choicemain=sc.nextInt();

            switch (choicemain) {
                case 1:
                    System.out.println("Enter the name of Address Book");
                    String filename = f.nextLine();
                    managerImplementation.newAddressBook(filename);
                    break;
                case 2:
                    if (openedfile == null) {
                        managerImplementation.showFiles();
                        Scanner add = new Scanner(System.in);
                        System.out.println("In Which csv file you like to add your Address");
                        String openfile = add.nextLine();
                        openedfile = managerImplementation.openAddressBook(openfile);
                    }else{
                        int i=1;
                        while (i==1) {
                            System.out.println("1: Add Person\n2: Edit Person\n3: Delete Person\n4: Search Person\n5: Sort by Zip\n" +
                                    "6: Sort By Name\n7: Display\n8: Main Menu");

                            int choiceNest = sc.nextInt();
                            switch (choiceNest) {
                                case 1:
                                    addressBookImplementation.addPerson(openedfile);
                                    break;
                                case 2:
                                    sc.nextLine();
                                    System.out.println("Enter the phone number to edit details");
                                    String phonen = sc.nextLine();
                                    addressBookImplementation.editPerson(phonen,openedfile);
                                    break;
                                case 3:
                                    sc.nextLine();
                                    System.out.println("Enter the phone number to delete person");
                                    String phon = sc.nextLine();
                                    addressBookImplementation.deletePerson(phon, openedfile);
                                    break;
                                case 4:
                                    sc.nextLine();
                                    System.out.println("Enter the phone");
                                    String phone = sc.nextLine();

                                    addressBookImplementation.searchPerson(phone, openedfile);
                                    break;
                                case 5:
                                    addressBookImplementation.sortByZip();
                                    break;
                                case 6:
                                    addressBookImplementation.sortByName();
                                    break;
                                case 7:
                                    addressBookImplementation.display();
                                    break;
                                case 8:
                                    i = 0;
                                default:
                                    System.out.println("Invalid Choice Enterd");
                                    break;
                            }
                        }    }


                case 3:
                    managerImplementation.saveAddressBook();
                    break;
                case 4:
                    managerImplementation.saveAsAddressBook();
                    break;
                case 5:
                    managerImplementation.closeAddressBook();
                    break;
                case 6:
                    System.out.println("Exiting Address Book...");
                    flag=1;
                    break;
                default:
                    System.out.println("Invalid choice entered");
                    break;
            }
        }
    }
}