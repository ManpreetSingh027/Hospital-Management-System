package com.hms.appointment.service;

public class AppointmentService {

    public void scheduleAppointment(String patient, String doctor, String dateTime, String reason) {
        // For demonstration, simply print out the appointment details.
        // In a real application, this method would persist the appointment to the database.
        System.out.println("Scheduled Appointment:");
        System.out.println("Patient: " + patient);
        System.out.println("Doctor: " + doctor);
        System.out.println("Date & Time: " + dateTime);
        System.out.println("Reason: " + reason);
    }
}
