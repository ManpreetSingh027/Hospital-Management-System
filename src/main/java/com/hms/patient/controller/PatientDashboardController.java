package com.hms.patient.controller;

import com.hms.patient.model.Patient;
import com.hms.patient.util.PatientSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PatientDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        // Retrieve the logged-in patient from the session
        Patient loggedPatient = PatientSession.getLoggedInPatient();
        if (loggedPatient != null) {
            welcomeLabel.setText("Welcome, " + loggedPatient.getName());
        } else {
            welcomeLabel.setText("Welcome, Guest");
        }
    }

    @FXML
    public void handleBookAppointment(ActionEvent event) {
        loadUI("/fxml/patient/PatientAppointmentRequestUI.fxml", "Book Appointment");
    }

    @FXML
    public void handleViewAppointments(ActionEvent event) {
        loadUI("/fxml/patient/PatientAppointmentsUI.fxml", "My Appointments");
    }

    @FXML
    public void handleViewPrescriptions(ActionEvent event) {
        loadUI("/fxml/patient/PatientPrescriptionsUI.fxml", "Prescriptions");
    }

    @FXML
    public void handleUpdateProfile(ActionEvent event) {
        loadUI("/fxml/patient/PatientProfileUI.fxml", "Update Profile");
    }

    private void loadUI(String fxmlPath, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
