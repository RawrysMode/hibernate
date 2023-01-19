package com.rawrysmode.entities.order;

import com.rawrysmode.entities.client.Client;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.route.Route;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column(name = "wagon_number", nullable = false)
    private Integer wagonNumber;

    @Column(name = "shipping_date", nullable = false)
    private LocalDate shippingDate;

    @Column(name = "shipping_cost", nullable = false)
    private Integer shippingCost;

    @Column(name = "nvc", nullable = false, length = Integer.MAX_VALUE)
    private String nvc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Integer getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(Integer wagonNumber) {
        this.wagonNumber = wagonNumber;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getNvc() {
        return nvc;
    }

    public void setNvc(String nvc) {
        this.nvc = nvc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                client.equals(order.client) &&
                employee.equals(order.employee) &&
                orderDate.equals(order.orderDate) &&
                route.equals(order.route) &&
                wagonNumber.equals(order.wagonNumber) &&
                shippingDate.equals(order.shippingDate) &&
                shippingCost.equals(order.shippingCost) &&
                nvc.equals(order.nvc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, employee, orderDate, route, wagonNumber, shippingDate, shippingCost, nvc);
    }

    @Override
    public String toString() {
        return client.getCompanyName() +
                " " + employee.getFirstname() +
                " " + employee.getLastname() +
                " " + orderDate +
                " " + route.getDepartureCity() +
                " " + route.getDestinationCity() +
                " " + wagonNumber +
                " " + shippingDate +
                " " + shippingCost +
                " " + nvc;
    }
}