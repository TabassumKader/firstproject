package org.example.first_project.models;

public class ManagingDirector extends User {
    private static final String ROLE = "MANAGING_DIRECTOR";
    private String designation;
    private String department;
    private String employeeId;

    public ManagingDirector(String userId, String username, String password) {
        super(userId, username, password, ROLE);
    }

    @Override
    public boolean hasPermission(String operation) {
        // Managing Director has access to all operations
        return true;
    }

    // Getters and setters
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
