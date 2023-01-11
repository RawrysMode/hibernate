package com.rawrysmode.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "order_wagon_places")
public class OrderWagonPlace {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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

}