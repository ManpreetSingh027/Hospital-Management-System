package com.hms.patient.model;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    private String name;
    private int age;
    private String address;
    private String contact;
    private String password;

    public Patient() {}

    public Patient(String username, String name, int age, String address, String contact, String password) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
