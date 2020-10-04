package com.gureev.webapp.domain;

import javax.persistence.*;

@Entity
public class cServiceClass {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = cServiceSection.class,optional=false,cascade = CascadeType.ALL)
    private cServiceSection c_Service_section;

    private String code;

    private String description;

    public cServiceClass() {
    }

    public cServiceClass(long id,cServiceSection c_Service_section, String code, String description) {
        this.id = id;
        this.c_Service_section = c_Service_section;
        this.code = code;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public cServiceSection getC_Service_section() {
        return c_Service_section;
    }

    public void setC_Service_section(cServiceSection c_Service_section) {
        this.c_Service_section = c_Service_section;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
