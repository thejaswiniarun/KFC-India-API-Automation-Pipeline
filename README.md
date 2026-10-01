<h1 align="center">🍗 KFC India Backend API Test Automation</h1>

<p align="center">
  <b>Ultra-fast, stable API test automation for the KFC India customer journey</b><br>
  Playwright • TestNG • Maven • Allure • GitHub Actions
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-planning-orange" />
  <img src="https://img.shields.io/badge/Java-17+-blue" />
  <img src="https://img.shields.io/badge/Playwright-API%20Testing-green" />
  <img src="https://img.shields.io/badge/TestNG-Runner-red" />
  <img src="https://img.shields.io/badge/Allure-Reports-purple" />
</p>

---

## 🎯 Objective

Build and validate a fast, reliable API test suite that verifies the core
customer journey on the KFC India backend, so core digital workflows stay free
of downtime and structural breakages.

## 🧭 What We Test

| Area | What is validated |
|------|-------------------|
| 📍 **Location & Session** | Session initialization with valid Indian addresses/coordinates |
| 🍔 **Menu** | JSON schema, categories (Buckets, Burgers, Snacks), non-zero prices, INR currency |
| 🛒 **Cart** | Add, edit quantity, update variants, delete items |
| 🧮 **Tax & Pricing** | Totals recalculate correctly when quantities change |
| 🧾 **Pre-Checkout** | Billing estimate validated, **stops before any payment** |

### 🚫 Out of Scope
UI/UX and visual checks · Payment gateways, UPI, OTP · Production database or CRM verification

## ✅ Pass Criteria
- HTTP status **200/201**
- Key JSON fields match expected values
- Response time stays within the agreed threshold

## 🛠️ Tech Stack

| Purpose | Tool |
|---------|------|
| Language & Build | Java 17+, Maven |
| API Automation | Playwright |
| Test Runner | TestNG |
| Reporting | Allure Report |
| Test Management | Jira, Excel |
| CI/CD | GitHub Actions |

## 🗓️ Roadmap

- [x] Scope & API exploration (Postman)
- [x] Test cases written and imported into Jira
- [ ] Framework setup (Maven, TestNG, Playwright)
- [ ] Test suite development
- [ ] CI/CD pipeline with GitHub Actions
- [ ] Allure dashboard publishing
- [ ] Final execution, evidence, and sign-off

## 📁 Repository Structure

```
├── docs/            # Test plan, test summary, strategy
├── test-cases/      # Excel test case inventory
├── postman/         # Postman collection and environments
├── src/test/java/   # Automation code (coming soon)
├── .github/workflows/  # CI/CD pipelines (coming soon)
└── pom.xml          # Maven config (coming soon)
```

## 🎯 Success Targets

| Metric | Target |
|--------|--------|
| Critical checkout flow coverage | 100% |
| Regression paths automated | > 85% |
| Final pipeline runs | 100% green |

## 🔗 Links

- 📋 Jira Project: *add link*
- 📘 Confluence Test Plan: *add link*
- 📊 Allure Report:
