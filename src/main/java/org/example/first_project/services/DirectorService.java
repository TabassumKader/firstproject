package org.example.first_project.services;

import org.example.first_project.models.*;
import java.time.LocalDateTime;
import java.util.List;

public interface DirectorService {
    // Dashboard Operations
    List<Zone> getAllZones();
    List<GasSupply> getSupplyStatus();
    double getOverallSystemEfficiency();
    int getTotalCustomers();
    double getTotalRevenue();

    // Budget Management
    Budget createBudget(String title, String department, double amount);
    void approveBudget(String budgetId);
    void rejectBudget(String budgetId, String reason);
    List<Budget> getPendingBudgets();
    Budget getBudgetDetails(String budgetId);
    List<Budget> getBudgetsByDepartment(String department);

    // Performance Monitoring
    List<Zone> getUnderperformingZones();
    List<GasSupply> getSupplyIssues();
    List<Complaint> getUnresolvedComplaints();
    double getCustomerSatisfactionRate();
    List<Budget> getOverBudgetDepartments();

    // Emergency Management
    List<Incident> getActiveIncidents();
    Incident createEmergencyIncident(String type, String location, String description);
    void escalateIncident(String incidentId, String reason);
    void resolveIncident(String incidentId, String resolution);
    List<Incident> getIncidentHistory(LocalDateTime from, LocalDateTime to);

    // Policy Management
    Policy createPolicy(String title, String description, String category);
    void approvePolicy(String policyId);
    void rejectPolicy(String policyId, String reason);
    List<Policy> getPendingPolicies();
    List<Policy> getActivePolicies();

    // System Monitoring
    List<GasSupply> getLowPressureAreas();
    List<Zone> getMaintenanceSchedule();
    List<SupplyAlert> getActiveAlerts();
    void scheduleSystemMaintenance(String zoneId, String description);
    void updateSystemStatus(String zoneId, String status);

    // Report Generation
    byte[] generateMonthlyReport(int month, int year);
    byte[] generatePerformanceReport(String department, LocalDateTime from, LocalDateTime to);
    byte[] generateIncidentReport(String incidentId);
    byte[] generateBudgetReport(String budgetId);
    byte[] generateSystemStatusReport();

    // Customer Management
    List<DomesticCustomer> getCustomersByZone(String zoneId);
    List<Bill> getUnpaidBills();
    void approveConnection(String customerId);
    void disconnectCustomer(String customerId, String reason);
    List<Complaint> getCustomerComplaints(String customerId);

    // Procurement Management
    void approveProcurement(String budgetItemId);
    void rejectProcurement(String budgetItemId, String reason);
    List<Budget.BudgetItem> getPendingProcurements();
    double getTotalProcurementCost(LocalDateTime from, LocalDateTime to);
    
    // Analytics
    double calculateRevenueGrowth(int months);
    double calculateCustomerGrowth(int months);
    List<String> getTopPerformingZones(int limit);
    List<String> getMostReportedIssues(int limit);
    double getSystemEfficiencyTrend(int months);
}
