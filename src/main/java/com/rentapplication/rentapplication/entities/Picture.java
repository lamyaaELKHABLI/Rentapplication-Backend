package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class  Picture {
    private int pictureId;
    private String pictureName;

    @Id
    @Column(name = "picture_id")
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "picture_name")
    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (pictureId != picture.pictureId) return false;
        if (pictureName != null ? !pictureName.equals(picture.pictureName) : picture.pictureName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pictureId;
        result = 31 * result + (pictureName != null ? pictureName.hashCode() : 0);
        return result;
    }
}
