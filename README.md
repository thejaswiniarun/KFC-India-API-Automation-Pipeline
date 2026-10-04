<h1 align="center">🍗 KFC India API Test Automation</h1>

<p align="center">
  <b>A fast, reusable API test automation framework for an e-commerce customer journey</b><br>
  Java • Playwright • TestNG • Maven • Allure • GitHub Actions
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-completed-brightgreen" />
  <img src="https://img.shields.io/badge/Java-17+-blue" />
  <img src="https://img.shields.io/badge/Playwright-API%20Testing-green" />
  <img src="https://img.shields.io/badge/TestNG-Runner-red" />
  <img src="https://img.shields.io/badge/Allure-Reports-purple" />
  <img src="https://img.shields.io/badge/tests-22-informational" />
  <img src="https://img.shields.io/badge/bugs%20found-10-critical" />
</p>

---

## 👋 About This Project

An end-to-end API test suite for a food-ordering backend. It follows a real
QA workflow: **plan → design test cases → automate → run in CI → report.**

**Result at a glance:** 22 test cases executed · 12 passed · 10 defects logged
(4 Critical, 6 High/Medium). See the [Test Summary Report](docs/test-summary-report.md).

## 🧭 What It Tests

| Area | Test IDs | What is validated |
|------|----------|-------------------|
| 📍 Store & Service | `TC_STR_01–06` | Valid/invalid store, service, channel, auth header, missing parameters |
| 🍔 Menu Catalog | `TC_CAT_01–05` | Full menu, item details, invalid item, item exclusions, schema metadata |
| 🛒 Cart | `TC_CRT_01–04` | Add item, invalid item, quantity update, zero-quantity boundary |
| 🧮 Basket & Tax | `TC_BSK_001–007` | Stock validation, charity mapping, tax mode/base, subtotal, CGST/SGST split, status flags |

**Out of scope:** UI/visual checks, payment gateways/UPI/OTP, database or CRM verification.

## ✅ Pass Criteria

- Positive tests: HTTP status 200/201 and key JSON fields match expected values
- Negative tests: the API rejects invalid input with the expected 4xx status/error code
- Response time within the agreed threshold

## 🛠️ Tech Stack

Java 17+ · Maven · Playwright (API testing) · TestNG · Allure Report · GitHub Actions · Postman

## 🚀 Skills Demonstrated

- API test design (positive, negative, boundary cases)
- Dynamic data handling (sessions, cart IDs, tokens)
- Data-driven assertions and schema validation
- Performance thresholds on response times
- CI/CD pipeline setup with GitHub Actions
- Clear reporting with Allure (requests, responses, timings)
- Defect reporting with reproducible steps and evidence

## 🗓️ Progress

- [x] Scope and API exploration
- [x] Test cases designed
- [x] Framework setup
- [x] Automated test suite
- [x] CI/CD pipeline
- [x] Allure report published

## 📚 Documentation

| Document | Location |
|----------|----------|
| Test Plan | [`docs/test-plan.md`](docs/test-plan.md) |
| Test Cases | [`docs/test-cases.xlsx`](docs/test-cases.xlsx) |
| Execution Matrix & Evidence Index | [`docs/execution-matrix.md`](docs/execution-matrix.md) |
| Test Summary Report | [`docs/test-summary-report.md`](docs/test-summary-report.md) |

## 🐞 Bug Reports

10 defects were found, each documented in [`docs/bug-reports/`](docs/bug-reports/) with
steps to reproduce, expected vs. actual results, and evidence.

| ID | Title | Severity | Status |
|----|-------|----------|--------|
| [BUG-01](docs/bug-reports/BUG-01-unidentified-channel.md) | Unidentified Channel fallback allowed | High | Open |
| [BUG-02](docs/bug-reports/BUG-02-missing-parameters.md) | Missing Parameters returns 200 OK | Medium | Open |
| [BUG-03](docs/bug-reports/BUG-03-exclusions-endpoint-not-found.md) | Store Item Exclusions endpoint yields 404 | High | Open |
| [BUG-04](docs/bug-reports/BUG-04-add-item-scaled-pricing.md) | Add Valid Item returns scaled integer subtotal | Critical | Open |
| [BUG-05](docs/bug-reports/BUG-05-quantity-update-pricing.md) | Quantity Update pricing scale calculation defect | Critical | Open |
| [BUG-06](docs/bug-reports/BUG-06-zero-quantity-input-bypass.md) | Null/Zero quantity validation check failure | Critical | Open |
| [BUG-07](docs/bug-reports/BUG-07-out-of-stock-validation.md) | Out-of-stock items flagged as valid | Critical | Open |
| [BUG-08](docs/bug-reports/BUG-08-charity-mapping-wiped.md) | Charity Add Hope total mapped to 0 | High | Open |
| [BUG-09](docs/bug-reports/BUG-09-tax-inclusion-mode-error.md) | Tax-inclusive items reported as exclusive | High | Open |
| [BUG-10](docs/bug-reports/BUG-10-tax-base-calculation-zero.md) | Tax base amount returns 0 | High | Open |

## 📸 Test Evidence

Screenshots, logs, and reports from test runs are stored in [`docs/test-evidence/`](docs/test-evidence/).

| Evidence | Location |
|----------|----------|
| Postman exploration runs (passing tests) | [`docs/test-evidence/postman/`](docs/test-evidence/postman/) |
| Bug screenshots | [`docs/test-evidence/bugs/`](docs/test-evidence/bugs/) |
| Raw automation logs | [`docs/test-evidence/raw-logs/`](docs/test-evidence/raw-logs/) |
| Allure report dashboards | [`docs/test-evidence/allure-reports/`](docs/test-evidence/allure-reports/) |
| CI pipeline runs | [`docs/test-evidence/github-actions/`](docs/test-evidence/github-actions/) |

## 📁 Project Structure

```
├── docs/
│   ├── test-plan.md             # Test plan
│   ├── test-cases.xlsx          # Test case inventory
│   ├── execution-matrix.md      # Pass/fail matrix + evidence index
│   ├── test-summary-report.md   # Final summary report
│   ├── bug-reports/             # BUG-01 to BUG-10 + template
│   ├── postman/                 # Postman collection
│   └── test-evidence/           # Screenshots, raw logs, Allure & CI evidence
│       ├── postman/
│       ├── bugs/
│       ├── raw-logs/
│       ├── allure-reports/
│       └── github-actions/
├── src/test/java/               # Automation code
├── .github/workflows/           # CI pipeline
└── pom.xml                      # Maven config
```

## ▶️ Getting Started

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
