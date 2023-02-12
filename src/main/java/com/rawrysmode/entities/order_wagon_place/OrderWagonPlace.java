package com.rawrysmode.entities.order_wagon_place;

import com.rawrysmode.entities.order.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Table(name = "order_wagon_places")
public class OrderWagonPlace {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "space_number", nullable = false)
    private Integer spaceNumber;

    @Column(name = "size", nullable = false, length = 15)
    private String size;

    @Column(name = "weight", nullable = false, length = 15)
    private String weight;

    @Column(name = "insurance_cost", nullable = false)
    private Integer insuranceCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(Integer spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(Integer insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderWagonPlace that = (OrderWagonPlace) o;
        return Objects.equals(id, that.id) &&
                order.equals(that.order) &&
                spaceNumber.equals(that.spaceNumber) &&
                size.equals(that.size) &&
                weight.equals(that.weight) &&
                insuranceCost.equals(that.insuranceCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, spaceNumber, size, weight, insuranceCost);
    }

    @Override
    public String toString() {
        return order.getClient().getCompanyName() +
                " " + order.getWagonNumber() +
                " " + spaceNumber +
                " " + size +
                " " + weight +
                " " + insuranceCost;
    }

}