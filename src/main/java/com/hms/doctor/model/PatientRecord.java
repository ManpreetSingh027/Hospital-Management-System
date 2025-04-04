package com.hms.doctor.model;

import javax.persistence.*;

@Entity
@Table(name = "patient_records")
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    // Optional: Uncomment if you want to store prescription details
    // @Column(name = "prescription")
    // private String prescription;

    public PatientRecord() {
        // Default constructor required by JPA
    }

    public PatientRecord(String patientName, String diagnosis) {
        this.patientName = patientName;
        this.diagnosis = diagnosis;
    }

    public PatientRecord(int i, String patientA, String hypertension) {
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Optional getters and setters for prescription
    // public String getPrescription() {
    //     return prescription;
    // }
    //
    // public void setPrescription(String prescription) {
    //     this.prescription = prescription;
    // }

    @Override
    public String toString() {
        return "PatientRecord{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
