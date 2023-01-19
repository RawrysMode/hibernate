package com.rawrysmode.entities.city;

import jakarta.persistence.*;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName);
    }

    @Override
    public String toString() {
        return cityName;
    }
}