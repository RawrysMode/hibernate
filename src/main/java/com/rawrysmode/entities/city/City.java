package com.rawrysmode.entities.city;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class City {
    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city_name", nullable = false, length = 25)
    private String cityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }
}