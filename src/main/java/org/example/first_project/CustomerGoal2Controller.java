package org.example.first_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerGoal2Controller {
    
    @FXML
    private Label customerIdLabel;
    
    @FXML
    private Label billMonthLabel;
    
    @FXML
    private Label dueDateLabel;
    
    @FXML
    private Label usageLabel;
    
    @FXML
    private Label amountLabel;
    
    @FXML
    private TableView<PaymentHistory> historyTable;
    
    @FXML
    private TableColumn<PaymentHistory, String> monthColumn;
    
    @FXML
    private TableColumn<PaymentHistory, String> amountColumn;
    
    @FXML
    private TableColumn<PaymentHistory, String> statusColumn;
    
    @FXML
    private RadioButton mobileBankingRadio;
    
    @FXML
    private RadioButton creditCardRadio;
    
    @FXML
    private RadioButton bankTransferRadio;
    
    @FXML
    private RadioButton cashRadio;
    
    @FXML
    private TextField paymentAmountField;
    
    @FXML
    private TextField transactionIdField;
    
    @FXML
    public void initialize() {
        // Set up table columns
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        // Load payment history
        loadPaymentHistory();
        
        // Set up radio button group
        ToggleGroup paymentGroup = new ToggleGroup();
        mobileBankingRadio.setToggleGroup(paymentGroup);
        creditCardRadio.setToggleGroup(paymentGroup);
        bankTransferRadio.setToggleGroup(paymentGroup);
        cashRadio.setToggleGroup(paymentGroup);
    }
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) customerIdLabel.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void calculateBill() {
        // Simulate bill calculation
        String message = "Bill Calculation:\n\n" +
                "Gas Usage: 45.5 cubic meters\n" +
                "Rate per unit: 25 BDT\n" +
                "Service Charge: 50 BDT\n" +
                "VAT (5%): 62.5 BDT\n\n" +
                "Total Amount: 1,250 BDT";
        
        showAlert("Bill Calculation", message);
    }
    
    @FXML
    private void payBill() {
        if (paymentAmountField.getText().trim().isEmpty()) {
            showAlert("Error", "Please enter the payment amount.");
            return;
        }
        
        if (transactionIdField.getText().trim().isEmpty()) {
            showAlert("Error", "Please enter the transaction ID.");
            return;
        }
        
        String paymentMethod = getSelectedPaymentMethod();
        if (paymentMethod == null) {
            showAlert("Error", "Please select a payment method.");
            return;
        }
        
        // Simulate payment processing
        String transactionId = "TXN" + System.currentTimeMillis();
        
        String message = "Payment Successful!\n\n" +
                "Transaction ID: " + transactionId + "\n" +
                "Amount Paid: " + paymentAmountField.getText() + " BDT\n" +
                "Payment Method: " + paymentMethod + "\n" +
                "Date: " + java.time.LocalDate.now() + "\n\n" +
                "Receipt has been sent to your email.\n" +
                "Thank you for your payment!";
        
        showAlert("Payment Success", message);
        
        // Clear form
        paymentAmountField.clear();
        transactionIdField.clear();
        
        // Update payment history
        updatePaymentHistory();
    }
    
    private String getSelectedPaymentMethod() {
        if (mobileBankingRadio.isSelected()) return "Mobile Banking";
        if (creditCardRadio.isSelected()) return "Credit/Debit Card";
        if (bankTransferRadio.isSelected()) return "Bank Transfer";
        if (cashRadio.isSelected()) return "Cash Payment";
        return null;
    }
    
    private void loadPaymentHistory() {
        ObservableList<PaymentHistory> history = FXCollections.observableArrayList(
            new PaymentHistory("November 2024", "1,180 BDT", "Paid"),
            new PaymentHistory("October 2024", "1,150 BDT", "Paid"),
            new PaymentHistory("September 2024", "1,200 BDT", "Paid"),
            new PaymentHistory("August 2024", "1,100 BDT", "Paid"),
            new PaymentHistory("July 2024", "1,300 BDT", "Paid")
        );
        
        historyTable.setItems(history);
    }
    
    private void updatePaymentHistory() {
        // Add current payment to history
        PaymentHistory currentPayment = new PaymentHistory(
            billMonthLabel.getText(), 
            amountLabel.getText(), 
            "Paid"
        );
        
        historyTable.getItems().add(0, currentPayment);
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    // Inner class for payment history data
    public static class PaymentHistory {
        private String month;
        private String amount;
        private String status;
        
        public PaymentHistory(String month, String amount, String status) {
            this.month = month;
            this.amount = amount;
            this.status = status;
        }
        
        // Getters
        public String getMonth() { return month; }
        public String getAmount() { return amount; }
        public String getStatus() { return status; }
    }
}
