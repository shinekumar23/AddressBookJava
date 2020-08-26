package com.company;

import java.io.*;
import java.util.Scanner;

public class AddressBookImplementation extends Person implements AddressBookInterface {
    @Override
    public void addPerson(File openedfile) throws IOException {
        Person person = new Person(firstname, lastname, city, state, zipcode, phonenumber);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        firstname = in.nextLine();
        System.out.println("Enter last name: ");
        lastname = in.nextLine();
        System.out.println("Enter City: ");
        city = in.nextLine();
        System.out.println("Enter State: ");
        state = in.nextLine();
        System.out.println("Enter Zipcode: ");
        zipcode = in.nextLine();
        System.out.println("Enter Phone: ");
        phonenumber = in.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(openedfile, true));
        writer.append(firstname);writer.append(",");writer.append(lastname);writer.append(",");writer.append(city);
        writer.append(",");writer.append(state);writer.append(",");writer.append(zipcode);writer.append(",");
        writer.append(phonenumber);writer.append("\n");
        writer.close();
        System.out.println("The user details are entered");

    }

    @Override
    public void editPerson() {

    }

    @Override
    public String deletePerson(String phon,File openedfile) throws IOException {
        File tempFile = new File("TempFile.csv");

        BufferedReader reader = new BufferedReader(new FileReader(openedfile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String templine=searchPerson(phon,openedfile);
        if (!templine.equals("Contact not found")) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(templine)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            FileInputStream instream = null;
            FileOutputStream outstream = null;

            instream = new FileInputStream(tempFile);
            outstream = new FileOutputStream(openedfile);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }
            System.out.println("This adddress shown below is deleted successsfully\n"+templine);
            instream.close();
            outstream.close();
            tempFile.delete();
        }
        return templine;

    }

    public String searchPerson(String phone, File openedfile) throws FileNotFoundException {
        Scanner viewfile=new Scanner(openedfile);
        String templine="Contact not found";
        String line="";
        while (viewfile.hasNextLine()){
            line=viewfile.nextLine();
            String[] Contact=line.split(",");
            if(Contact[5].equals(phone)){
                System.out.println("Contact found\n"+line);
                templine=line;
            }
        }
        if (templine == "Contact not found"){
            System.out.println(templine);
        }
        return templine;

    }

    @Override
    public void sortByZip() {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void display() {

    }
}
