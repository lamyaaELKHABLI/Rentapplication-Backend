package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Table(name = "equipment")
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id", nullable = false)
    private Integer id;

    @Column(name = "equipment_title", nullable = false)
    private String equipmentTitle;

    public String getEquipmentTitle() {
        return equipmentTitle;
    }

    public void setEquipmentTitle(String equipmentTitle) {
        this.equipmentTitle = equipmentTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}