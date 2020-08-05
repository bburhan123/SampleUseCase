# SampleUseCase
Sample use case scenario automation using Cucumber and Selenium

# Prerequisites to execute the tests
1. JAVA
2. Maven

# Test Execution
We can execute test scenarios in the following ways

Execute using Maven commands from project folder using terminal:
To run entire suite - mvn clean test 
To run the particular test scenario/ feature file - mvn clean test -D cucumber.options="--tags @Scenario_001"

Execute using Cucumber plugin
To run all the scenarios in feature file - Right click the feature file and select run
To run the specified test scenario - Right click on the scenario from editor and select run

# Test Report
Cucumber HTML Report available in the following path - target/cucumber-html-reports/overview-features.html
