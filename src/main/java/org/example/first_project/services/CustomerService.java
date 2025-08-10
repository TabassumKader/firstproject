package org.example.first_project.services;

import org.example.first_project.models.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CustomerService {
    // Connection Management
    void applyNewConnection(String customerId, String address, String zone);
    String getConnectionStatus(String customerId);
    void requestDisconnection(String customerId, String reason);
    void updateConnectionDetails(String customerId, String address);
    
    // Bill Management
    List<Bill> getCustomerBills(String customerId);
    Bill getCurrentBill(String customerId);
    List<Bill> getUnpaidBills(String customerId);
    void payBill(String billId, String paymentMethod);
    Bill getBillDetails(String billId);
    List<Bill> getBillHistory(String customerId, LocalDate from, LocalDate to);
    double calculateAverageMonthlyBill(String customerId);

    // Complaint Management
    Complaint submitComplaint(String customerId, String category, String description);
    List<Complaint> getCustomerComplaints(String customerId);
    Complaint getComplaintDetails(String complaintId);
    void updateComplaint(String complaintId, String additionalInfo);
    void provideFeedback(String complaintId, String feedback, int satisfaction);
    List<Complaint> getActiveComplaints(String customerId);

    // Service Requests
    String bookTechnician(String customerId, LocalDateTime preferredTime, String issue);
    List<String> getAvailableTimeSlots(LocalDate date);
    void cancelTechnicianBooking(String bookingId);
    void rescheduleTechnicianVisit(String bookingId, LocalDateTime newTime);
    List<String> getTechnicianVisitHistory(String customerId);

    // Meter Management
    Meter getMeterDetails(String customerId);
    List<Double> getMeterReadings(String customerId, LocalDate from, LocalDate to);
    void reportMeterIssue(String customerId, String issue);
    double getCurrentReading(String customerId);
    List<Double> getConsumptionHistory(String customerId, int months);

    // Profile Management
    DomesticCustomer getCustomerProfile(String customerId);
    void updateProfile(String customerId, DomesticCustomer updatedProfile);
    void updateContactInfo(String customerId, String email, String phone);
    void changePassword(String customerId, String oldPassword, String newPassword);
    List<String> getNotificationPreferences(String customerId);
    void updateNotificationPreferences(String customerId, List<String> preferences);

    // Document Management
    List<String> getAvailableDocuments(String customerId);
    byte[] downloadDocument(String documentId);
    void uploadDocument(String customerId, String documentType, byte[] content);
    List<String> getRequiredDocuments(String customerId);
    boolean verifyDocument(String documentId);

    // Support Services
    List<String> getFAQs();
    List<String> getAnnouncements();
    void submitFeedback(String customerId, String feedback);
    String getEmergencyContact(String zoneId);
    List<String> getSafetyGuidelines();

    // Usage Analytics
    double getDailyAverageConsumption(String customerId);
    double getMonthlyAverageConsumption(String customerId);
    List<String> getConsumptionTips();
    byte[] generateUsageReport(String customerId, LocalDate from, LocalDate to);
    List<String> getEfficiencyRecommendations(String customerId);

    // Payment Management
    List<String> getPaymentMethods();
    String initiatePayment(String billId, double amount, String paymentMethod);
    String getPaymentStatus(String paymentId);
    void savePaymentMethod(String customerId, String paymentMethod, String details);
    List<String> getPaymentHistory(String customerId);
}
