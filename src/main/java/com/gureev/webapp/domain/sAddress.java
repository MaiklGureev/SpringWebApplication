package com.gureev.webapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Transactional
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class sAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "address", orphanRemoval = true,cascade = CascadeType.ALL)
    private List<sCompany> s_companies;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private AddressJsonb addressJsonb;

    public sAddress() {
    }

    public sAddress(long id, AddressJsonb addressJsonb) {
        this.id = id;
        this.addressJsonb = addressJsonb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<sCompany> getS_companies() {
        return s_companies;
    }

    public void setS_companies(List<sCompany> s_companies) {
        this.s_companies = s_companies;
    }

    public AddressJsonb getAddressJsonb() {
        return addressJsonb;
    }

    public void setAddressJsonb(AddressJsonb addressJsonb) {
        this.addressJsonb = addressJsonb;
    }

    @Override
    public String toString() {
        return "sAddress{" +
                "id=" + id +
                ", addressJsonb=" + addressJsonb +
                '}';
    }
}
