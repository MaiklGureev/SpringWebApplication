package com.gureev.webapp.model;

import javax.persistence.*;

@Entity
public class sCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne(targetEntity = sAddress.class, optional = false, cascade = {CascadeType.REFRESH})
    private sAddress address;

    private String phone;

    @ManyToOne(targetEntity = cCompRightNorm.class, optional = false, cascade = {CascadeType.REFRESH})
    private cCompRightNorm compRightNorm;

    @ManyToOne(targetEntity = cServiceSection.class, optional = false, cascade = {CascadeType.REFRESH})
    private cServiceSection serviceSection;

    public sCompany() {
    }

    public sCompany(String name, sAddress address, String phone, cCompRightNorm compRightNorm, cServiceSection serviceSection) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.compRightNorm = compRightNorm;
        this.serviceSection = serviceSection;
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

    public cServiceSection getServiceSection() {
        return serviceSection;
    }

    public void setServiceSection(cServiceSection serviceSection) {
        this.serviceSection = serviceSection;
    }

    @Override
    public String toString() {
        return "sCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", compRightNorm=" + compRightNorm +
                ", serviceSection=" + serviceSection +
                '}';
    }
}
