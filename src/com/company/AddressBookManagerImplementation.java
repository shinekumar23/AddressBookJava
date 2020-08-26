package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
    @Override
    public void newAddressBook(String filename) throws IOException {
        String CSV_HEADER = "First Name,Last Name,City,State,Zip,Phone Number\n";
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
    public File openAddressBook(String openfile) {
        File file = new File(openfile);
        boolean check = file.exists();
        if (check) {
            System.out.print("Address Book "+openfile + " is Opened \n");
        } else {
            System.out.print("No such file exists !!!");
            file = null;
        }
        return file;

    }

    public void showFiles() {
        File folder = new File("/home/shine/IdeaProjects/AddressBookJava");
        File file[] = folder.listFiles();
        System.out.println("List of CSV Files");
        for (File print : Objects.requireNonNull(file)) {
            String name = print.getName();
            if (name.contains(".csv")) {
                System.out.println(name);
            }
        }
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
