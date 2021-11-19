package com.rentapplication.rentapplication.entities;

import javax.persistence.*;

@Table(name = "equipment_logement", indexes = {
        @Index(name = "logement_id", columnList = "logement_id"),
        @Index(name = "equipment_id", columnList = "equipment_id")
})
@Entity
public class EquipmentLogement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_logement_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "logement_id", nullable = false)
    private Logement logement;

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}