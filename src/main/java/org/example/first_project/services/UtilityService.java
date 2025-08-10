package org.example.first_project.services;

import org.example.first_project.models.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UtilityService {
    // Authentication & Authorization
    User authenticateUser(String username, String password);
    void logout(String userId);
    boolean validateToken(String token);
    boolean hasPermission(String userId, String operation);
    void updateLastLogin(String userId);
    void resetPassword(String userId, String newPassword);

    // Notification Management
    void sendEmail(String to, String subject, String content);
    void sendSMS(String phoneNumber, String message);
    void sendPushNotification(String userId, String title, String message);
    void scheduleNotification(String userId, String message, LocalDateTime scheduledTime);
    List<String> getPendingNotifications(String userId);

    // System Logging
    void logSystemError(String error, String stackTrace);
    void logUserAction(String userId, String action, String details);
    void logSecurityEvent(String userId, String event, String details);
    List<String> getSystemLogs(LocalDateTime from, LocalDateTime to);
    List<String> getUserActionLogs(String userId);

    // File Management
    String uploadFile(byte[] content, String fileName, String type);
    byte[] downloadFile(String fileId);
    void deleteFile(String fileId);
    List<String> getFileList(String userId, String type);
    String getFileUrl(String fileId);

    // Data Export
    byte[] exportToExcel(List<Map<String, Object>> data, List<String> headers);
    byte[] exportToPDF(String template, Map<String, Object> data);
    byte[] generateReport(String reportType, Map<String, Object> parameters);
    void scheduleReport(String reportType, String userId, String frequency);
    List<String> getScheduledReports(String userId);

    // System Configuration
    Map<String, String> getSystemConfig();
    void updateSystemConfig(String key, String value);
    void reloadConfiguration();
    String getConfigValue(String key);
    void setMaintenanceMode(boolean enabled);

    // Cache Management
    void cacheData(String key, Object data, int expiryMinutes);
    Object getCachedData(String key);
    void clearCache(String key);
    void clearAllCache();
    boolean isCacheValid(String key);

    // Validation Utilities
    boolean validateEmail(String email);
    boolean validatePhone(String phone);
    boolean validateNID(String nid);
    boolean validateAddress(String address);
    boolean validateMeterNumber(String meterNumber);

    // Security Utilities
    String encryptData(String data);
    String decryptData(String encryptedData);
    String generateToken(String userId);
    String hashPassword(String password);
    boolean verifyHash(String original, String hashedValue);

    // Metrics Collection
    void recordMetric(String metricName, double value);
    double getMetricAverage(String metricName, LocalDateTime from, LocalDateTime to);
    List<Double> getMetricHistory(String metricName, int limit);
    Map<String, Double> getCurrentMetrics();
    void setMetricAlert(String metricName, double threshold);

    // Integration Utilities
    String callExternalAPI(String endpoint, String method, Map<String, Object> data);
    void syncExternalData(String source);
    String getIntegrationStatus(String integrationId);
    void scheduleDataSync(String source, String frequency);
    Map<String, String> getIntegrationConfig(String integrationId);
}
