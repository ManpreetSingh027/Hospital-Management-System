package com.hms.user.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportsDashboardController {

    // Navigates to the Patient History Report screen
    public void handlePatientHistoryReport(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientHistoryReport.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient History Report");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates to the Billing Report screen
    public void handleBillingReport(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/BillingReport.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Billing Report");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
