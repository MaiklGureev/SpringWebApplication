package com.gureev.webapp.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class sAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "address",fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.ALL)
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
}
