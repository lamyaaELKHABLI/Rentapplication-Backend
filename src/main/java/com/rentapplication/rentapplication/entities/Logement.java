package com.rentapplication.rentapplication.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Logement {
    private int logementId;
    private String logementAddress;
    private BigDecimal logementArea;
    private BigDecimal logementPrice;
    private byte logementPriceFixed;
    private byte logementRoomShared;
    private int logementRoomNumber;
    private int logementFloor;
    private int cityId;
    private int logementCategoryId;

    @Id
    @Column(name = "logement_id")
    public int getLogementId() {
        return logementId;
    }

    public void setLogementId(int logementId) {
        this.logementId = logementId;
    }

    @Basic
    @Column(name = "logement_address")
    public String getLogementAddress() {
        return logementAddress;
    }

    public void setLogementAddress(String logementAddress) {
        this.logementAddress = logementAddress;
    }

    @Basic
    @Column(name = "logement_area")
    public BigDecimal getLogementArea() {
        return logementArea;
    }

    public void setLogementArea(BigDecimal logementArea) {
        this.logementArea = logementArea;
    }

    @Basic
    @Column(name = "logement_price")
    public BigDecimal getLogementPrice() {
        return logementPrice;
    }

    public void setLogementPrice(BigDecimal logementPrice) {
        this.logementPrice = logementPrice;
    }

    @Basic
    @Column(name = "logement_price_fixed")
    public byte getLogementPriceFixed() {
        return logementPriceFixed;
    }

    public void setLogementPriceFixed(byte logementPriceFixed) {
        this.logementPriceFixed = logementPriceFixed;
    }

    @Basic
    @Column(name = "logement_room_shared")
    public byte getLogementRoomShared() {
        return logementRoomShared;
    }

    public void setLogementRoomShared(byte logementRoomShared) {
        this.logementRoomShared = logementRoomShared;
    }

    @Basic
    @Column(name = "logement_room_number")
    public int getLogementRoomNumber() {
        return logementRoomNumber;
    }

    public void setLogementRoomNumber(int logementRoomNumber) {
        this.logementRoomNumber = logementRoomNumber;
    }

    @Basic
    @Column(name = "logement_floor")
    public int getLogementFloor() {
        return logementFloor;
    }

    public void setLogementFloor(int logementFloor) {
        this.logementFloor = logementFloor;
    }

    @Basic
    @Column(name = "city_id")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "logement_category_id")
    public int getLogementCategoryId() {
        return logementCategoryId;
    }

    public void setLogementCategoryId(int logementCategoryId) {
        this.logementCategoryId = logementCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logement logement = (Logement) o;

        if (logementId != logement.logementId) return false;
        if (logementPriceFixed != logement.logementPriceFixed) return false;
        if (logementRoomShared != logement.logementRoomShared) return false;
        if (logementRoomNumber != logement.logementRoomNumber) return false;
        if (logementFloor != logement.logementFloor) return false;
        if (cityId != logement.cityId) return false;
        if (logementCategoryId != logement.logementCategoryId) return false;
        if (logementAddress != null ? !logementAddress.equals(logement.logementAddress) : logement.logementAddress != null)
            return false;
        if (logementArea != null ? !logementArea.equals(logement.logementArea) : logement.logementArea != null)
            return false;
        if (logementPrice != null ? !logementPrice.equals(logement.logementPrice) : logement.logementPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logementId;
        result = 31 * result + (logementAddress != null ? logementAddress.hashCode() : 0);
        result = 31 * result + (logementArea != null ? logementArea.hashCode() : 0);
        result = 31 * result + (logementPrice != null ? logementPrice.hashCode() : 0);
        result = 31 * result + (int) logementPriceFixed;
        result = 31 * result + (int) logementRoomShared;
        result = 31 * result + logementRoomNumber;
        result = 31 * result + logementFloor;
        result = 31 * result + cityId;
        result = 31 * result + logementCategoryId;
        return result;
    }
}
