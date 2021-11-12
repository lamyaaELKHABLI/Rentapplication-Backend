package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {
    private int equipmentId;
    private String equipmentTitle;

    @Id
    @Column(name = "equipment_id")
    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "equipment_title")
    public String getEquipmentTitle() {
        return equipmentTitle;
    }

    public void setEquipmentTitle(String equipmentTitle) {
        this.equipmentTitle = equipmentTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        if (equipmentId != equipment.equipmentId) return false;
        if (equipmentTitle != null ? !equipmentTitle.equals(equipment.equipmentTitle) : equipment.equipmentTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentId;
        result = 31 * result + (equipmentTitle != null ? equipmentTitle.hashCode() : 0);
        return result;
    }
}
