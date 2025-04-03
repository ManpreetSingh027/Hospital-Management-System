package com.hms.appointment.controller;

import com.hms.appointment.service.AppointmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppointmentController {

    @FXML
    private ComboBox<String> patientComboBox;

    @FXML
    private ComboBox<String> doctorComboBox;

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private TextField timeField;

    @FXML
    private TextField reasonField;

    private AppointmentService appointmentService = new AppointmentService();

    // Called automatically after FXML loads
    @FXML
    public void initialize() {
        // For demonstration, we add dummy data.
        ObservableList<String> patients = FXCollections.observableArrayList("Patient A", "Patient B", "Patient C");
        ObservableList<String> doctors = FXCollections.observableArrayList("Dr. Smith", "Dr. Johnson", "Dr. Lee");

        patientComboBox.setItems(patients);
        doctorComboBox.setItems(doctors);
    }

    @FXML
    public void handleScheduleAppointment(ActionEvent event) {
        String patient = patientComboBox.getValue();
        String doctor = doctorComboBox.getValue();
        LocalDate date = appointmentDatePicker.getValue();
        String time = timeField.getText();
        String reason = reasonField.getText();

        if (patient == null || doctor == null || date == null || time.isEmpty() || reason.isEmpty()) {
            System.out.println("Please fill in all fields to schedule the appointment.");
            return;
        }

        // Format the date and time as needed (for demonstration)
        String appointmentDateTime = date.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + time;

        // Call the service to schedule the appointment
        appointmentService.scheduleAppointment(patient, doctor, appointmentDateTime, reason);
    }
}
