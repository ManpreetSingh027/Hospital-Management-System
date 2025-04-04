package com.hms.doctor.controller;

import com.hms.doctor.model.Doctor;
import com.hms.doctor.service.DoctorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class DoctorLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label feedbackLabel;

    private DoctorService doctorService = new DoctorService();

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            feedbackLabel.setText("Please enter both username and password.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Retrieve the doctor by username.
        Doctor doctor = doctorService.getDoctorByUsername(username);
        if (doctor != null) {
            // Check if the entered password matches the stored password.
            if (doctor.getPassword() != null && doctor.getPassword().equals(password)) {
                feedbackLabel.setText("Login successful!");
                feedbackLabel.setStyle("-fx-text-fill: green;");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctor/DoctorDashboardUI.fxml"));
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Doctor Dashboard");
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else {
                feedbackLabel.setText("Invalid credentials. Password does not match.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
            }
        } else {
            feedbackLabel.setText("Invalid credentials. Doctor not found.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CommonMenu.fxml"));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Common Menu");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
