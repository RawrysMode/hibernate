package com.rawrysmode.entities.bank_detail;

import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.client.Client;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "bank_details", indexes = {
        @Index(name = "bank_details_tin_key", columnList = "tin", unique = true),
        @Index(name = "bank_details_bank_account_key", columnList = "bank_account", unique = true)
})
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "bank_name", nullable = false, length = Integer.MAX_VALUE)
    private String bankName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "tin", nullable = false, length = 10)
    private String tin;

    @Column(name = "bank_account", nullable = false, length = 20)
    private String bankAccount;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return client.getCompanyName() +
                " " + bankName +
                " " + city.getCityName() +
                " " + tin +
                " " + bankAccount;
    }
}