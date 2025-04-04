package com.hms.patient.controller;

import com.hms.patient.model.Patient;
import com.hms.patient.service.PatientService;
import com.hms.patient.util.PatientSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientProfileController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField newPasswordField;
    @FXML
    private Label feedbackLabel;

    private PatientService patientService = new PatientService();
    private Patient currentPatient;

    @FXML
    public void initialize() {
        // Load the logged-in patient from the session; for demonstration, using a dummy value if null.
        currentPatient = PatientSession.getLoggedInPatient();
        if (currentPatient != null) {
            nameField.setText(currentPatient.getName());
            ageField.setText(String.valueOf(currentPatient.getAge()));
            addressField.setText(currentPatient.getAddress());
            contactField.setText(currentPatient.getContact());
        }
    }

    @FXML
    public void handleUpdateProfile(ActionEvent event) {
        if (currentPatient != null) {
            currentPatient.setName(nameField.getText());
            try {
                currentPatient.setAge(Integer.parseInt(ageField.getText()));
            } catch (NumberFormatException e) {
                feedbackLabel.setText("Invalid age!");
                return;
            }
            currentPatient.setAddress(addressField.getText());
            currentPatient.setContact(contactField.getText());

            // Update password if provided
            String newPassword = newPasswordField.getText();
            if (newPassword != null && !newPassword.isEmpty()) {
                currentPatient.setPassword(newPassword);
            }

            boolean updated = patientService.updatePatient(currentPatient);
            if (updated) {
                feedbackLabel.setText("Profile updated successfully!");
            } else {
                feedbackLabel.setText("Profile update failed.");
            }
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
