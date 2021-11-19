package com.rentapplication.rentapplication.entities;

import com.rentapplication.rentapplication.entities.Logement;

import javax.persistence.*;

@Table(name = "picture", indexes = {
        @Index(name = "logement_id", columnList = "logement_id")
})
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id", nullable = false)
    private Integer id;

    @Column(name = "picture_name")
    private String pictureName;

    @Column(name = "picture_filename", nullable = false)
    private String pictureFilename;

    @Column(name = "picture_status")
    private Boolean pictureStatus = true;

    @Column(name = "picture_deleted")
    private Boolean pictureDeleted = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "logement_id", nullable = false)
    private Logement logement;

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public Boolean getPictureDeleted() {
        return pictureDeleted;
    }

    public void setPictureDeleted(Boolean pictureDeleted) {
        this.pictureDeleted = pictureDeleted;
    }

    public Boolean getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(Boolean pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public String getPictureFilename() {
        return pictureFilename;
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename = pictureFilename;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}