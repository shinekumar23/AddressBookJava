package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBookImplementation extends Person implements AddressBookInterface {
    ArrayList<Person> people = new ArrayList<>();

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
        String phoneverify = "";
        Scanner viewfile = new Scanner(openedfile);
        String line = "";
        System.out.println("Enter Phone: ");
        phoneverify = in.nextLine();
        while (viewfile.hasNextLine()) {
            line = viewfile.nextLine();
            String[] Contact = line.split(",");
            if (Contact[5].equals(phoneverify)) {
                System.out.println("Phone Number or Person Already Exists, Try Adding a different Address");
                phoneverify = null;
                break;
            }
        }

        if (phoneverify != null) {
            phonenumber = phoneverify;

            BufferedWriter writer = new BufferedWriter(new FileWriter(openedfile, true));
            writer.append(firstname);writer.append(",");writer.append(lastname);
            writer.append(",");writer.append(city);writer.append(",");
            writer.append(state);writer.append(",");writer.append(zipcode);
            writer.append(",");writer.append(phonenumber);writer.append("\n");
            writer.close();
            System.out.println("The user details are entered");

        }
    }



    @Override
    public void editPerson(String phonen,File openedfile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(openedfile, true));
        String lineToRemove = deletePerson(phonen, openedfile);

        if (!lineToRemove.equals("Contact not found")){
            String[] contactData = lineToRemove.split(",");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Edit First Name: Enter First Name or type 'S' to keep as it is");
            String ans = scanner.nextLine();
            if (ans.equals("S")){
                firstname = contactData[0];
                lastname=contactData[1];
            }else{
                firstname = ans;
                System.out.println("Enter last name");
                ans=scanner.nextLine();
                lastname=ans;

            }
            System.out.println("Edit City: Enter City or type 'S' to keep as it is");
            ans=scanner.nextLine();
            if (ans.equals("S")){
                city=contactData[2];
            }else {
                city=ans;
            }
            System.out.println("Edit State. Enter State or 'S' to keep State as it is");
            ans = scanner.nextLine();
            if (ans.equals("S")){
                state = contactData[3];
            }else{
                state = ans;
            }
            System.out.println("Edit zipcode. Enter a new zipcode or 'S' to keep address as it is");
            ans = scanner.nextLine();
            if (ans.equals("S")){
                zipcode = contactData[4];
            }else{
                zipcode = ans;
            }
            phonenumber=contactData[5];

            writer.append(firstname);writer.append(",");writer.append(lastname);writer.append(",");writer.append(city);
            writer.append(",");writer.append(state);writer.append(",");writer.append(zipcode);writer.append(",");
            writer.append(phonenumber);writer.append("\n");
            writer.close();
        }

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
    @Override
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
    public ArrayList<Person> sortByZip(File openedfile) throws IOException {
        ArrayList<Person> ListOfPeople;
        BufferedReader br = new BufferedReader(new FileReader(openedfile));
        ListOfPeople = new ArrayList<>();

        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            if (line == "First Name,Last Name,Phone Number,City,State,Zip")
                continue;
            Person p = new Person();
            p.setFirstname(line.split(",")[0]);
            p.setLastname(line.split(",")[1]);
            p.setCity(line.split(",")[2]);
            p.setState(line.split(",")[3]);
            p.setZipcode(line.split(",")[4]);
            p.setPhonenumber(line.split(",")[5]);
            ListOfPeople.add(p);
        }

        Map<String, Person> map = new TreeMap<>();
        int i = 1;
        for (Person p : ListOfPeople) {
            String key = p.getZipcode();
            if (map.containsKey(key)) {
                key = key + i;
                i++;
            }
            map.put(key, p);
        }
        System.out.println("***** Records Sorted by Zip *****\nFirst Name,Last Name,Phone Number,City,State,Zip");
        for (Person person : map.values()) {
            System.out.print(person.toString() + "\n");
        }
        return ListOfPeople;

    }

    @Override
    public void sortByName(File openedfile) throws IOException {
        people = sortByZip(openedfile);
        Map<String, Person> map = new TreeMap<>();

        int i = 0;
        for (Person person : people) {
            String key = person.getFirstname();
            if (map.containsKey(key)) {
                key = key + "" + i;
                i++;
            }
            map.put(key, person);
        }
        System.out.println("\n***** Records Sorted by First Name *****\nFirst Name,Last Name,Phone Number,City,State,Zip");
        for (Person person : map.values()) {
            System.out.print(person.toString() + "\n");
        }


    }

    @Override
    public void display(File openedfile) throws FileNotFoundException {
        Scanner viewfile=new Scanner(openedfile);

        while (viewfile.hasNextLine()){
            System.out.println(viewfile.nextLine());
        }
    }

    }

