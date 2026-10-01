# KFC India Backend API Test Automation Framework

## Project Overview

This repository contains the test automation framework for functional and regression testing of KFC India backend APIs.

The framework is being developed using Java, Playwright, TestNG, and Maven, with Allure reporting and GitHub Actions planned for continuous integration and automated execution.

The automation suite is based on API scenarios initially explored and validated using Postman. The identified scenarios are documented and managed through Jira/AIO Tests before being implemented as automated tests.

---

## Objective

To build a stable, maintainable, and high-performance API test automation framework that validates critical backend workflows supporting the KFC India digital customer journey.

The primary automation coverage includes:

- Store & Services
- Digital Menu Catalog
- Cart Management
- Basket Validation
- Tax and Price Calculations
- Pre-Checkout Validations

The framework is intended to provide repeatable automated regression coverage and early detection of API functional or structural issues.

---

## Technology Stack

| Technology | Purpose |
|------------|---------|
| Java JDK 17+ | Programming Language |
| Maven | Build and Dependency Management |
| Playwright | API Request/Response Automation |
| TestNG | Test Execution and Assertions |
| Allure | Test Reporting |
| Jira / AIO Tests | Test Case and Execution Management |
| GitHub | Source Code Management |
| GitHub Actions | CI/CD Automation |

---

## Testing Approach

The project follows the workflow below:

1. Explore and understand API behavior using Postman.
2. Identify positive, negative, boundary, and validation scenarios.
3. Document test cases and expected behavior in Jira/AIO Tests.
4. Organize test cases into functional modules and test cycles.
5. Implement automated API tests using Playwright and TestNG.
6. Add reusable framework components for API requests, configuration, data handling, and assertions.
7. Integrate Allure for execution reporting.
8. Integrate GitHub Actions for automated test execution.
9. Track failures and defects through Jira.
10. Maintain traceability between Jira test cases and automated tests.

---

## Functional Modules

### 1. Store & Services

Covers validation of:

- Store and service retrieval
- Store identification
- Authorization behavior
- Channel validation
- Service validation
- Mandatory request parameters
- HTTP status codes
- Response payload validation

### 2. Catalog

Covers validation of:

- Full menu catalog retrieval
- Menu item details
- Invalid item handling
- Store item exclusions
- Catalog response structure
- Schema and metadata completeness
- Menu item data validation

### 3. Cart

Covers validation of:

- Adding valid menu items
- Invalid item handling
- Cart quantity updates
- Cart item management
- Subtotal recalculation
- Invalid quantity validation
- Cart response structure

### 4. Basket Validation

Covers validation of:

- Out-of-stock item handling
- Item validation status
- Charity / Add Hope mapping
- Tax inclusion configuration
- Taxable base amount
- Subtotal calculations
- Tax calculations
- CGST and SGST split
- Basket validation response structure

---

## Project Structure

```text
KFC-India-Backend-API-Automation/
│
├── .github/
│   └── workflows/
│       └── api-tests.yml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/kfc/automation/
│   │           ├── clients/
│   │           ├── config/
│   │           ├── constants/
│   │           ├── models/
│   │           └── utils/
│   │
│   └── test/
│       ├── java/
│       │   └── com/kfc/automation/
│       │       ├── base/
│       │       ├── store/
│       │       ├── catalog/
│       │       ├── cart/
│       │       └── basket/
│       │
│       └── resources/
│           ├── testdata/
│           ├── schemas/
│           └── config/
│
├── pom.xml
├── testng.xml
├── README.md
└── .gitignore
