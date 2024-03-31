# Playwright Training
This repository contains training materials for learning Playwright.

## Getting Started
### Prerequisites
Before starting with the training, make sure you have Java and Maven installed on your system.

- Java
- Maven
- Clone this project using Git:
```bash
 git clone https://github.com/BABASAFAE/TrainingPlaywright.git
```
### Running Tests
To run the tests, follow these steps:

- Open a terminal.
- Navigate to the project directory.
- Execute the following command:
```bash
mvn clean test -D"cucumber.filter.tags=@{tagName}" -Denv={environmentName}
```
Replace {tagName} with the specific tag name you want to execute, and {environmentName} with the desired environment.
