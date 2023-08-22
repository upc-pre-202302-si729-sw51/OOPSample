package com.acme.platform.shared.domain.model.valueobjects;

public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Address() {
        this.street = "";
        this.city = "";
        this.state = "";
        this.country = "";
        this.zipCode = "";
    }

    public String getAddressAsString() {
        return String.format("%s, %s, %s, %s, %s", street, city, state, country, zipCode);
    }
}
