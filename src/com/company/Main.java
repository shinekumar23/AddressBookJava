package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        AddressBookManagerInterface addressBookManagerInterface=new AddressBookManagerImplementation();
        File openedfile=null;
        AddressBookInterface addressBookInterface=new AddressBookImplementation();

        Scanner f=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        int flag=0;
        while (flag == 0) {
            System.out.println("1: Create New Address Book\n2: Open Address Book\n3: List AddressBooks\n" +
                    "4: Save As AddressBook\n5: Close Address Book\n6: Quit");
            System.out.println("Please Enter your choice: ");

            String choicemain=sc.nextLine();

            switch (choicemain) {
                case "1":
                    System.out.println("Enter the name of Address Book(Without csv Extention)");
                    String filename = f.nextLine();
                    addressBookManagerInterface.newAddressBook(filename);
                    break;
                case "2":
                    if (openedfile == null) {
                        addressBookManagerInterface.showFiles();
                        Scanner add = new Scanner(System.in);
                        System.out.println("In Which csv file you like to add your Address(Type File name with extention)");
                        String openfile = add.nextLine();
                        openedfile = addressBookManagerInterface.openAddressBook(openfile);
                    }else{
                        int i=1;
                        while (i==1) {
                            System.out.println("1: Add Person\n2: Edit Person\n3: Delete Person\n4: Search Person\n5: Sort by Zip\n" +
                                    "6: Sort By Name\n7: Display\n8: Main Menu");

                            String choiceNest = f.nextLine();
                            switch (choiceNest) {
                                case "1":
                                    addressBookInterface.addPerson(openedfile);
                                    break;
                                case "2":
                                    System.out.println("Enter the phone number to edit details");
                                    String phonen = sc.nextLine();
                                    addressBookInterface.editPerson(phonen,openedfile);
                                    break;
                                case "3":
                                    System.out.println("Enter the phone number to delete person");
                                    String phon = sc.nextLine();
                                    addressBookInterface.deletePerson(phon, openedfile);
                                    break;
                                case "4":
                                    System.out.println("Enter the phone");
                                    String phone = sc.nextLine();
                                    addressBookInterface.searchPerson(phone, openedfile);
                                    break;
                                case "5":
                                    addressBookInterface.sortByZip(openedfile);
                                    break;
                                case "6":
                                    addressBookInterface.sortByName(openedfile);
                                    break;
                                case "7":
                                    addressBookInterface.display(openedfile);
                                    break;
                                case "8":
                                    i = 0;
                                    break;
                                default:
                                    System.out.println("Invalid Choice Enterd");
                                    break;
                            }
                        }    }


                break;
                case "3":
                    addressBookManagerInterface.showFiles();
                    break;
                case "4":
                    if (openedfile==null){
                        System.out.println("You should open a AddressBook first");
                    }else {
                        System.out.println("Enter new Name of file(Include .csv Extention after filename)");
                        String newname = f.nextLine();
                        addressBookManagerInterface.saveAsAddressBook(newname, openedfile);
                    }
                    break;
                case "5":
                    if(openedfile==null){
                        System.out.println("You should open a AddressBook first");
                    }else {
                        openedfile = null;
                    }
                    break;
                case "6":
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