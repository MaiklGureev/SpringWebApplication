package com.gureev.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class cServiceSection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "c_serviceSection")
    private List<sCompany> s_companies;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.ALL}, mappedBy = "c_Service_section")
    private List<cServiceClass> c_ServiceClasses;

    private String name;

    public cServiceSection() {
    }

    public cServiceSection(long id,String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<cServiceClass> getcServiceClasses() {
        return c_ServiceClasses;
    }

    public List<sCompany> getS_companies() {
        return s_companies;
    }

    public void setS_companies(List<sCompany> s_companies) {
        this.s_companies = s_companies;
    }

    public List<cServiceClass> getC_ServiceClasses() {
        return c_ServiceClasses;
    }

    public void setC_ServiceClasses(List<cServiceClass> c_ServiceClasses) {
        this.c_ServiceClasses = c_ServiceClasses;
    }

    @Override
    public String toString() {
        return "c_ServiceSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
