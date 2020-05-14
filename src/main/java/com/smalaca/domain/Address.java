package com.smalaca.domain;

class Address {
    private final String street;
    private final String postalCode;
    private final String city;
    private final String country;

    Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    String getStreet() {
        return street;
    }

    String getPostalCode() {
        return postalCode;
    }

    String getCity() {
        return city;
    }

    String getCountry() {
        return country;
    }
}
