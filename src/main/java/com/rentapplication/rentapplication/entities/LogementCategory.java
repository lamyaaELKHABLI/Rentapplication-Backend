package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Entity
@Table(name = "logement_category", schema = "rentapplication", catalog = "")
public class LogementCategory {
    private int logementCategoryId;
    private String logementCategoryTitle;

    @Id
    @Column(name = "logement_category_id")
    public int getLogementCategoryId() {
        return logementCategoryId;
    }

    public void setLogementCategoryId(int logementCategoryId) {
        this.logementCategoryId = logementCategoryId;
    }

    @Basic
    @Column(name = "logement_category_title")
    public String getLogementCategoryTitle() {
        return logementCategoryTitle;
    }

    public void setLogementCategoryTitle(String logementCategoryTitle) {
        this.logementCategoryTitle = logementCategoryTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogementCategory that = (LogementCategory) o;

        if (logementCategoryId != that.logementCategoryId) return false;
        if (logementCategoryTitle != null ? !logementCategoryTitle.equals(that.logementCategoryTitle) : that.logementCategoryTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logementCategoryId;
        result = 31 * result + (logementCategoryTitle != null ? logementCategoryTitle.hashCode() : 0);
        return result;
    }
}
