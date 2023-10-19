# Selenium Cucumber Test Automation Framework

This is a test automation framework for automated testing of Jupiter Toys website using Selenium, Cucumber, and TestNG.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)

## Features

- Cross-browser testing (Chrome, Firefox, etc.) for Application URL: http://jupiter.cloud.planittesting.com
- BDD-style test scenarios with Cucumber.
- Data-driven testing.
- Detailed HTML test reports.
- Reusable page objects and step definitions.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Apache Maven installed.
- Web browsers installed (e.g., Chrome, Firefox).

### Installation

1. Clone this repository:

   ```shell
   git clone git@github.com:ericjiang02/CucumberSeleniumTestNG.git
   ```

### Install Project Dependencies

   ```shell
   mvn clean install
   ```

## Usage

Run the tests, use the following command:

   ```shell
   mvn test
   ```
## Project Structure

- `src/main/java`: Contains your application-specific code and utility classes.
- `src/main/resources`: Contains test data, configuration files, and other resources.
- `src/test/java`: Contains your test scenarios and step definitions.
- `src/test/resources`: Contains Cucumber feature files and test runners.
- `target`: Contains generated test reports and other build artifacts.

## Test Reports

Test reports are generated in the target/surefire-reports directory.
You can view reports in your web browser after running the tests.