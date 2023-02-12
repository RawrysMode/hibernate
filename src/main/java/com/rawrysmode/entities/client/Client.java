package com.rawrysmode.entities.client;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "company_name", nullable = false, length = Integer.MAX_VALUE)
    private String companyName;

    @Column(name = "postal_address", nullable = false, length = Integer.MAX_VALUE)
    private String postalAddress;

    @Column(name = "phone_number", nullable = false, length = Integer.MAX_VALUE)
    private String phoneNumber;

    @Column(name = "fax_number", nullable = false, length = Integer.MAX_VALUE)
    private String faxNumber;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                companyName.equals(client.companyName) &&
                postalAddress.equals(client.postalAddress) &&
                phoneNumber.equals(client.phoneNumber) &&
                faxNumber.equals(client.faxNumber)
                && email.equals(client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, postalAddress, phoneNumber, faxNumber, email);
    }

    @Override
    public String toString() {
        return companyName;
    }

}