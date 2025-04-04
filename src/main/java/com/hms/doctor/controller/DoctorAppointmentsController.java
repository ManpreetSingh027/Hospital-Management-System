package com.hms.doctor.controller;

import com.hms.appointment.model.Appointment;
import com.hms.appointment.service.AppointmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorAppointmentsController implements Initializable {

    @FXML
    private TableView<Appointment> appointmentsTable;

    @FXML
    private TableColumn<Appointment, Integer> idColumn;

    @FXML
    private TableColumn<Appointment, String> patientColumn;

    @FXML
    private TableColumn<Appointment, String> dateColumn;

    @FXML
    private TableColumn<Appointment, String> timeColumn;

    @FXML
    private TableColumn<Appointment, String> reasonColumn;

    @FXML
    private TableColumn<Appointment, String> statusColumn;

    @FXML
    private TableColumn<Appointment, Void> actionColumn;

    private AppointmentService appointmentService = new AppointmentService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patient"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAppointments();
        addActionButtonToTable();
    }

    private void loadAppointments() {
        // For demonstration, we assume the logged-in doctor's username is "drsmith".
        // In a real application, retrieve it from a session variable.
        String doctorUsername = "drsmith";
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorUsername);
        // If appointments is null, use an empty ArrayList.
        ObservableList<Appointment> list = FXCollections.observableArrayList(appointments != null ? appointments : new ArrayList<>());
        appointmentsTable.setItems(list);
    }

    private void addActionButtonToTable() {
        Callback<TableColumn<Appointment, Void>, javafx.scene.control.TableCell<Appointment, Void>> cellFactory = new Callback<>() {
            @Override
            public javafx.scene.control.TableCell<Appointment, Void> call(final TableColumn<Appointment, Void> param) {
                final javafx.scene.control.TableCell<Appointment, Void> cell = new javafx.scene.control.TableCell<>() {
                    private final javafx.scene.control.Button btn = new javafx.scene.control.Button("Update");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Appointment appointment = getTableView().getItems().get(getIndex());
                            handleUpdateAppointment(appointment);
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                };
                return cell;
            }
        };
        actionColumn.setCellFactory(cellFactory);
    }

    private void handleUpdateAppointment(Appointment appointment) {
        // For demonstration, update the appointment status to "Completed"
        appointment.setStatus("Completed");
        boolean updated = appointmentService.updateAppointment(appointment);
        if (updated) {
            // Refresh the table
            loadAppointments();
        }
    }

    @FXML
    public void handleBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/doctor/DoctorDashboardUI.fxml"));
            Stage stage = (Stage) appointmentsTable.getScene().getWindow();
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
