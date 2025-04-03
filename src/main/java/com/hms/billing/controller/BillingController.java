package com.hms.billing.controller;

import com.hms.billing.model.Bill;
import com.hms.billing.service.BillingService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BillingController implements Initializable {

    @FXML
    private TableView<Bill> billingTable;

    @FXML
    private TableColumn<Bill, Integer> billIdColumn;

    @FXML
    private TableColumn<Bill, String> patientColumn;

    @FXML
    private TableColumn<Bill, Double> amountColumn;

    @FXML
    private TableColumn<Bill, String> dateColumn;

    @FXML
    private TextField patientField;

    @FXML
    private TextField amountField;

    @FXML
    private TextField dateField;

    private BillingService billingService = new BillingService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bind table columns to Bill properties
        billIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patient"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Load existing bills into the table
        loadBillingData();
    }

    private void loadBillingData() {
        List<Bill> bills = billingService.getAllBills();
        ObservableList<Bill> billList = FXCollections.observableArrayList(bills != null ? bills : FXCollections.emptyObservableList());
        billingTable.setItems(billList);
    }


    @FXML
    public void handleAddBill(ActionEvent event) {
        // Get input values
        String patient = patientField.getText();
        String amountText = amountField.getText();
        String date = dateField.getText();

        // Basic validation
        if (patient.isEmpty() || amountText.isEmpty() || date.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);
            // Create a new bill and add it via the service
            Bill newBill = new Bill(0, patient, amount, date);
            billingService.addBill(newBill);
            // Refresh the table
            loadBillingData();
            // Clear input fields
            patientField.clear();
            amountField.clear();
            dateField.clear();
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a valid number.");
        }
    }
}
