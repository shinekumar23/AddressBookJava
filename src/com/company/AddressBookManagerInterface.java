package com.company;

import java.io.File;
import java.io.IOException;

public interface AddressBookManagerInterface {

    public void newAddressBook(String filename) throws IOException;

    public void openAddressBook();

    public void saveAddressBook();

    public void saveAsAddressBook();

    public void closeAddressBook();

    public void quit();
}