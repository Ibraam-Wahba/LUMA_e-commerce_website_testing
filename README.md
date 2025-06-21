# LUMA_e-commerce_website_testing
LUMA E-commerce Testing

1. Project Overview

This project includes both manual and automated testing for the demo e-commerce website LUMA (https://magento.softwaretestingboard.com/). It covers core test cases such as user registration, login, product search, adding products to the cart, and completing a purchase.

2. Technologies Used

- Java 23  
- Selenium WebDriver  
- TestNG  
- WebDriverManager  
- Maven  
- IntelliJ IDEA (development environment)

3. How to Run the Project

Follow these steps to run the project:

1. Clone the project from GitHub:

git clone https://github.com/Ibraam-Wahba/LUMA_e-commerce_website_testing.git

2. Open IntelliJ IDEA and choose "Open" to select the project folder

3. IntelliJ will automatically import the Maven dependencies

4. To run the tests:

- Run via testng.xml file if available  
- Or right-click on any test class and choose "Run"  
- Or use the Maven command:

mvn test

4. Project Dependencies

All dependencies are managed in the pom.xml file. Main libraries used:

- selenium-java  
- testng  
- webdrivermanager  

5. Manual Test Cases

Manual testing was performed for the following features:

- User Registration  
- User Login  
- Product Search  
- Adding Items to Cart  
- Input Validation  
- Basic Security Testing (XSS attempt)

6. Notes

- This project is built for testing purposes only on a public demo site  
- Do not use any real or sensitive user data  

7. Additional Files

The repository includes supporting Excel files related to:

- Test cases design covering critical paths and edge cases  
- Bug reports for detected issues  
- Basic security validation with a focus on:
  - Input validation  
  - Common injection vulnerabilities (e.g., SQL injection, XSS)  
