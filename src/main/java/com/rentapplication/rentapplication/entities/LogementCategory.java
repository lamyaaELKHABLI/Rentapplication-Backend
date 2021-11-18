package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Table(name = "logement_category")
@Entity
public class LogementCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logement_category_id", nullable = false)
    private Integer id;

    @Column(name = "logement_category_title", nullable = false)
    private String logementCategoryTitle;

    public String getLogementCategoryTitle() {
        return logementCategoryTitle;
    }

    public void setLogementCategoryTitle(String logementCategoryTitle) {
        this.logementCategoryTitle = logementCategoryTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}