package com.psandchill.models;

public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private String city;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String email, String tel, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
