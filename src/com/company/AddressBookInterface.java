package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface AddressBookInterface {
    public void addPerson(File openedfile) throws IOException;
    public  void editPerson();
    public void deletePerson();
    public void searchPerson();
    public void sortByZip();
    public void sortByName();
    public void display();
}
