package com.smalaca.domain;

import com.smalaca.dto.AddressDto;

public class User {
    private final String login;
    private final String role;
    private String eMail;
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

    public String geteMail() {
        return eMail;
    }

    public AddressDto getAddressDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());

        return addressDto;
    }
}
