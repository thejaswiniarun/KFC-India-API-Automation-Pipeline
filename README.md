<h1 align="center">🍗 KFC India API Test Automation</h1>

<p align="center">
  <b>A fast, reusable API test automation framework for an e-commerce customer journey</b><br>
  Java • Playwright • TestNG • Maven • Allure • GitHub Actions
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-in%20progress-orange" />
  <img src="https://img.shields.io/badge/Java-17+-blue" />
  <img src="https://img.shields.io/badge/Playwright-API%20Testing-green" />
  <img src="https://img.shields.io/badge/TestNG-Runner-red" />
  <img src="https://img.shields.io/badge/Allure-Reports-purple" />
</p>

---

## 👋 About This Project

An end-to-end API test suite for a food-ordering backend. It follows a real
QA workflow: **plan → design test cases → automate → run in CI → report.**

## 🧭 What It Tests

| Area | What is validated |
|------|-------------------|
| 📍 Location & Session | Session setup using valid Indian coordinates |
| 🍔 Menu | JSON structure, categories, non-zero prices, INR currency |
| 🛒 Cart | Add, update quantity, change variants, remove items |
| 🧮 Tax & Pricing | Totals recalculate correctly when quantities change |
| 🧾 Pre-Checkout | Billing estimate validated, stops before any payment |

**Out of scope:** UI/visual checks, payment gateways/UPI/OTP, database or CRM verification.

## ✅ Pass Criteria

- HTTP status 200/201
- Key JSON fields match expected values
- Response time within the agreed threshold

## 🛠️ Tech Stack

Java 17+ · Maven · Playwright (API testing) · TestNG · Allure Report · GitHub Actions · Postman

## 🚀 Skills Demonstrated

- API test design (positive, negative, edge cases)
- Dynamic data handling (sessions, cart IDs, tokens)
- Data-driven assertions and schema validation
- Performance thresholds on response times
- CI/CD pipeline setup with GitHub Actions
- Clear reporting with Allure (requests, responses, timings)
- Defect reporting with reproducible steps and evidence

## 🗓️ Progress

- [x] Scope and API exploration
- [x] Test cases designed
- [ ] Framework setup
- [ ] Automated test suite
- [ ] CI/CD pipeline
- [ ] Allure report published

## 📚 Documentation

| Document | Location |
|----------|----------|
| Test Plan | [`docs/test-plan.md`](docs/test-plan.md) |
| Test Cases | [`docs/test-cases.xlsx`](docs/test-cases.xlsx) |
| Test Summary Report | `docs/test-summary-report.md` *(added at the end)* |

## 🐞 Bug Reports

Defects found during testing are documented in [`bug-reports/`](bug-reports/),
each with steps to reproduce, expected vs. actual results, and evidence.

| ID | Title | Severity | Status |
|----|-------|----------|--------|
| *No defects logged yet* | | | |

## 📸 Test Evidence

Screenshots and reports from test runs are stored in [`test-evidence/`](test-evidence/).

| Evidence | Location |
|----------|----------|
| Postman exploration runs | [`test-evidence/postman/`](test-evidence/postman/) |
| Allure report dashboards | [`test-evidence/allure-reports/`](test-evidence/allure-reports/) |
| CI pipeline runs | [`test-evidence/github-actions/`](test-evidence/github-actions/) |

## 📁 Project Structure

```
├── docs/                 # Test plan, test cases, summary report
├── bug-reports/          # Defect reports and template
├── test-evidence/        # Screenshots of runs and reports
├── postman/              # Postman collection
├── src/test/java/        # Automation code (coming soon)
├── .github/workflows/    # CI pipeline (coming soon)
└── pom.xml               # Maven config (coming soon)
```

## ▶️ Getting Started *(coming soon)*

```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
mvn clean test
mvn allure:serve
```

**Requirements:** Java 17+, Maven 3.8+

## ⚠️ Disclaimer

For learning and portfolio purposes only. It uses only public, client-facing
endpoints, makes low-volume requests, and never performs real payments. Not
affiliated with or endorsed by KFC or Yum! Brands. All screenshots have
tokens, cookies, and personal data removed.

---
<p align="center">Built with ☕ and a lot of fried chicken</p>
