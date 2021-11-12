package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Functionality {
    private int functionalityId;
    private String functionalityTitle;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Functionality that = (Functionality) o;

        if (functionalityId != that.functionalityId) return false;
        if (functionalityTitle != null ? !functionalityTitle.equals(that.functionalityTitle) : that.functionalityTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = functionalityId;
        result = 31 * result + (functionalityTitle != null ? functionalityTitle.hashCode() : 0);
        return result;
    }
}
