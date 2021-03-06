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

    //Note: showFiles(Change '/home/shine/IdeaProjects/AddressBookJava' this Directory where your project files are there
    @Override
    public void showFiles() {
        try {
            File folder = new File("/home/shine/IdeaProjects/AddressBookJava");
            File file[] = folder.listFiles();
            System.out.println("List of CSV Files");
            for (File print : Objects.requireNonNull(file)) {
                String name = print.getName();
                if (name.contains(".csv")) {
                    System.out.println(name);

                }
            }

        }catch (Exception e){
            System.out.println("Note: Change pathname of showFiles() method in AddressBookManagerImplementation class");
        }
    }


    @Override
    public File openAddressBook(String openfile) {
        File file = new File(openfile);
        boolean check = file.exists();
        if (check) {
            System.out.print("Address Book "+openfile + " is Opened \nSelect Option 2 for Updating and Sorting AddressBook\n");
        } else {
            System.out.print("No such file exists !!!\n");
            file = null;
        }
        return file;

    }

    @Override
    public void saveAsAddressBook(String newname, File openedfile) {
        File newNamee=new File(newname);
        if (openedfile.renameTo(newNamee)){
            System.out.println("Renamed Success fully");
        }else{
            System.out.println("Some kind of error occured");
        }

    }

}
