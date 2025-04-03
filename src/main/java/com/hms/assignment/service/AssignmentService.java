package com.hms.assignment.service;

public class AssignmentService {

    public void assignStaff(String patient, String doctor, String nurse) {
        // For demonstration, simply print the assignment. In a real application,
        // this method would update the database with the new assignment.
        System.out.println("Assigned " + doctor + " and " + nurse + " to " + patient + ".");
    }
}
