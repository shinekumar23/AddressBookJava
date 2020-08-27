package com.company;

import java.io.File;
import java.io.IOException;

public interface AddressBookManagerInterface {

    public void newAddressBook(String filename) throws IOException;

    public File openAddressBook(String openfile);

    public void showFiles();

    public void saveAsAddressBook(String newname, File openedfile);

}