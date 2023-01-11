package com.rawrysmode.entities.job;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
    public Job(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Job() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "job_title", nullable = false, length = Integer.MAX_VALUE)
    private String jobTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return jobTitle;
    }
}