package com.hms.user.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminDashboardController {

    // Navigates to the Add User UI
    public void handleAddUser(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddUserUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Add User");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates to the Add Doctor UI
    public void handleAddDoctor(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddDoctorUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Add Doctor");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates to the Delete Doctor UI


    // Navigates to the Doctor List UI
    public void handleDoctorList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/DoctorListUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Doctor List");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates to the Patient List UI
    public void handlePatientList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientListUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient List");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates to the Reports Dashboard
    public void handleReports(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ReportsDashboard.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Reports Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    // Navigates to the Billing UI
    public void handleBilling(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/BillingUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Billing Module");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Navigates back to the Common Menu
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginApp.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Admin Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
