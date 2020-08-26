package com.company;

public class Person {

    public String firstname;
    public String lastname;
    public String city;
    public String state;
    public String zipcode;
    public String phonenumber;


    public Person(String firstname, String lastname, String city, String state, String zipcode, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
    }

    public Person() {
        firstname = "";
        lastname = "";
        city = "";
        state = "";
        zipcode = "";
        phonenumber = "";


    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(String city) {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    @Override
    public String toString() {
        return firstname + " ," + lastname + " , " + state + " , " + city + " , " + zipcode + " , " + phonenumber;
    }
}
