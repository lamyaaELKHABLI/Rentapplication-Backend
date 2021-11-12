package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flatmmate {
    private int flatmmateId;
    private String flatmmateFullname;
    private int flatmmateAge;
    private int logementId;
    private int functionalityId;

    @Id
    @Column(name = "flatmmate_id")
    public int getFlatmmateId() {
        return flatmmateId;
    }

    public void setFlatmmateId(int flatmmateId) {
        this.flatmmateId = flatmmateId;
    }

    @Basic
    @Column(name = "flatmmate_fullname")
    public String getFlatmmateFullname() {
        return flatmmateFullname;
    }

    public void setFlatmmateFullname(String flatmmateFullname) {
        this.flatmmateFullname = flatmmateFullname;
    }

    @Basic
    @Column(name = "flatmmate_age")
    public int getFlatmmateAge() {
        return flatmmateAge;
    }

    public void setFlatmmateAge(int flatmmateAge) {
        this.flatmmateAge = flatmmateAge;
    }

    @Basic
    @Column(name = "logement_id")
    public int getLogementId() {
        return logementId;
    }

    public void setLogementId(int logementId) {
        this.logementId = logementId;
    }

    @Basic
    @Column(name = "functionality_id")
    public int getFunctionalityId() {
        return functionalityId;
    }

    public void setFunctionalityId(int functionalityId) {
        this.functionalityId = functionalityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flatmmate flatmmate = (Flatmmate) o;

        if (flatmmateId != flatmmate.flatmmateId) return false;
        if (flatmmateAge != flatmmate.flatmmateAge) return false;
        if (logementId != flatmmate.logementId) return false;
        if (functionalityId != flatmmate.functionalityId) return false;
        if (flatmmateFullname != null ? !flatmmateFullname.equals(flatmmate.flatmmateFullname) : flatmmate.flatmmateFullname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flatmmateId;
        result = 31 * result + (flatmmateFullname != null ? flatmmateFullname.hashCode() : 0);
        result = 31 * result + flatmmateAge;
        result = 31 * result + logementId;
        result = 31 * result + functionalityId;
        return result;
    }
}
