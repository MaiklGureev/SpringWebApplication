package com.gureev.webapp.model;

import java.io.Serializable;


public class AddressJsonb implements Serializable {

    public String cityName;
    public String streetName;
    public String houseNumber;
    public String officeNumber;

    public AddressJsonb() {
    }

    public AddressJsonb( String cityName, String streetName, String houseNumber, String officeNumber) {
        this.cityName = cityName;
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



    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "AddressJsonb{" +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
    }
}
