package com.hms.patient.controller;

import com.hms.appointment.model.Appointment;
import com.hms.appointment.service.AppointmentService;
import com.hms.patient.model.Patient;
import com.hms.patient.util.PatientSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class PatientAppointmentRequestController {

    @FXML
    private DatePicker preferredDatePicker;

    @FXML
    private ComboBox<String> preferredTimeComboBox;

    @FXML
    private ComboBox<String> doctorComboBox;

    @FXML
    private TextArea reasonTextArea;

    @FXML
    private Label feedbackLabel;

    private AppointmentService appointmentService = new AppointmentService();

    @FXML
    public void initialize() {
        // Populate time slots for demonstration (or fetch dynamically from service)
        ObservableList<String> times = FXCollections.observableArrayList("09:00", "10:00", "11:00", "14:00", "15:00", "16:00");
        preferredTimeComboBox.setItems(times);

        // Populate doctor list for demonstration (or fetch dynamically from service)
        ObservableList<String> doctors = FXCollections.observableArrayList("Dr. Smith", "Dr. Johnson", "Dr. Lee");
        doctorComboBox.setItems(doctors);
    }

    @FXML
    public void handleSubmitRequest(ActionEvent event) {
        LocalDate date = preferredDatePicker.getValue();
        String timeStr = preferredTimeComboBox.getValue();
        String doctor = doctorComboBox.getValue();
        String reason = reasonTextArea.getText();

        if (date == null || timeStr == null || doctor == null || reason.isEmpty()) {
            feedbackLabel.setText("Please fill in all fields.");
            return;
        }

        LocalTime time;
        try {
            time = LocalTime.parse(timeStr);
        } catch (Exception e) {
            feedbackLabel.setText("Invalid time format.");
            return;
        }

        // Retrieve the logged-in patient from session
        Patient patient = PatientSession.getLoggedInPatient();
        String patientUsername = (patient != null) ? patient.getUsername() : "unknown";

        // Create a new Appointment with default status "Scheduled"
        Appointment appointment = new Appointment(patientUsername, doctor, date, time, reason, "Scheduled");
        appointmentService.scheduleAppointment(appointment);

        feedbackLabel.setText("Appointment request submitted successfully!");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/patient/PatientDashboard.fxml"));
            Stage stage = (Stage) preferredDatePicker.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/app.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
