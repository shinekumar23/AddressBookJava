package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface AddressBookInterface {
    public void addPerson(File openedfile) throws IOException;
    public  void editPerson(String phonen,File openedfile) throws IOException;
    public String deletePerson(String phon,File openedfile) throws IOException;
    public String searchPerson(String phone,File openedfile) throws FileNotFoundException;
    public ArrayList<Person> sortByZip(File openedfile) throws IOException;
    public void sortByName(File openedfile) throws IOException;
    public void display(File openedfile) throws FileNotFoundException;
}
