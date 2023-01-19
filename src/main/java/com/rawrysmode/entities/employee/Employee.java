package com.rawrysmode.entities.employee;

import com.rawrysmode.entities.job.Job;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "patronymic", length = 30)
    private String patronymic;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "residential_address", length = Integer.MAX_VALUE)
    private String residentialAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "salary")
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstAndLastName() {
        return firstname + " " + lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                firstname.equals(employee.firstname) &&
                patronymic.equals(employee.patronymic) &&
                lastname.equals(employee.lastname) &&
                dateOfBirth.equals(employee.dateOfBirth) &&
                residentialAddress.equals(employee.residentialAddress) &&
                job.equals(employee.job) &&
                salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, patronymic, lastname, dateOfBirth, residentialAddress, job, salary);
    }

    @Override
    public String toString() {
        return firstname +
                " " + patronymic +
                " " + lastname +
                " " + dateOfBirth +
                " " + residentialAddress +
                " " + job.getJobTitle() +
                " " + salary;
    }
}