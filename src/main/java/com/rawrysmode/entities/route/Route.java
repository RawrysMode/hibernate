package com.rawrysmode.entities.route;

import com.rawrysmode.entities.city.City;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "departure_city_id", nullable = false)
    private City departureCity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "destination_city_id", nullable = false)
    private City destinationCity;

    @Column(name = "route_cost", nullable = false)
    private Integer routeCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Integer getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(Integer routeCost) {
        this.routeCost = routeCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) &&
                departureCity.equals(route.departureCity) &&
                destinationCity.equals(route.destinationCity) &&
                routeCost.equals(route.routeCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureCity, destinationCity, routeCost);
    }

    @Override
    public String toString() {
        return departureCity +
                " " + destinationCity +
                " " + routeCost;
    }
}