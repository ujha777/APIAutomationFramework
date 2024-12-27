
# API Test Automation Framework

This is a Java-based test API automation framework.

The framework leverages various libraries and tools to facilitate  logging, reporting, and integration with filters.


## Authors

- [@ujha77](https://github.com/ujha777/ujha777)
- EmailAddress:jhagangeshgunjan@gmail.com




## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gangesh123jha/)



## 🚀 About Me
Hi, My Name is Gangesh Gunjan Jha and I have 6+ years of experience in Automation Testing using technologies like Selenium Webdriver, RestAssured.

My major expertise is in Java Programming Language.


## Prerequisites
Before running this framework, ensure the following software is installed on your system:

- **Java 11** - Make sure Java is installed and the JAVA_HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.
- **Download Link**: https://maven.apache.org/download.cgi


## Features

- **Automated API testing using RestAssured
- **Detailed test reports with ExtentReports
- **Logging**: Uses Log4j for detailed logs.
- **Easy configuration and setup
- **Customizable test cases
- **Integrated Filters with Extent Reports

## Technologies Used
- Java 11
- TestNG
- Log4j
- Extent Reports
- Filters

## Setup Instructions
**Clone the Repository**:
---
    git https://github.com/ujha777/APIAutomationFramework
    cd APIAutomationFramework 

**Running Tests on Terminal**:
---
     mvn clean test -Dsuite=suite -X

## Reports & Logs
-Reports: After execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs:
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project Github Actions
This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in master branch You can view the html reports at :

- [extent-report](https://github.com/ujha777/APIAutomationFramework/actions/runs/12519051887/artifacts/2366417380)
