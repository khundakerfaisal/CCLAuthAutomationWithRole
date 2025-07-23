## Web Automation on CCL ERP Project Using Test NG
## Prerequisite
- Install jdk-17.0.8
- Selenium Webdriver
- TestNG Framework
- Gradle 8.5
- Install Intellij IDEA community Edition
- Allure 2.29
## About this project
This is CCL ERP Project.Here Admin can set the Authorization role for the particular users.
Here We have create regression and smoke suite also and generate test case wise report using gradle and allure report.
Purpose of this  project to set the Authorization role and credential for software access

## How to run this project
- Clone this project:```https://github.com/khundakerfaisal/CCLAuthAutomationWithRole```
- Add dependencies in build.gradle file
- Hit the following command into the terminal smoke suite: ```gradle clean test ```
- For generating Allure Report use these commands:
      ```allure generate allure-results --clean -output```
      ```allure serve allure-results```

## Report
![Allure Result 1](https://github.com/user-attachments/assets/1f03db0a-2830-4206-9c39-720ce8a44fc9)
![Allure result 2](https://github.com/user-attachments/assets/dcf74516-5854-493f-9caa-f94fef297f2b)
