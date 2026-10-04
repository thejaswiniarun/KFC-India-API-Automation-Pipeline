# 📋 Test Summary Report

**Project:** KFC India API Test Automation
**Test period:** 2026-10-04
**Tools:** Java 17, Playwright (API), TestNG, Maven, Allure, GitHub Actions, Postman
**Scope:** Store & service, menu catalog, cart, and basket/tax APIs (no UI, payment, or database checks)

## 1. Executive Summary

22 test cases were executed across four API areas. 12 passed and 10 exposed
defects, giving a **54.5% pass rate**. Four defects are Critical (cart pricing,
zero-quantity validation, out-of-stock validation), so the cart/basket flow is
**not release-ready** until these are fixed.

## 2. Results by Module

| Module | Total | Pass | Bug | Pass % |
|--------|------:|-----:|----:|-------:|
| Store & Service (TC_STR) | 6 | 4 | 2 | 66.7% |
| Menu Catalog (TC_CAT) | 5 | 4 | 1 | 80.0% |
| Cart Management (TC_CRT) | 4 | 1 | 3 | 25.0% |
| Basket Calculation (TC_BSK) | 7 | 3 | 4 | 42.9% |
| **Total** | **22** | **12** | **10** | **54.5%** |

## 3. Defects by Severity

| Severity | Count | Bugs |
|----------|------:|------|
| Critical | 4 | BUG-04, BUG-05, BUG-06, BUG-07 |
| High | 5 | BUG-01, BUG-03, BUG-08, BUG-09, BUG-10 |
| Medium | 1 | BUG-02 |
| Low | 0 | — |

All 10 defects are **Open**. Full details: [`bug-reports/`](../bug-reports/README.md).

## 4. Key Findings

- **Weak input validation:** unknown channel, empty parameters, and invalid service values return `200 OK` instead of `400` (BUG-01, BUG-02).
- **Cart pricing:** subtotals are returned as scaled integers (`58572`, `78096`) instead of decimal currency values (BUG-04, BUG-05).
- **Boundary handling:** quantity `0` does not return the expected `400` / `BSDE002` error (BUG-06).
- **Business rules:** out-of-stock items are marked valid (`isAvailable: false`, `validStatus: true`) (BUG-07).
- **Tax and donations:** `isTaxIncludedInItemPrice` returns `false`, `itemAmountOnTaxApplied` returns `0`, and `addHopeTotal` returns `0` despite a ₹500 donation line (BUG-08, 09, 10).
- **Security observation:** the menu catalog endpoint works with an empty `Authorization` header (TC_STR_02).

## 5. What Worked Well

- Valid store, service, menu, and item-detail flows behave correctly.
- Subtotal and tax logic (TC_BSK_005) and the CGST/SGST 50/50 split (TC_BSK_006) are correct.
- Item status flags are consistent (TC_BSK_007).

## 6. Risks & Recommendations

1. Fix the Critical defects (BUG-04 to BUG-07) first; they affect cost and ordering correctness.
2. Add server-side validation for channel, service, and parameters (BUG-01, BUG-02).
3. Correct tax flag and tax base mapping before any financial reporting depends on it (BUG-09, BUG-10).
4. Review whether the menu endpoint should be public, and document the decision.
5. Re-run the full suite after fixes and add regression tests for each bug.

## 7. Evidence

- Execution matrix: [`execution-matrix.md`](execution-matrix.md)
- Screenshots, raw logs, Allure and CI runs: [`test-evidence/`](../test-evidence)

## 8. Limitations

Testing used public, client-facing endpoints at low volume, with no payments.
Results reflect the API's behaviour on the test date and may change.
