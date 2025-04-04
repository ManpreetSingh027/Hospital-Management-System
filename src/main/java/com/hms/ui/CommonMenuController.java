package com.hms.ui;

import com.hms.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CommonMenuController {

    @FXML
    private void handleAdminLogin(ActionEvent event) {
        // Switch to the Admin Login UI (ensure AdminLogin.fxml exists in your resources)
        SceneManager.switchScene("/fxml/LoginApp.fxml");
    }

    @FXML
    private void handlePatientRegistration(ActionEvent event) {
        // Switch to the Patient Registration UI (ensure PatientRegistration.fxml exists)
        SceneManager.switchScene("/fxml/patient/PatientRegistrationUI.fxml");
    }

    @FXML
    private void handleDoctorLogin(ActionEvent event) {
        // Switch to the Doctor Login UI (ensure DoctorLogin.fxml exists)
        SceneManager.switchScene("/fxml/DoctorLogin.fxml");
    }
}
