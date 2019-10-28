package com.smalaca.domain;

public class User {
    private final String login;
    private final String role;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private EMail eMail;

    public User(String login, String role) {
        this.login = login;
        this.role = role;
    }

    public void changeAddress(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
