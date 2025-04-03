package com.hms.billing.model;

import javax.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String patient;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String date;  // For simplicity, using String; consider using a Date type

    public Bill() {
    }

    public Bill(int id, String patient, double amount, String date) {
        this.id = id;
        this.patient = patient;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
