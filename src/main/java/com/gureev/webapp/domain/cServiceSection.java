package com.gureev.webapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
public class cServiceSection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "c_serviceSection",
            cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<sCompany> s_companies;

    public List<cServiceClass> getcServiceClasses() {
        return cServiceClasses;
    }

    public void setcServiceClasses(List<cServiceClass> cServiceClasses) {
        this.cServiceClasses = cServiceClasses;
    }

    @OneToMany(mappedBy = "c_Service_section",orphanRemoval = true)
    private List<cServiceClass> cServiceClasses;

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

    public List<sCompany> getS_companies() {
        return s_companies;
    }

    public void setS_companies(List<sCompany> s_companies) {
        this.s_companies = s_companies;
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
