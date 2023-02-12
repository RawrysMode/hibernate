package com.rawrysmode.entities.job;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "job_title", nullable = false, length = Integer.MAX_VALUE)
    private String jobTitle;

    public Job(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Job() {

    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id)
                && jobTitle.equals(job.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle);
    }

    @Override
    public String toString() {
        return jobTitle;
    }

}