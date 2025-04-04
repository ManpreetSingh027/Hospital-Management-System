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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PatientRegistrationController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactField;
    @FXML
    private Label feedbackLabel;

    private PatientService patientService = new PatientService();

    @FXML
    public void handleRegister(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String address = addressField.getText().trim();
        String contact = contactField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || ageText.isEmpty() ||
                address.isEmpty() || contact.isEmpty()) {
            feedbackLabel.setText("Please fill in all fields.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Invalid age.");
            return;
        }

        Patient newPatient = new Patient(username, name, age, address, contact, password);
        boolean success = patientService.registerPatient(newPatient);

        if (success) {
            feedbackLabel.setText("Registration successful!");
            // Set the newly registered patient in session for personalized dashboard
            PatientSession.setLoggedInPatient(newPatient);
            // Navigate to Patient Dashboard after successful registration
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
                Stage stage = (Stage) usernameField.getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Patient Dashboard");
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            feedbackLabel.setText("Registration failed. Username might already exist.");
        }
    }

    @FXML
    public void handleGoToLogin(ActionEvent event) {
        // Navigate to the Patient Login page
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientLoginUI.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient Login");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
