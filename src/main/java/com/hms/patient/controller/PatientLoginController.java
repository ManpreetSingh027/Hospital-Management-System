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

public class PatientLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private PatientService patientService = new PatientService();

    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if(username.isEmpty() || password.isEmpty()){
            errorLabel.setText("Please enter username and password.");
            return;
        }

        // Retrieve the patient from the database
        Patient patient = patientService.getPatientByUsername(username);
        if(patient != null && patient.getPassword().equals(password)){
            // Successful login: set the logged-in patient in session
            PatientSession.setLoggedInPatient(patient);
            try {
                // Navigate to Patient Dashboard
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
                Stage stage = (Stage) usernameField.getScene().getWindow();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Patient Dashboard");
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Invalid credentials. Please try again.");
        }
    }
}
