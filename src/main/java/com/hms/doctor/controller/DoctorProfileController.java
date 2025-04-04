package com.hms.doctor.controller;

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

public class DoctorProfileController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField specializationField;
    @FXML
    private TextField availabilityField;
    @FXML
    private Label feedbackLabel;

    private DoctorService doctorService = new DoctorService();
    private Doctor currentDoctor;

    @FXML
    public void initialize() {
        // For demonstration, load a dummy doctor; replace with actual logged-in doctor.
        currentDoctor = doctorService.getDoctorByUsername("drsmith");
        if (currentDoctor != null) {
            nameField.setText(currentDoctor.getName());
            specializationField.setText(currentDoctor.getSpecialization());
            availabilityField.setText(currentDoctor.getAvailability());
        }
    }

    @FXML
    public void handleUpdateProfile(ActionEvent event) {
        if (currentDoctor != null) {
            currentDoctor.setName(nameField.getText());
            currentDoctor.setSpecialization(specializationField.getText());
            currentDoctor.setAvailability(availabilityField.getText());

            // Now updateDoctor returns a boolean indicating success/failure.
            boolean updated = doctorService.updateDoctor(currentDoctor);
            if (updated) {
                feedbackLabel.setText("Profile updated successfully!");
                feedbackLabel.setStyle("-fx-text-fill: green;");
            } else {
                feedbackLabel.setText("Profile update failed.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctor/DoctorDashboardUI.fxml"));
            Stage stage = (Stage) nameField.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Doctor Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
