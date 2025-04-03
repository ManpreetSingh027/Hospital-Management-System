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

    // Navigates to the View Users UI
    public void handleViewUsers(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewUsersUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("View Users");
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
    public void handleAssignStaff(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AssignStaffUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Assign Staff to Patient");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void handleAppointments(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AppointmentUI.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Manage Appointments");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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


}
