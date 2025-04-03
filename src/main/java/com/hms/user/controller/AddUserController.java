package com.hms.user.controller;

import com.hms.user.model.User;
import com.hms.user.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField roleField;

    @FXML
    private Label feedbackLabel;

    // Create an instance of UserService to handle DB operations
    private UserService userService = new UserService();

    // This method is triggered when the "Add User" button is clicked
    @FXML
    public void handleAddUser(ActionEvent event) {
        // Get values from the input fields
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleField.getText();

        // Simple validation: Ensure no field is empty
        if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
            feedbackLabel.setText("Please fill in all fields.");
            return;
        }

        // Create a new User object and add it using the service
        User newUser = new User(username, password, role);
        userService.addUser(newUser);
        feedbackLabel.setText("User added successfully!");
    }
}
