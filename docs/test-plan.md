# 🧪 Test Plan: KFC India API Automation Pipeline

| | |
|---|---|
| **Author** | Thejaswini Arun |
| **Date** | 29 Sept 2026 |
| **Project** | KFC India Backend API Test Automation Framework |
| **Goal** | Ultra-fast-paced back-end testing |

## 1. Objective

Build and validate a stable, high-performance API test automation suite that verifies the core customer journey (location initialisation, menu parsing, cart management, and checkout validations) on the KFC India production backend APIs, ensuring no structural breakages in core digital workflows.

## 2. Scope

- Functional testing of public/client-facing REST endpoints powering `online.kfc.co.in`.
- Dynamic parameter extraction (sessions, cart IDs, and Bearer/CSRF tokens).
- Data-driven assertions validating menu consistency, tax math, and pricing configurations.

### 2.1 Features to Test (In Scope)

| Feature | What is covered |
|---------|-----------------|
| 📍 Location & Session Lifecycle | Session initialisation using valid Indian addresses/coordinates |
| 🍔 Digital Menu Parsing | JSON schema structure, valid categories (Buckets, Burgers, Snacks), non-zero prices, valid currency (INR) |
| 🛒 Cart Stateful Management | Add, edit quantities, update variants, and delete items via POST/PUT on virtual session carts |
| 🧮 Tax & Price Calculation | Cart totals adjust correctly when item quantities change |
| 🧾 Pre-Checkout Payloads | Final billing estimate, stopping strictly before any payment routing |

### 2.2 Out of Scope

- **UI/UX visual regression:** button alignment, CSS, animations, browser compatibility.
- **Payment gateways & real billing:** card inputs, UPI deep-linking, OTP generation, bank redirection APIs.
- **Production database integrity:** back-end databases or CRM order fulfilment.

## 3. Test Strategy

**Testing type:** Functional black-box API testing driven by programmatic assertions.

**Execution flow**

1. Draft logical boundaries and paths using Postman.
2. Document test conditions and edge cases in an Excel test case sheet.
3. Upload structured test cases into Jira (Zephyr/Xray or standard ticket import).
4. Script end-to-end API automation using Playwright integrated with the TestNG runner.
5. Hook execution to a CI pipeline triggered by code pushes.

**Pass/fail criteria:** A test passes if the HTTP status code is 200/201, key JSON fields match expected values, and response time stays within the accepted performance threshold. For negative tests, a pass means the API returns the expected 4xx status and error code.

## 4. Tools and Resources

| Purpose | Tools |
|---------|-------|
| Build & language | Maven, Java JDK 17+ |
| Testing frameworks | Playwright (API request/response automation), TestNG (execution, annotations, assertions) |
| Reporting & lifecycle | Allure Report, MS Excel, Jira |
| CI/CD | GitHub Actions |

## 5. Risks and Mitigation

| Risk | Impact | Mitigation |
|------|--------|------------|
| Testing against live production | Rate limiting or blocking | Low-volume requests, no payments, whitelisted client headers |
| Tokens/sessions expire mid-run | False failures | Extract tokens and session IDs dynamically per run |
| API changes without notice | Broken assertions | Schema validation and regular re-runs in CI |
| Sensitive data in evidence | Privacy exposure | Remove tokens, cookies, and personal data from all screenshots and logs |

## 6. Timeline

| Days | Phase | Activities |
|------|-------|------------|
| 1–2 | Scoping & design | API scanning and scope framing (Postman) |
| 2-3 | Case writing & upload | Test cases in Excel; Jira import and mapping |
| 3-5 | Code development | Framework setup (Maven, TestNG, Playwright); test suite design and request context mapping; Playwright scripting and payload parsing; Allure filter integration and assertion debugging |
| 5–7 | CI/CD linkage | GitHub Actions runner configuration; Allure report cloud setup |
| 8–10 | Pipeline & close | Execution, evidence capture, and defect tracking |

## 7. Deliverables

| Deliverable | Description |
|-------------|-------------|
| Test case inventory | Completed Excel test case sheet ([`test-cases.md`](test-cases.md)) |
| Jira requirements mapping | Test records imported and mapped under project epics |
| Source code repository | Maven framework pushed to GitHub (`/src/test/java`) |
| Visual dashboards | Allure HTML reports with embedded cURL payloads and response details |
| Defect reports | Separate bug reports for failed items ([`bug-reports/`](bug-reports/README.md)) |

## 8. Success Criteria

| Metric | Target |
|--------|--------|
| Test design coverage | 100% of defined critical checkout flows mapped in Excel |
| Automation rate | More than 85% of standard functional regression paths automated |
| Pipeline execution | 100% clean green builds on GitHub Actions for final runs |

## 9. Environment

- **Target environment:** Live production gateway for KFC India (`https://kfc.co.in`)
- **Execution agents:** Headless runners on GitHub-hosted `ubuntu-latest` VMs

## 10. Documentation Deliverables

| Artifact | Purpose |
|----------|---------|
| Test Plan (this document) | Single source of truth for scope, environment, and execution boundaries |
| Test Case Inventory ([`test-cases.md`](test-cases.md)) | All positive, negative, and edge-case scenarios with pre-conditions, steps, and expected JSON |
| Test Execution Matrix ([`execution-matrix.md`](execution-matrix.md)) | Pass/fail status of every test case with logs |
| Automated Test Evidence ([`test-evidence/`](https://github.com/thejaswiniarun/KFC-India-API-Automation-Pipeline/tree/main/docs/test-evidence)) | Allure dashboards, cURL requests, response headers, payloads, timings |
| Defect Log & Bug Reports ([`bug-reports/`](bug-reports/README.md)) | All anomalies with steps to reproduce and actual vs. expected results |
| Test Summary Report ([`test-summary-report.md`](https://github.com/thejaswiniarun/KFC-India-API-Automation-Pipeline/blob/main/docs/test-evidence/test_summary_report.md)) | Coverage, automation rate, bug counts, and quality sign-off recommendation |
