package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
    @Override
    public void newAddressBook(String filename) throws IOException {
        String CSV_HEADER = "First Name,Last Name,Phone Number,City,State,Zip\n";
        File newfile = new File(filename+".csv");
        boolean result = newfile.createNewFile();
        FileWriter newFile = new FileWriter(newfile);
        newFile.append(CSV_HEADER);
        if (result)
            System.out.println("New AddressBook File Created !");
        else
            System.out.println("File Already Exists !");
        newFile.flush();
        newFile.close();

    }

    @Override
    public void openAddressBook() {

    }

    @Override
    public void saveAddressBook() {

    }

    @Override
    public void saveAsAddressBook() {

    }

    @Override
    public void closeAddressBook() {

    }

    @Override
    public void quit() {

    }
}
