package com.hms.patient.service;

public class PatientAppointmentService {

    public boolean submitAppointmentRequest(String doctor, String appointmentDateTime, String reason) {
        // For demonstration, print the request details.
        System.out.println("Appointment Request Submitted:");
        System.out.println("Doctor: " + doctor);
        System.out.println("Date & Time: " + appointmentDateTime);
        System.out.println("Reason: " + reason);
        // Return true to indicate success (in a real app, persist the request)
        return true;
    }
}
