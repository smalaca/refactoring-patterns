package com.smalaca.domain;

public class User {
    private final String login;
    private final String role;
    private EMail eMail;
    private Address address;

    private User(String login, String role) {
        this.login = login;
        this.role = role;
    }

    public static User admin(String login) {
        return new User(login, "admin");
    }

    public static User contributor(String login) {
        return new User(login, "contributor");
    }

    public static User watcher(String login) {
        return new User(login, "watcher");
    }

    public void changeAddress(String street, String postalCode, String city, String country) {
        this.address = new Address(street, postalCode, city, country);
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getPostalCode() {
        return address.getPostalCode();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getCountry() {
        return address.getCountry();
    }
}
