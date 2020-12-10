package com.gureev.webapp.model;

import javax.persistence.*;

@Entity
public class cServiceClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @JsonIgnore
@ManyToOne(targetEntity = cServiceSection.class, optional = false, cascade = {CascadeType.REFRESH})
private cServiceSection serviceSection;

    private String code;

    private String description;

    public cServiceClass() {
    }

    public cServiceClass(long id, cServiceSection serviceSection, String code, String description) {
        this.id = id;
        this.serviceSection = serviceSection;
        this.code = code;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public cServiceSection getServiceSection() {
        return serviceSection;
    }

    public void setServiceSection(cServiceSection serviceSection) {
        this.serviceSection = serviceSection;
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

    @Override
    public String toString() {
        return "cServiceClass{" +
                "id=" + id +
                ", service_section=" + serviceSection +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
