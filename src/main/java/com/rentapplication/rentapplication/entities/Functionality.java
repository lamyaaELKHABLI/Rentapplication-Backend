package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Entity
public class Functionality {
    private int functionalityId;
    private String functionalityTitle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "functionality_id")
    public int getFunctionalityId() {
        return functionalityId;
    }

    public void setFunctionalityId(int functionalityId) {
        this.functionalityId = functionalityId;
    }

    @Basic
    @Column(name = "functionality_title")
    public String getFunctionalityTitle() {
        return functionalityTitle;
    }

    public void setFunctionalityTitle(String functionalityTitle) {
        this.functionalityTitle = functionalityTitle;
    }



}
