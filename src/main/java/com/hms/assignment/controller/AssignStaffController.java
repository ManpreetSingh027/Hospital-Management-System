package com.hms.assignment.controller;

import com.hms.assignment.service.AssignmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class AssignStaffController {

    @FXML
    private ComboBox<String> patientComboBox;

    @FXML
    private ComboBox<String> doctorComboBox;

    @FXML
    private ComboBox<String> nurseComboBox;

    private AssignmentService assignmentService = new AssignmentService();

    // This method will be called automatically after the FXML file is loaded
    @FXML
    public void initialize() {
        // For demonstration, we use dummy data.
        ObservableList<String> patients = FXCollections.observableArrayList("Patient A", "Patient B", "Patient C");
        ObservableList<String> doctors = FXCollections.observableArrayList("Dr. Smith", "Dr. Johnson", "Dr. Lee");
        ObservableList<String> nurses = FXCollections.observableArrayList("Nurse Brown", "Nurse Davis", "Nurse Wilson");

        patientComboBox.setItems(patients);
        doctorComboBox.setItems(doctors);
        nurseComboBox.setItems(nurses);
    }

    // This method is triggered when the "Assign Staff" button is clicked.
    @FXML
    public void handleAssignStaff(ActionEvent event) {
        String selectedPatient = patientComboBox.getValue();
        String selectedDoctor = doctorComboBox.getValue();
        String selectedNurse = nurseComboBox.getValue();

        if (selectedPatient == null || selectedDoctor == null || selectedNurse == null) {
            System.out.println("Please select a patient, a doctor, and a nurse.");
            return;
        }

        // Call the assignment service to assign the staff
        assignmentService.assignStaff(selectedPatient, selectedDoctor, selectedNurse);
    }
}
