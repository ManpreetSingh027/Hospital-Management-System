package com.hms.doctor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors") // Ensure your remote database has a table named "doctors"
public class Doctor {

    // We'll use the username as the primary key.
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "specialization", length = 100)
    private String specialization;

    // We'll store availability as a string; adjust as needed.
    @Column(name = "availability", length = 100)
    private String availability;

    // New password field
    @Column(name = "password", length = 100)
    private String password;

    public Doctor() {
    }

    // Updated constructor including password
    public Doctor(String username, String name, String specialization, String availability, String password) {
        this.username = username;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " (" + specialization + ")";
    }
}
