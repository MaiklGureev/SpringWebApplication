package com.gureev.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class cServiceSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceSection", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<sCompany> companies;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceSection", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<cServiceClass> serviceClasses;

    private String name;

    public cServiceSection() {
    }

    public cServiceSection(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<sCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<sCompany> companies) {
        this.companies = companies;
    }

    public List<cServiceClass> getServiceClasses() {
        return serviceClasses;
    }

    public void setServiceClasses(List<cServiceClass> serviceClasses) {
        this.serviceClasses = serviceClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "c_ServiceSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
