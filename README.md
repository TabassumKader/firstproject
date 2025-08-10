# Titas Gas Management System

A comprehensive JavaFX-based gas utility management system for Titas Gas with multiple user roles and detailed workflows. This system provides efficient management of gas distribution, customer service, billing, and system monitoring.

## Features

### Managing Director Dashboard
- Operational monitoring and analytics
- Budget approval system
- Performance reporting
- Emergency incident management
- Policy management
- System monitoring

### Domestic Customer Portal
- Bill payment system
- Service complaint management
- Technician booking
- Usage monitoring
- Profile management
- Document management

## Technical Stack

- Java 21
- JavaFX 21
- Maven
- JUnit 5
- SLF4J & Logback
- Google Guava
- Apache Commons Lang

## Project Structure

```
src/main/java/
├── org.example.first_project/
│   ├── models/           # Domain models
│   ├── services/         # Service interfaces
│   ├── controllers/      # JavaFX controllers
│   └── TitasGasApp.java  # Main application
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 21 or later
- Maven 3.6 or later
- Git

### Installation

1. Clone the repository:
```bash
git clone https://github.com/TabassumKader/firstproject.git
cd firstproject
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn javafx:run
```

## Development Setup

1. Install required software:
   - JDK 17 or later
   - Maven
   - Your preferred IDE (VS Code, IntelliJ IDEA, etc.)

2. Import the project:
   - For VS Code: Install Java and JavaFX extensions
   - For IntelliJ IDEA: Open as Maven project

3. Configure JDK:
   - Ensure project SDK is set to JDK 21
   - Configure Maven to use JDK 21

## Usage

1. Launch the application
2. Login with appropriate credentials:
   - Managing Director access
   - Customer access

### Managing Director Operations
- View operational dashboard
- Manage budgets and policies
- Handle emergencies
- Monitor system performance
- Generate reports

### Customer Operations
- View and pay bills
- Submit complaints
- Book technician visits
- Monitor gas consumption
- Manage documents

## Testing

Run the test suite:
```bash
mvn test
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Project Status

Under active development. Current version: 1.0-SNAPSHOT

## Future Enhancements

- Integration with payment gateways
- Mobile application development
- Real-time monitoring system
- Advanced analytics dashboard
- SMS notification system

## License

This project is proprietary software for Titas Gas Transmission and Distribution Company Limited.
