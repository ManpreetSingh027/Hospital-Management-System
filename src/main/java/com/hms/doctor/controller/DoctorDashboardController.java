package com.hms.doctor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoctorDashboardController {

    @FXML
    public void handlePatientRecords(ActionEvent event) {
        loadUI("/fxml/doctor/DoctorPatientRecordsUI.fxml", "Patient Records");
    }

    @FXML
    public void handleManageAppointments(ActionEvent event) {
        loadUI("/fxml/doctor/DoctorAppointmentsUI.fxml", "Manage Appointments & Treatments");
    }

    @FXML
    public void handlePrescribeMedications(ActionEvent event) {
        loadUI("/fxml/doctor/PrescribeMedicationsUI.fxml", "Prescribe Medications");
    }

    @FXML
    public void handleManageProfile(ActionEvent event) {
        loadUI("/fxml/doctor/DoctorProfileUI.fxml", "Manage Profile & Availability");
    }

    private void loadUI(String fxmlPath, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            // Get the current stage from the loaded root node's scene
            Stage stage = new Stage();
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
