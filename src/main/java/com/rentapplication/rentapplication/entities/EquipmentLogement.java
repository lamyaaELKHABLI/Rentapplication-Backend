package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Entity
@Table(name = "equipment_logement", schema = "rentapplication", catalog = "")
public class EquipmentLogement {
    private int equipmentLogementId;
    private int equipmentId;
    private int logementId;

    @Id
    @Column(name = "equipment_logement_id")
    public int getEquipmentLogementId() {
        return equipmentLogementId;
    }

    public void setEquipmentLogementId(int equipmentLogementId) {
        this.equipmentLogementId = equipmentLogementId;
    }

    @Basic
    @Column(name = "equipment_id")
    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "logement_id")
    public int getLogementId() {
        return logementId;
    }

    public void setLogementId(int logementId) {
        this.logementId = logementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentLogement that = (EquipmentLogement) o;

        if (equipmentLogementId != that.equipmentLogementId) return false;
        if (equipmentId != that.equipmentId) return false;
        if (logementId != that.logementId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentLogementId;
        result = 31 * result + equipmentId;
        result = 31 * result + logementId;
        return result;
    }
}
