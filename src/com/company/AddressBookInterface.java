package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface AddressBookInterface {
    public void addPerson(File openedfile) throws IOException;
    public  void editPerson();
    public String deletePerson(String phon,File openedfile) throws IOException;
    public String searchPerson(String phone,File openedfile) throws FileNotFoundException;
    public void sortByZip();
    public void sortByName();
    public void display();
}
