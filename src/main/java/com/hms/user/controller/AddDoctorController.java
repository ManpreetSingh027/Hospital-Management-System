package com.hms.user.controller;

import com.hms.doctor.model.Doctor;
import com.hms.doctor.service.DoctorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AddDoctorController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField specializationField;

    @FXML
    private TextField availabilityField;

    // New field for password input
    @FXML
    private TextField passwordField;

    @FXML
    private Label messageLabel;

    private DoctorService doctorService = new DoctorService();

    @FXML
    private void handleAddDoctor(ActionEvent event) {
        String name = nameField.getText().trim();
        String specialization = specializationField.getText().trim();
        String availability = availabilityField.getText().trim();
        String password = passwordField.getText().trim();

        // Basic validation
        if (name.isEmpty() || specialization.isEmpty() || availability.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Generate a dummy username for demonstration purposes.
        String username = "dr" + System.currentTimeMillis();

        // Create a new Doctor with the updated constructor including password.
        Doctor doctor = new Doctor(username, name, specialization, availability, password);

        boolean success = doctorService.addDoctor(doctor);
        if (success) {
            messageLabel.setText("Doctor added successfully!");
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            messageLabel.setText("Failed to add doctor.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }

        // Optionally clear the fields after adding
        nameField.clear();
        specializationField.clear();
        availabilityField.clear();
        passwordField.clear();
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminDashboard.fxml"));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
