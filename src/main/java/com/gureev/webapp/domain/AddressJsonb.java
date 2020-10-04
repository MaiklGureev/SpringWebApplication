package com.gureev.webapp.domain;

import java.io.Serializable;


public class AddressJsonb implements Serializable {
    public String streetName;
    public String houseNumber;
    public String officeNumber;

    public AddressJsonb() {
    }

    public AddressJsonb(String streetName, String houseNumber, String officeNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.officeNumber = officeNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
