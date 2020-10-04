package com.gureev.webapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class cCompRightNorm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "compRightNorm",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<sCompany> s_companies;

    private String name;

    public cCompRightNorm() {
    }

    public cCompRightNorm(String name) {
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
}
