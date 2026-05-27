# Grocery Application — Selenium Java Automation

## About this project
Automated end-to-end test suite for a Grocery web application built using **Selenium WebDriver with Java**, following the **Page Object Model (POM)** design pattern for clean and maintainable test code.

This project was developed as part of my transition from Manual Testing to Automation Testing / SDET.

---

## Tech stack
| Tool | Purpose |
|------|---------|
| Selenium WebDriver (Java) | Browser automation |
| TestNG | Test framework & assertions |
| Maven | Build & dependency management |
| Page Object Model (POM) | Test design pattern |
| Git & GitHub | Version control |

---

## Test scenarios covered
- User login and logout
- Product search functionality
- Add to cart and remove from cart
- Quantity update validation
- Checkout flow
- Form field validations (empty fields, invalid inputs)
- UI element visibility checks

---

## Project structure
GroceryProject/
├── src/
│   ├── main/java/pages/        # Page Object classes
│   └── test/java/tests/        # Test classes
├── test-output/                 # TestNG reports
├── testng.xml                   # TestNG suite configuration
├── crossBrowser.xml             # Cross browser test config
├── parallel.xml                 # Parallel execution config
└── pom.xml                      # Maven dependencies
