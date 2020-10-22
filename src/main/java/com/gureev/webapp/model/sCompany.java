package com.gureev.webapp.model;

import javax.persistence.*;

@Entity
public class sCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = sAddress.class, optional = false, cascade = CascadeType.REMOVE)
    private sAddress address;

    private String phone;

    @ManyToOne(targetEntity = cCompRightNorm.class, optional = false)
    private cCompRightNorm compRightNorm;

    @ManyToOne(targetEntity = cServiceSection.class, optional = false)
    private cServiceSection c_serviceSection;

    public sCompany() {
    }

    public sCompany(String name, sAddress address, String phone, cCompRightNorm compRightNorm, cServiceSection c_serviceSection) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.compRightNorm = compRightNorm;
        this.c_serviceSection = c_serviceSection;
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

    public sAddress getAddress() {
        return address;
    }

    public void setAddress(sAddress address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public cCompRightNorm getCompRightNorm() {
        return compRightNorm;
    }

    public void setCompRightNorm(cCompRightNorm compRightNorm) {
        this.compRightNorm = compRightNorm;
    }

    public cServiceSection getC_serviceSection() {
        return c_serviceSection;
    }

    public void setC_serviceSection(cServiceSection c_serviceSection) {
        this.c_serviceSection = c_serviceSection;
    }

    @Override
    public String toString() {
        return "sCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", compRightNorm=" + compRightNorm +
                ", c_serviceSection=" + c_serviceSection +
                '}';
    }
}
