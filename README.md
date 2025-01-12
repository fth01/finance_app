# Finance App Project

This is a test automation project implemented using Java, Selenium WebDriver, Cucumber, JUnit, and Page Object Model. The tests are designed to be executed on web applications, and the results are reported in both HTML and Cucumber-specific formats.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Reports](#reports)
- [License](#license)

---

## Project Overview

This test automation framework allows for the efficient and scalable automation of 
finance app testing using Java with Selenium WebDriver, and Cucumber for behavior-driven development (BDD). It follows the Page Object Model (POM) design pattern for better maintainability and reusability of code. The test results are captured and presented in HTML and Cucumber-specific report formats, providing clear and detailed feedback about the test execution.

---

## Technologies Used

- **Java**: Programming language for writing test scripts.
- **Selenium WebDriver**: A tool for automating web browser interactions.
- **Cucumber**: A BDD framework for writing tests in a human-readable format.
- **JUnit**: A testing framework used for running and managing tests.
- **Page Object Model (POM)**: A design pattern for organizing and maintaining test scripts.
- **Maven**: Build automation tool for managing dependencies and building the project.
- **HTML Report**: For generating readable test execution reports.
- **Cucumber Report**: For generating detailed Cucumber execution reports.

---

## Installation

### Prerequisites

Before you begin, ensure you have the following installed on your machine:

- **Java 17+**: Download and install Java from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven**: Download and install Maven from [here](https://maven.apache.org/download.cgi).
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE of your choice.

### Steps to Install

1. **Clone the Repository**

   Clone the repository to your local machine:
   ```bash
   git clone https://github.com/fth01/finance_app.git

2. **Navigate to Project Directory**

   Open a terminal/command prompt and navigate to the project directory:
   ```bash
   cd finance_app

3. **Build the project**

   Open a terminal/command prompt and navigate to the project directory:
   ```bash
   mvn clean install

---  
## Project Structure
   ```
finance_app
│
├── src
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── app
|   |               └── pages              # Page Object Models (POM)
│   │               └── runners            # Cucumber Test Runner
│   │               └── step_definitions   # Cucumber Step Definitions
│   │               └── utils              # Utility classes
│   │
│   └── resources
│       └── features                         # Cucumber feature files
│       └── configuration                    # Config files
│
├── target                                    # Compiled and test results
│   ├── cucumber-reports                      # Cucumber report files
│   ├── surefire-reports                      # JUnit test results
│   └── html-reports                          # HTML formatted reports
│
└── pom.xml                                   # Maven project configuration file
```
### Key Folders

- **`src/test/java/com/app/pages`**: Contains the Page Object Models (POM), which define the web elements and interactions for each page of the application under test.

- **`src/tesst/java/com/app/step_definitions`**: Contains the step definition classes for Cucumber, where actual WebDriver interactions and test logic are implemented.

- **`src/test/java/com/app/utils`**: Utility classes for common functions.

- **`src/test/resources/features`**: Contains Cucumber feature files written in Gherkin syntax, where the behavior of the system is defined.

- **`src/test/java/com/automation/runner`**: Contains the Cucumber Test Runner class that integrates with JUnit for execution.

- **`target`**: Contains generated reports and test execution outputs.

---
## Running Tests

### From the Command Line
1. **Run Tests with Maven:** To run all tests and generate reports, use the following command

   ```bash
   mvn clean verify

This will execute the tests and generate both Cucumber and Htmal reports in the **`target`** folder

2. **Run Tests for a Specific Feature:** If you want to run a specific feature file, you can use:

   ```bash
   mvn clean verify -Dcucumber.options="src/test/resources/features/<featureFile>.feature"

3. **Run Tests for a Specific Taf:** If you want to run a specific tag, you can use:

   ```bash
   mvn clean verify -D"cucumber.filter.tags=@tagName"
   
### From IDE
1. **Run the Cucumber Test Runner:** In your IDE, locate the test runner class **`TestRunner.java`** under src/test/java/com/app/runners.
Right-click the class and select Run to execute all tests or specific tests.

---

## Reports

### Cucumber Report
- A detailed JSON report is generated after each test run in `target/cucumber-reports/cucumber.json`.
- This report provides a detailed execution summary including passed, failed, and skipped scenarios, along with their respective steps.

### HTML Report
- A user-friendly, detailed HTML report is generated in `target/default-html-reports/index.html` after running the tests.
- The HTML report provides a comprehensive, visual representation of test execution with details such as:
   - Scenarios executed
   - Test status (passed, failed, skipped)
   - Execution time
   - Step-wise information
- To view the HTML report, simply open html in a web browser.
