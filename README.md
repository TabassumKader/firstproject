# Titas Gas Management System

A comprehensive JavaFX application for managing gas company operations with separate dashboards for Managing Directors and Domestic Customers.

## Project Overview

This JavaFX application implements a gas company management system with two main user types:

### Managing Director Dashboard
- **Goal 1**: Monitor Operational Dashboard
- **Goal 2**: Approve Budget for Network
- **Goal 3**: Review Monthly Performance Report
- **Goal 4**: Overseas Emergency Incident
- **Goal 5**: Authorize High-Value Procurement
- **Goal 6**: Review Stakeholder Feedback
- **Goal 7**: Assign Strategic Objectives
- **Goal 8**: Approve Organizational Policy

### Domestic Customer Dashboard
- **Goal 1**: Apply for New Gas Connection
- **Goal 2**: Pay Monthly Gas Bill
- **Goal 3**: Submit a Service Complaint
- **Goal 4**: Track Connection Status
- **Goal 5**: Update Customer Profile
- **Goal 6**: Book a Technician Visit
- **Goal 7**: Request Billing Clarification
- **Goal 8**: Download Connection Certificate

## Features

### Login System
- User authentication with role-based access
- Separate dashboards for different user types
- Secure login with username/password validation

### Interactive Dashboards
- Modern, responsive UI design
- Grid-based layout for easy navigation
- Color-coded goal categories
- Real-time data visualization

### Goal-Specific Functionality
- **Operational Dashboard**: Real-time monitoring with filters
- **Budget Approval**: Table-based proposal management
- **Gas Connection Application**: Form-based application with file upload
- **Bill Payment**: Payment processing with multiple payment methods
- **Complaint Management**: Service request submission
- **Document Management**: File upload and download capabilities

## Technical Architecture

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── org/example/first_project/
│   │       ├── HelloApplication.java          # Main application entry point
│   │       ├── LoginController.java           # Login functionality
│   │       ├── DirectorDashboardController.java    # Director dashboard
│   │       ├── CustomerDashboardController.java    # Customer dashboard
│   │       ├── DirectorGoal1Controller.java   # Goal-specific controllers
│   │       ├── DirectorGoal2Controller.java
│   │       ├── CustomerGoal1Controller.java
│   │       ├── CustomerGoal2Controller.java
│   │       └── ... (additional goal controllers)
│   └── resources/
│       └── org/example/first_project/
│           ├── login-view.fxml               # Login screen
│           ├── director-dashboard.fxml       # Director dashboard
│           ├── customer-dashboard.fxml       # Customer dashboard
│           ├── director-goal1.fxml          # Goal-specific FXML files
│           ├── director-goal2.fxml
│           ├── customer-goal1.fxml
│           ├── customer-goal2.fxml
│           └── ... (additional goal FXML files)
```

### Technologies Used
- **JavaFX 21**: Modern UI framework
- **Maven**: Build and dependency management
- **FXML**: Declarative UI design
- **CSS Styling**: Custom styling for modern appearance

## Installation and Setup

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher
- JavaFX SDK (included in project dependencies)

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd firstproject
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn javafx:run
   ```

### Login Credentials

#### Managing Director
- **Username**: director
- **Password**: password

#### Domestic Customer
- **Username**: customer
- **Password**: password

## Usage Guide

### For Managing Directors

1. **Login** with director credentials
2. **Navigate** to the desired goal from the dashboard
3. **Monitor** operational metrics and KPIs
4. **Approve** budgets and proposals
5. **Review** reports and performance data

### For Domestic Customers

1. **Login** with customer credentials
2. **Access** customer services from the dashboard
3. **Apply** for new gas connections
4. **Pay** monthly bills online
5. **Submit** service complaints
6. **Track** application status

## Key Features Implemented

### 1. Operational Dashboard (Director Goal 1)
- Real-time data visualization
- Filter by division, timeframe, and department
- Interactive metrics display
- Performance monitoring

### 2. Budget Approval (Director Goal 2)
- Table-based proposal management
- Approval workflow
- Digital signature support
- Remarks and comments system

### 3. Gas Connection Application (Customer Goal 1)
- Comprehensive application form
- Document upload functionality
- Form validation
- Application ID generation

### 4. Bill Payment (Customer Goal 2)
- Multiple payment methods
- Payment history tracking
- Transaction processing
- Receipt generation

## Development Status

### Completed Features
- ✅ Login system with role-based access
- ✅ Dashboard navigation
- ✅ Goal 1 & 2 for both user types (fully implemented)
- ✅ Basic structure for all remaining goals
- ✅ Modern UI design with responsive layout

### In Development
- 🔄 Goal 3-8 detailed implementations
- 🔄 Advanced data visualization
- 🔄 Database integration
- 🔄 Real-time notifications

### Planned Features
- 📋 Advanced reporting and analytics
- 📋 Mobile-responsive design
- 📋 Multi-language support
- 📋 Integration with external payment gateways
- 📋 Advanced security features

## Contributing

1. Fork the repository
2. Create a feature branch
3. Implement your changes
4. Add appropriate tests
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please contact the development team or create an issue in the repository.

---

**Note**: This is an undergraduate-level OOP project demonstrating JavaFX application development with modern UI/UX principles and object-oriented programming concepts.
