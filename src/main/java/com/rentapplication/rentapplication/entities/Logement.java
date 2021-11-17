package com.rentapplication.rentapplication.entities;

import com.rentapplication.rentapplication.entities.City;
import com.rentapplication.rentapplication.entities.LogementCategory;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "logement", indexes = {
        @Index(name = "logement_category_id", columnList = "logement_category_id"),
        @Index(name = "city_id", columnList = "city_id")
})
@Entity
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logement_id", nullable = false)
    private Integer id;

    @Column(name = "logement_address", nullable = false)
    private String logementAddress;

    @Column(name = "logement_area", nullable = false, precision = 16, scale = 2)
    private BigDecimal logementArea;

    @Column(name = "logement_price", nullable = false, precision = 16, scale = 2)
    private BigDecimal logementPrice;

    @Column(name = "logement_price_fixed", nullable = false)
    private Boolean logementPriceFixed = false;

    @Column(name = "logement_room_shared", nullable = false)
    private Boolean logementRoomShared = false;

    @Column(name = "logement_room_number", nullable = false)
    private Integer logementRoomNumber;

    @Column(name = "logement_floor", nullable = false)
    private Integer logementFloor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "logement_category_id", nullable = false)
    private LogementCategory logementCategory;

    public LogementCategory getLogementCategory() {
        return logementCategory;
    }

    public void setLogementCategory(LogementCategory logementCategory) {
        this.logementCategory = logementCategory;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getLogementFloor() {
        return logementFloor;
    }

    public void setLogementFloor(Integer logementFloor) {
        this.logementFloor = logementFloor;
    }

    public Integer getLogementRoomNumber() {
        return logementRoomNumber;
    }

    public void setLogementRoomNumber(Integer logementRoomNumber) {
        this.logementRoomNumber = logementRoomNumber;
    }

    public Boolean getLogementRoomShared() {
        return logementRoomShared;
    }

    public void setLogementRoomShared(Boolean logementRoomShared) {
        this.logementRoomShared = logementRoomShared;
    }

    public Boolean getLogementPriceFixed() {
        return logementPriceFixed;
    }

    public void setLogementPriceFixed(Boolean logementPriceFixed) {
        this.logementPriceFixed = logementPriceFixed;
    }

    public BigDecimal getLogementPrice() {
        return logementPrice;
    }

    public void setLogementPrice(BigDecimal logementPrice) {
        this.logementPrice = logementPrice;
    }

    public BigDecimal getLogementArea() {
        return logementArea;
    }

    public void setLogementArea(BigDecimal logementArea) {
        this.logementArea = logementArea;
    }

    public String getLogementAddress() {
        return logementAddress;
    }

    public void setLogementAddress(String logementAddress) {
        this.logementAddress = logementAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}