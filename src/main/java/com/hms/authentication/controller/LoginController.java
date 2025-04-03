package com.hms.authentication.controller;

import com.hms.authentication.service.AuthService;
import com.hms.user.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Instance of AuthService for login logic
    private AuthService authService = new AuthService();

    // This method will be triggered when the Login button is pressed
    @FXML
    public void handleLogin(ActionEvent event) {
        // Retrieve values from the text fields
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Call the login method in AuthService
        User user = authService.login(username, password);
        if (user != null) {
            try {
                // Determine the UI based on the user's role
                String role = user.getRole().toLowerCase();
                String fxmlPath = "";
                switch (role) {
                    case "admin":
                        // Redirect admin users to the Admin Dashboard
                        fxmlPath = "/fxml/AdminDashboard.fxml";
                        break;
                    // Future cases for doctor, patient, etc.
                    default:
                        errorLabel.setText("User role not recognized.");
                        return;
                }
                // Load the FXML layout for the selected role
                Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
                Stage stage = (Stage) usernameField.getScene().getWindow();
                Scene scene = new Scene(root);
                // Apply the CSS styling from app.css
                scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("Hospital Management System");
                stage.show();
            } catch (Exception e) {
                errorLabel.setText("Error loading the UI: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Invalid credentials. Please try again.");
        }
    }
}
